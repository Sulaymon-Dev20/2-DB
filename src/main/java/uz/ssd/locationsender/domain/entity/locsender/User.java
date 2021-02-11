package uz.ssd.locationsender.domain.entity.locsender;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import uz.ssd.locationsender.domain.entity.locsender.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Collection;

/**
 * Author: Khumoyun Khujamov
 * Date: 9/9/20
 * Time: 1:02 PM
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User  extends BaseEntity implements UserDetails {
    @Column(unique = true, nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String password;

    private String email;

    private Boolean deleted;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return this.phoneNumber;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.deleted;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.deleted;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.deleted;
    }

    @Override
    public boolean isEnabled() {
        return !this.deleted;
    }
}
