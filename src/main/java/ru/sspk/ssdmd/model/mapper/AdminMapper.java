package ru.sspk.ssdmd.model.mapper;

import ru.sspk.ssdmd.model.dto.AdminDto;
import ru.sspk.ssdmd.model.entity.Admin;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AdminMapper {

    public static AdminDto toDto(Admin admin) {

        AdminDto adminDto = new AdminDto.Builder()
                .setId(admin.getId())
                .setLogin(admin.getLogin())
                .build();

        return adminDto;
    }

    public Admin toEntity(AdminDto adminDto) {

        Admin admin = new Admin.Builder()
                .setId(adminDto.getId())
                .setLogin(adminDto.getLogin())
                .build();

        return admin;
    }

    public static List<AdminDto> toListAdmin(List<Admin> adminList) {

        return new ArrayList<>((adminList).stream().map(AdminMapper::toDto)
                .collect(Collectors.toList()));
    }
}
