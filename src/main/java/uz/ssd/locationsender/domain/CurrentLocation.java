package uz.ssd.locationsender.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * Author: Khumoyun Khujamov
 * Date: 9/9/20
 * Time: 12:08 PM
 */
@Document("curloc")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrentLocation {
    public String trackerid;

    public Integer speed;

    public Location loc;

    @JsonFormat(pattern="yyyy.MM.dd HH:mm:ss")
    public Date systemtime;

    public Bus bus;

    private Integer isline;
}
