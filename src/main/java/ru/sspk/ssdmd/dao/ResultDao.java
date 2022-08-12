package ru.sspk.ssdmd.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sspk.ssdmd.model.entity.Result;

import java.util.List;

public interface ResultDao extends JpaRepository<Result, Long> {
    List<Result> getByPersonListUsersLogin(String login);
}
