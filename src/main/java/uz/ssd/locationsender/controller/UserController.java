package uz.ssd.locationsender.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.ssd.locationsender.config.CronConfig;
import uz.ssd.locationsender.dto.Response;
import uz.ssd.locationsender.dto.Status;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    CronConfig cronConfig;

    @Scheduled(cron = "0/20 * * * * *")
    @GetMapping
    public HttpEntity<?> getAllUsers(){
        Response response = new Response();
        response.setStatus(new Status(0, "success"));
        response.setData(cronConfig.getAll());
        return ResponseEntity.ok(response);
    }
}
