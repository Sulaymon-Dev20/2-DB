package uz.ssd.locationsender.domain.entity.asdum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Author: Khumoyun Khujamov
 * Date: 10/19/20
 * Time: 2:32 PM
 */
@Entity
@Table(name = "marshrut")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Marshrut {
    @Id
    private Integer id;

    @Column(name = "name")
    private String name;
}
