package uz.ssd.locationsender.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uz.ssd.locationsender.config.CounterFilter;
import uz.ssd.locationsender.domain.entity.locsender.User;
import uz.ssd.locationsender.repository.locsender.UserRepository;

import java.util.Date;
import java.util.Map;

/**
 * Author: Khumoyun Khujamov
 * Date: 9/12/20
 * Time: 5:46 PM
 */
@Service
public class DefaultUserService {
    private final UserRepository userRepository;
    public static final Logger LOGGER = LoggerFactory.getLogger(DefaultUserService.class);

    public DefaultUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // This method executes in every 5 minutes
    @Scheduled(fixedRate = 300000)
    public void saveRequestCount() {

        for (Map.Entry<Long, Long> entry : CounterFilter.counter.entrySet()) {
            Long userId = entry.getKey();
            User user = userRepository.findById(userId).orElseThrow(() -> new UsernameNotFoundException("User with id " + userId + "not found"));
            Long updatedReqCount = user.getReqCount() + entry.getValue();
            user.setReqCount(updatedReqCount);
            user.setUpdatedDate(new Date());
            userRepository.save(user);
        }
        CounterFilter.counter.clear();
    }
}
