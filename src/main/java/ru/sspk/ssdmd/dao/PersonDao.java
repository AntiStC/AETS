package ru.sspk.ssdmd.dao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonDao extends JpaRepository<Person, Long> {
}
