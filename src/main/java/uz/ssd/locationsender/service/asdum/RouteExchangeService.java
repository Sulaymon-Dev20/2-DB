package uz.ssd.locationsender.service.asdum;

import org.springframework.stereotype.Service;
import uz.ssd.locationsender.domain.entity.asdum.Bus;
import uz.ssd.locationsender.repository.asdum.RouteExchRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Author: Khumoyun Khujamov
 * Date: 10/18/20
 * Time: 6:11 PM
 */
@Service
public class RouteExchangeService {
    private final RouteExchRepository repository;

    private final BusService busService;

    public RouteExchangeService(RouteExchRepository repository, BusService busService) {
        this.repository = repository;
        this.busService = busService;
    }

    public boolean checkBusByRouteExch(String gosNo) {
        LocalDateTime startOfDay = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
        Bus busByGosNo = busService.getBusByGosNo(gosNo);
        return repository.existsByFactAndDate(busByGosNo.getId(), LocalDateTime.now());
    }
}
