package ru.sspk.ssdmd.config;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {

    // TODO сюда инджектим сервис по которому потом найдем юзера и отправим его

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO ищем нашего юзера из БД по логину и возвращаем его
        return null;
    }
}
