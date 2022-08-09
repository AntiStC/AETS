package ru.sspk.ssdmd.model.mapper;

import ru.sspk.ssdmd.model.dto.RoleUserDto;
import ru.sspk.ssdmd.model.dto.UserDto;
import ru.sspk.ssdmd.model.entity.RoleUser;
import ru.sspk.ssdmd.model.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RoleUserMapper {
    public static RoleUserDto toDto(RoleUser roleUser) {

        Set<UserDto> userDtoList = roleUser.getUsers().stream()
                .map(UserMapper::toDto).collect(Collectors.toSet());

        RoleUserDto roleUserDto = new RoleUserDto.Builder()
                .setId(roleUser.getId())
                .setName(roleUser.getName())
                .setUsers(userDtoList)
                .build();

        return roleUserDto;
    }

    public static RoleUser toEntity(RoleUserDto roleUserDto) {

        Set<User> userSet = roleUserDto.getUsers().stream()
                .map(UserMapper::toEntity).collect(Collectors.toSet());

        RoleUser roleUser = new RoleUser.Builder()
                .setId(roleUserDto.getId())
                .setName(roleUserDto.getName())
                .setUsers(userSet)
                .build();

        return roleUser;
    }

    public static List<RoleUserDto> toListRoleUser(List<RoleUser> roleUserList) {

        return new ArrayList<>((roleUserList).stream().map(RoleUserMapper::toDto)
                .collect(Collectors.toList()));
    }
}
