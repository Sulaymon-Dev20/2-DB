package uz.ssd.locationsender.config;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class CronConfig {

//    @Autowired
//    UserRepository userRepository;

//    @Scheduled(cron = "1/15 * * * *")
//    @Cacheable(cacheNames = {"user_cache"})
    public void getAll(){
//        System.out.println("Get All Users");
//        List<User> userList = userRepository.findAll();
//        return userList;
        System.out.println("Hello ");
    }

}
