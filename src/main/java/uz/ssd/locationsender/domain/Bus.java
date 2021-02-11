package uz.ssd.locationsender.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Author: Khumoyun Khujamov
 * Date: 10/26/20
 * Time: 12:33 PM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bus implements Serializable {
    public String gosno;
}
