package uz.ssd.locationsender.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import uz.ssd.locationsender.config.SecurityConfig;
import uz.ssd.locationsender.domain.entity.User;
import uz.ssd.locationsender.dto.ReqSignIn;
import uz.ssd.locationsender.dto.Response;
import uz.ssd.locationsender.dto.Status;
import uz.ssd.locationsender.repository.UserRepository;
import uz.ssd.locationsender.service.security.AuthService;
import uz.ssd.locationsender.service.security.JwtTokenProvider;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Author: Khumoyun Khujamov
 * Date: 9/9/20
 * Time: 10:30 AM
 */
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final ObjectMapper objectMapper;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;
    private final SecurityConfig securityConfig;
    private final AuthService authService;
    @Value("${app.jwtExpirationInMs}")
    private long accessTokenDate;
    @Autowired
    public AuthController(ObjectMapper objectMapper, AuthenticationManager authenticationManager,
                          JwtTokenProvider jwtTokenProvider, UserRepository userRepository,
                          SecurityConfig securityConfig, AuthService authService) {
        this.objectMapper = objectMapper;
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userRepository = userRepository;
        this.securityConfig = securityConfig;
        this.authService = authService;
    }


    @PostMapping("login")
    public HttpEntity<?> login(@Valid @RequestBody ReqSignIn reqSignIn){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String expireDateTime = LocalDateTime.now().plusDays(2).format(dateTimeFormatter);
        ObjectNode data = objectMapper.createObjectNode();
        Response response = new Response();
        Status status;

        User byUsername = userRepository.findByUsername(reqSignIn.getUsername());
        if (byUsername!=null && securityConfig.matchPassword(reqSignIn.getPassword(), byUsername.getPassword())) {

            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(reqSignIn.getUsername(), reqSignIn.getPassword())
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            status = new Status(0, "success");
            String jwt = jwtTokenProvider.generateToken(authentication);
            String refreshToken = jwtTokenProvider.generateRefreshToken(authentication);
            data.put("accessToken", jwt);
            data.put("refreshToken", refreshToken);
            data.put("tokenType","Bearer ");
            data.put("expiryDate",expireDateTime);
        }else {
            status = new Status(1001, "username or password incorrect");
        }

        response.setStatus(status);
        response.setData(data);
        return ResponseEntity.ok(response);
    }

    @PostMapping("token/refresh")
    public HttpEntity<?> getAccessToken( @RequestParam(name = "token") String refreshToken ){
        ObjectNode data = objectMapper.createObjectNode();

        if (StringUtils.hasText(refreshToken) ) {
            String userId = jwtTokenProvider.getUserIdFromJWT(refreshToken);

            UserDetails userDetails = authService.loadUserById(Long.parseLong(userId));

            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

            String accessToken = jwtTokenProvider.generateToken(authentication);
            String refreshToken1 = jwtTokenProvider.generateRefreshToken(authentication);
            data.put("accessToken",accessToken);
            data.put("tokenType","Bearer ");
            data.put("expiryDate",accessTokenDate);
            return ResponseEntity.status(HttpStatus.OK).body(data);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
    }
}
