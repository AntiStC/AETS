package ru.sspk.ssdmd.model.mapper;

import ru.sspk.ssdmd.model.dto.RoleUserDto;
import ru.sspk.ssdmd.model.entity.RoleUser;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RoleUserMapper {
    public static RoleUserDto toDto(RoleUser roleUser) {

        RoleUserDto roleUserDto = new RoleUserDto.Builder()
                .setId(roleUser.getId())
                .setName(roleUser.getName())
                .build();

        return roleUserDto;
    }

    public static RoleUser toEntity(RoleUserDto roleUserDto) {


        RoleUser roleUser = new RoleUser.Builder()
                .setId(roleUserDto.getId())
                .setName(roleUserDto.getName())
                .build();

        return roleUser;
    }

    public static List<RoleUserDto> toListRoleUser(List<RoleUser> roleUserList) {

        return new ArrayList<>((roleUserList).stream().map(RoleUserMapper::toDto)
                .collect(Collectors.toList()));
    }
}
