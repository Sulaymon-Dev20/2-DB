package uz.ssd.locationsender.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import uz.ssd.locationsender.domain.entity.locsender.User;
import uz.ssd.locationsender.repository.locsender.UserRepository;

import java.util.List;

@Service
public class CronConfig {

    @Autowired
    UserRepository userRepository;

//    @Scheduled(cron = "1/15 * * * *")
    @Cacheable(cacheNames = {"user_cache"})
    public List<User> getAll(){
        System.out.println("Get All Users");
        List<User> userList = userRepository.findAll();
        return userList;
    }

}
