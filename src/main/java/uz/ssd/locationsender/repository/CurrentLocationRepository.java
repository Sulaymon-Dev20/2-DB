package uz.ssd.locationsender.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import uz.ssd.locationsender.domain.CurrentLocation;

import java.util.List;

/**
 * Author: Khumoyun Khujamov
 * Date: 9/9/20
 * Time: 1:46 PM
 */
public interface CurrentLocationRepository extends MongoRepository<CurrentLocation,String> {
    List<CurrentLocation> findAllByIsline(Integer number);
}
