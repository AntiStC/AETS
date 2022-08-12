package ru.sspk.ssdmd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sspk.ssdmd.dao.PersonDao;
import ru.sspk.ssdmd.model.dto.PersonDto;
import ru.sspk.ssdmd.model.mapper.PersonMapper;
import ru.sspk.ssdmd.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {
    private final PersonDao personDao;

    @Autowired
    public PersonServiceImpl(PersonDao personDao) {
        this.personDao = personDao;
    }
    @Override
    public PersonDto getByUserLogin(String login) {
        return PersonMapper.toDto(personDao.getByUsersLogin(login));
    }
}
