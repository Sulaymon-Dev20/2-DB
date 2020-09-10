package uz.ssd.locationsender.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Author: Khumoyun Khujamov
 * Date: 9/9/20
 * Time: 12:08 PM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location {
    public List<Double> coordinates;
}
