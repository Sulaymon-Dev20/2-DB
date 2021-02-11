package uz.ssd.locationsender.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.ssd.locationsender.dto.Response;
import uz.ssd.locationsender.dto.Status;
import uz.ssd.locationsender.service.LocationService;

/**
 * Author: Khumoyun Khujamov
 * Date: 9/9/20
 * Time: 11:43 AM
 */
@RestController
@RequestMapping("/api/loc")
public class LocationController {

    private final LocationService service;

    @Autowired
    public LocationController(LocationService service) {
        this.service = service;
    }



    @GetMapping
    public HttpEntity<?> getLocation() {
        Response response = new Response();
        response.setStatus(new Status(0, "success"));
        response.setData(service.getCurLoc());
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public HttpEntity<?> getLocationOld() {
        Response response = new Response();
        response.setStatus(new Status(0, "success"));
        response.setData(service.getCurLoc());
        return ResponseEntity.ok(response);
    }
}
