package uz.ssd.locationsender.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Author: Khumoyun Khujamov
 * Date: 9/12/20
 * Time: 5:46 PM
 */
@Service
public class DefaultUserService {
//    private final UserRepository userRepository;
    public static final Logger LOGGER = LoggerFactory.getLogger(DefaultUserService.class);

//    public DefaultUserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    // This method executes in every 5 minutes
//    @Scheduled(fixedRate = 300000)
    public void saveRequestCount() {
//        for (Map.Entry<Long, Long> entry : CounterFilter.counter.entrySet()) {
//            Long userId = entry.getKey();
//            User user = userRepository.findById(userId).orElseThrow(() -> new UsernameNotFoundException("User with id " + userId + "not found"));
//            user.setUpdatedDate(new Date());
//            userRepository.save(user);
//        }
//        CounterFilter.counter.clear();
        //
    }
}
