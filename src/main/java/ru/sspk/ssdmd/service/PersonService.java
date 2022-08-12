package ru.sspk.ssdmd.service;

import ru.sspk.ssdmd.dao.PersonDao;
import ru.sspk.ssdmd.model.dto.PersonDto;

public interface PersonService {
    PersonDto getByUserLogin(String login);
}
