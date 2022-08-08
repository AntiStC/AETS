package ru.sspk.ssdmd.model.mapper;

import ru.sspk.ssdmd.model.dto.PersonDto;
import ru.sspk.ssdmd.model.dto.UserDto;
import ru.sspk.ssdmd.model.entity.Person;
import ru.sspk.ssdmd.model.entity.User;

import java.util.List;

public class PersonMapper {
    public static PersonDto toDto(Person person){
        List<UserDto> userDtoList = person.getUsers().stream()
                .map(UserMapper::toDto).toList();
        return new PersonDto.Builder()
                .setId(person.getId())
                .setFirstName(person.getFirstName())
                .setLastName(person.getLastName())
                .setMiddleName(person.getMiddleName())
                .setEmail(person.getEmail())
                .setDepartment(person.getDepartment())
                .setChief(person.getChief())
                .setUserDtos(userDtoList)
                .build();
    }

    public static Person toEntity(PersonDto personDto){
        List<User> userList = personDto.getUserDtos().stream()
                .map(UserMapper::toEntity).toList();
        return new Person.Builder()
                .setId(personDto.getId())
                .setFirstName(personDto.getFirstName())
                .setLastName(personDto.getLastName())
                .setMiddleName(personDto.getMiddleName())
                .setEmail(personDto.getEmail())
                .setDepartment(personDto.getDepartment())
                .setChief(personDto.getChief())
                .setUsers(userList)
                .build();
    }
}
