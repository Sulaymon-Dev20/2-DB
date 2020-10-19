package uz.ssd.locationsender.domain.entity.asdum;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Author: Khumoyun Khujamov
 * Date: 10/16/20
 * Time: 6:52 PM
 */
@Entity
@Table(name = "route_exch")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RouteExchange {

    @Id
    private Integer id;

    @Column(name = "fact")
    private Integer fact;

    @Column(name = "date")
    private LocalDateTime date;
}
