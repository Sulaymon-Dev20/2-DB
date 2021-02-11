package uz.ssd.locationsender.repository.locsender;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.ssd.locationsender.domain.entity.locsender.Stol;

@Repository
public interface StolRepository extends JpaRepository<Stol, Integer> {
}
