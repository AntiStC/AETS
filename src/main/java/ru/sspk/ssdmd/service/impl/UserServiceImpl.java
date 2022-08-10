package ru.sspk.ssdmd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.sspk.ssdmd.dao.UserDao;
import ru.sspk.ssdmd.model.dto.UserDto;
import ru.sspk.ssdmd.model.entity.User;
import ru.sspk.ssdmd.model.mapper.UserMapper;
import ru.sspk.ssdmd.service.UserService;

import javax.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public UserDto findByLogin(String login) {
        User user = userDao.findByLogin(login);
        if (user != null) return UserMapper.toDto(user);
        throw new UsernameNotFoundException("User `" + login + "` - not found!");
    }

    @Override
    public UserDto save(UserDto userDto) {
        return UserMapper.toDto(userDao.save(UserMapper.toEntity(userDto)));
    }
}
