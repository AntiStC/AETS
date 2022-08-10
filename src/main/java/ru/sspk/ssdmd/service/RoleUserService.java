package ru.sspk.ssdmd.service;

import ru.sspk.ssdmd.model.dto.RoleUserDto;
import ru.sspk.ssdmd.model.entity.RoleUser;

public interface RoleUserService {

    RoleUserDto save(RoleUserDto roleUserDto);

    RoleUserDto findByName(String name);

}
