package ru.sspk.ssdmd.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sspk.ssdmd.model.entity.Person;

public interface PersonDao extends JpaRepository<Person, Long> {
    Person getByFirstName(String firstName);
    Person getByUsersLogin(String login);
}
