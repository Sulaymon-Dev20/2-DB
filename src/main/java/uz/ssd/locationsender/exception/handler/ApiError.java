package uz.ssd.locationsender.exception.handler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * Author: Khumoyun Khujamov
 * Date: 10/18/20
 * Time: 6:04 PM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiError {
    private HttpStatus status;
    private String message;
}
