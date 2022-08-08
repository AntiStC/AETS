package ru.sspk.ssdmd.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sspk.ssdmd.model.entity.User;

public interface UserDao extends JpaRepository<User, Long> {
}
