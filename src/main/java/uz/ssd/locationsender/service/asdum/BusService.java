package uz.ssd.locationsender.service.asdum;

import org.springframework.stereotype.Service;
import uz.ssd.locationsender.domain.entity.asdum.Bus;
import uz.ssd.locationsender.exception.EntityNotFoundException;
import uz.ssd.locationsender.repository.asdum.BusRepository;

/**
 * Author: Khumoyun Khujamov
 * Date: 10/18/20
 * Time: 5:09 PM
 */
@Service
public class BusService {

    private final BusRepository repository;

    public BusService(BusRepository repository) {
        this.repository = repository;
    }

    public Bus getBusByGosNo(String gosNo) {
        return repository.findByGosNo(gosNo).orElseThrow(() -> new EntityNotFoundException("Could not find bus with gosNo " + gosNo));
    }
}
