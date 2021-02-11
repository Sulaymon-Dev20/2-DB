package uz.ssd.locationsender.repository.asdum;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.ssd.locationsender.domain.entity.asdum.Stolcha;

@Repository
public interface StolchaRepository extends JpaRepository<Stolcha, Integer> {
}
