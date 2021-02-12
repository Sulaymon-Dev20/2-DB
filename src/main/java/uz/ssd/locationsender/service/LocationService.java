package uz.ssd.locationsender.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.query.Criteria;
//import org.springframework.data.mongodb.core.query.Query;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import uz.ssd.locationsender.domain.CurrentLocation;
import uz.ssd.locationsender.repository.CurrentLocationRepository;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Author: Khumoyun Khujamov
 * Date: 9/9/20
 * Time: 4:49 PM
 */

@Service
public class LocationService {
//    private final CurrentLocationRepository repository;
//    private final MongoTemplate mongoTemplate;


/*    @Autowired
    public LocationService(CurrentLocationRepository repository, MongoTemplate mongoTemplate) {
        this.repository = repository;
        this.mongoTemplate = mongoTemplate;

    }*/
//    @Scheduled(cron = "0/5 * * * * *")
//    @Cacheable(cacheNames = {"location_cache"})
    public void getCurLoc() {
//        Query query = new Query();
//        query.addCriteria(Criteria.where("isline").is(1));
//        List<CurrentLocation> objects = mongoTemplate.find(query, CurrentLocation.class);
//        Set<String> collectionNames = mongoTemplate.getCollectionNames();
//        return repository.findAllByIslineAndGpsstatus(1,"A");
        System.out.println("Get Bus Location");
//        return repository.findAllByGpsstatus("A");

    }


}
