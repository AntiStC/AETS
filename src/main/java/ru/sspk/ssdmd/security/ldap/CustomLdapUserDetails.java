package ru.sspk.ssdmd.security.ldap;

import org.springframework.core.env.Environment;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.ldap.userdetails.LdapUserDetails;

import java.util.Collection;
import java.util.Set;

public class CustomLdapUserDetails implements LdapUserDetails {

    private static final long serialVersionUID = 1L;

    private LdapUserDetails details;
//    private Environment env;

    public CustomLdapUserDetails(LdapUserDetails details) {
        this.details = details;
        //this.env = env;
    }

    public boolean isEnabled() {
        return true; //details.isEnabled() && getUsername().equals(env.getRequiredProperty("ldap.username"));
    }

    public String getDn() {
        return details.getDn();
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Set.of(new SimpleGrantedAuthority("ROLE_USER"));//details.getAuthorities();
    }

    public String getPassword() {
        return details.getPassword();
    }

    public String getUsername() {
        return details.getUsername();
    }

    public boolean isAccountNonExpired() {
        return details.isAccountNonExpired();
    }

    public boolean isAccountNonLocked() {
        return details.isAccountNonLocked();
    }

    public boolean isCredentialsNonExpired() {
        return details.isCredentialsNonExpired();
    }

    @Override
    public void eraseCredentials() {

    }
}
