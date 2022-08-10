package ru.sspk.ssdmd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sspk.ssdmd.dao.RoleUserDao;
import ru.sspk.ssdmd.model.dto.RoleUserDto;
import ru.sspk.ssdmd.model.entity.RoleUser;
import ru.sspk.ssdmd.model.mapper.RoleUserMapper;
import ru.sspk.ssdmd.service.RoleUserService;

@Service
public class RoleUserServiceImpl implements RoleUserService {

    private RoleUserDao roleUserDao;

    @Autowired
    public RoleUserServiceImpl(RoleUserDao roleUserDao) {
        this.roleUserDao = roleUserDao;
    }

    @Override
    public RoleUserDto save(RoleUserDto roleUserDto) {
        RoleUser roleUser = RoleUserMapper.toEntity(roleUserDto);
        roleUser = roleUserDao.save(roleUser);
        return RoleUserMapper.toDto(roleUser);
    }

    @Override
    public RoleUserDto findByName(String name) {
        RoleUser roleUser = roleUserDao.findByName(name);
        if (roleUser != null) {
            return RoleUserMapper.toDto(roleUser);
        } else
        {
            new IllegalArgumentException("Role `" + name + "` - not found!");
            return null;
        }
    }
}
