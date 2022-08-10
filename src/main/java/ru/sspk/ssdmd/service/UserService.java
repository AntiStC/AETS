package ru.sspk.ssdmd.service;

import ru.sspk.ssdmd.model.dto.UserDto;

public interface UserService {

    UserDto findByLogin(String login);

    UserDto save(UserDto userDto);

}
