package ru.sspk.ssdmd.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.sspk.ssdmd.model.dto.UserDto;
import ru.sspk.ssdmd.model.entity.User;
import ru.sspk.ssdmd.model.mapper.UserMapper;
import ru.sspk.ssdmd.security.jdbc.UserDetail;
import ru.sspk.ssdmd.service.UserService;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDto userDto = userService.findByLogin(username);
        User user = UserMapper.toEntity(userDto);
        UserDetail userDetail = new UserDetail(user);
        return userDetail;
    }
}
