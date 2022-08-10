package ru.sspk.ssdmd.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sspk.ssdmd.model.entity.Test;

public interface TestDao extends JpaRepository<Test, Long> {
    Test findByName(String name);

}
