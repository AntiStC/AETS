package ru.sspk.ssdmd.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sspk.ssdmd.model.entity.User;

import java.util.List;

public interface UserDao extends JpaRepository<User, Long> {
    User findByLogin(String userName);
}
