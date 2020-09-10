package uz.ssd.locationsender.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author: Khumoyun Khujamov
 * Date: 9/9/20
 * Time: 2:07 PM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {
    private Object data;
    private Status status;
}
