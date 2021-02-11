package uz.ssd.locationsender.repository.locsender;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.ssd.locationsender.domain.entity.locsender.User;

/**
 * Author: Khumoyun Khujamov
 * Date: 9/9/20
 * Time: 1:23 PM
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

}
