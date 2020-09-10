package uz.ssd.locationsender.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author: Khumoyun Khujamov
 * Date: 9/9/20
 * Time: 2:08 PM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Status {
    private int code;
    private Object message;
}
