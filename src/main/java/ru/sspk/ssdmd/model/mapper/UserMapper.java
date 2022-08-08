package ru.sspk.ssdmd.model.mapper;

import ru.sspk.ssdmd.model.dto.RoleUserDto;
import ru.sspk.ssdmd.model.dto.UserDto;
import ru.sspk.ssdmd.model.entity.RoleUser;
import ru.sspk.ssdmd.model.entity.User;

import java.util.Set;
import java.util.stream.Collectors;

public class UserMapper {
    public static UserDto toDto(User user) {
        Set<RoleUserDto> roleUserDtoSet = user.getRoles().stream()
                .map(RoleUserMapper::toDto).collect(Collectors.toSet());
        return new UserDto.Builder()
                .setId(user.getId())
                .setLogin(user.getLogin())
                .setPassword(user.getPassword())
                .setRoles(roleUserDtoSet)
                .build();
    }

    public static User toEntity(UserDto userDto) {
        Set<RoleUser> roleUserSet = userDto.getRoles().stream()
                .map(RoleUserMapper::toEntity).collect(Collectors.toSet());
        return new User.Builder()
                .setId(userDto.getId())
                .setLogin(userDto.getLogin())
                .setPassword(userDto.getPassword())
                .setRoles(roleUserSet)
                .build();
    }
}
