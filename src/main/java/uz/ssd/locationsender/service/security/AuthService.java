/*
package uz.ssd.locationsender.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uz.ssd.locationsender.domain.entity.locsender.User;
import uz.ssd.locationsender.repository.locsender.UserRepository;


@Service
public class AuthService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user != null){
            return (UserDetails) user;
        }else {
            return (UserDetails) ResponseEntity.status(HttpStatus.CONFLICT).body(username + "is not found");
        }
    }

    public UserDetails loadUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new UsernameNotFoundException("User id not found: " +userId));
    }
}
*/
