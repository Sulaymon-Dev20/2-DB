package uz.ssd.locationsender.repository.asdum;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.ssd.locationsender.domain.entity.asdum.RouteExchange;

import java.time.LocalDateTime;

/**
 * Author: Khumoyun Khujamov
 * Date: 10/17/20
 * Time: 1:21 AM
 */
@Repository
public interface RouteExchRepository extends JpaRepository<RouteExchange, Integer> {
    boolean existsByFactAndDate(Integer busId, LocalDateTime dateTime);
}
