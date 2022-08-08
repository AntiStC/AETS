package ru.sspk.ssdmd.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sspk.ssdmd.model.entity.Result;

public interface ResultDao extends JpaRepository<Result, Long> {
}
