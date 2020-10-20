package uz.ssd.locationsender.domain.entity.asdum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Author: Khumoyun Khujamov
 * Date: 9/9/20
 * Time: 12:07 PM
 */
@Entity
@Table(name = "bus")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bus {

    @Id
    private Integer id;

    @Column(name = "gos")
    private String gosNo;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "marshrut_id")
    private Marshrut marshrut;
}
