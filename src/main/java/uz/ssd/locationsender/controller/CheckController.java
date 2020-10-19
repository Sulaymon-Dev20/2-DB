package uz.ssd.locationsender.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.ssd.locationsender.domain.entity.asdum.Bus;
import uz.ssd.locationsender.dto.Response;
import uz.ssd.locationsender.dto.Status;
import uz.ssd.locationsender.service.asdum.BusService;
import uz.ssd.locationsender.service.asdum.RouteExchangeService;

import javax.validation.constraints.NotBlank;

/**
 * Author: Khumoyun Khujamov
 * Date: 10/18/20
 * Time: 6:10 PM
 */
@RestController
@RequestMapping("/api/check")
public class CheckController {

    private final RouteExchangeService routeExchangeService;

    private final BusService busService;

    public CheckController(RouteExchangeService routeExchangeService, BusService busService) {
        this.routeExchangeService = routeExchangeService;
        this.busService = busService;
    }

    @GetMapping("/gosNo")
    public HttpEntity<?> checkBusByGosNo(@RequestParam(name = "gosNo") @NotBlank String gosNo) {
        Response response = new Response();
        Bus busByGosNo = busService.getBusByGosNo(gosNo);
        String name = busByGosNo.getMarshrut().getName();
        response.setData("Bus is working");
        response.setStatus(new Status(1, name));
        return ResponseEntity.ok(response);
    }


//    @GetMapping("/gosNo")
//    public HttpEntity<?> checkBusByGosNo(@RequestParam(name = "gosNo") @NotBlank String gosNo) {
//        Response response = new Response();
//        boolean result = routeExchangeService.checkBusByRouteExch(gosNo);
//        if (result) {
//            response.setStatus(new Status(0, "success"));
//            response.setData("Bus is working");
//            return ResponseEntity.ok(response);
//        }
//        response.setStatus(new Status(1001, "fail"));
//        response.setData("Bus is not working");
//        return ResponseEntity.ok(response);
//    }
}
