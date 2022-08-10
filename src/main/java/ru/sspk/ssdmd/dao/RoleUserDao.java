package ru.sspk.ssdmd.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sspk.ssdmd.model.entity.RoleUser;

public interface RoleUserDao extends JpaRepository<RoleUser, Long> {
    RoleUser findByName(String name);
}
