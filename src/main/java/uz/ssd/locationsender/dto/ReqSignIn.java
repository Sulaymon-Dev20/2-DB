package uz.ssd.locationsender.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * Author: Khumoyun Khujamov
 * Date: 9/9/20
 * Time: 2:09 PM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReqSignIn {
    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
