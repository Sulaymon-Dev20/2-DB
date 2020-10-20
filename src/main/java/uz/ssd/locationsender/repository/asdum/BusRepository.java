package uz.ssd.locationsender.repository.asdum;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.ssd.locationsender.domain.entity.asdum.Bus;

import java.util.Optional;

/**
 * Author: Khumoyun Khujamov
 * Date: 10/17/20
 * Time: 1:18 AM
 */
@Repository
public interface BusRepository extends JpaRepository<Bus, Integer> {
    Optional<Bus> findByGosNoAndDeleted(String gosNo, Boolean deleted);
}
