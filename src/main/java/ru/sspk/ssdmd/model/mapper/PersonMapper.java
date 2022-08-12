package ru.sspk.ssdmd.model.mapper;

import ru.sspk.ssdmd.model.dto.PersonDto;
import ru.sspk.ssdmd.model.dto.UserDto;
import ru.sspk.ssdmd.model.entity.Person;
import ru.sspk.ssdmd.model.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PersonMapper {
    public static PersonDto toDto(Person person) {

        List<UserDto> userDtoList = null;
        if (person.getUsers() != null) {
            userDtoList = person.getUsers().stream()
                    .map(UserMapper::toDto).toList();
        }


        PersonDto personDto = new PersonDto.Builder()
                .setId(person.getId())
                .setFirstName(person.getFirstName())
                .setLastName(person.getLastName())
                .setMiddleName(person.getMiddleName())
                .setEmail(person.getEmail())
                .setDepartment(person.getDepartment())
                .setChief(person.getChief())
                .setUserDtos(userDtoList)
                .build();

        return personDto;
    }

    public static Person toEntity(PersonDto personDto) {

        List<User> userList = null;
        if (personDto.getUserDtos() != null) {
            userList = personDto.getUserDtos().stream()
                    .map(UserMapper::toEntity).toList();
        }

        Person person = new Person.Builder()
                .setId(personDto.getId())
                .setFirstName(personDto.getFirstName())
                .setLastName(personDto.getLastName())
                .setMiddleName(personDto.getMiddleName())
                .setEmail(personDto.getEmail())
                .setDepartment(personDto.getDepartment())
                .setChief(personDto.getChief())
                .setUsers(userList)
                .build();

        return person;
    }

    public static List<PersonDto> toListPerson(List<Person> personList) {

        return new ArrayList<>((personList).stream().map(PersonMapper::toDto)
                .collect(Collectors.toList()));
    }
}
