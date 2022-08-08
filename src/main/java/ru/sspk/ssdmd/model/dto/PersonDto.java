package ru.sspk.ssdmd.model.dto;

import java.util.List;

public class PersonDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String email;
    private String department;
    private Boolean chief;
    private List<UserDto> userDtos;

    public PersonDto() {
    }

    public static class Builder {

        private Long id;
        private String firstName;
        private String lastName;
        private String middleName;
        private String email;
        private String department;
        private Boolean chief;
        private List<UserDto> userDtos;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setMiddleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setDepartment(String department) {
            this.department = department;
            return this;
        }

        public Builder setChief(Boolean chief) {
            this.chief = chief;
            return this;
        }

        public Builder setUserDtos(List<UserDto> userDtos) {
            this.userDtos = userDtos;
            return this;
        }

        public PersonDto build() {
            return new PersonDto(this);
        }
    }

    private PersonDto(Builder builder) {
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.middleName = builder.middleName;
        this.email = builder.email;
        this.department = builder.department;
        this.chief = builder.chief;
        this.userDtos=builder.userDtos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Boolean getChief() {
        return chief;
    }

    public void setChief(Boolean chief) {
        this.chief = chief;
    }

    public List<UserDto> getUserDtos() {
        return userDtos;
    }

    public void setUserDtos(List<UserDto> userDtos) {
        this.userDtos = userDtos;
    }

    @Override
    public String toString() {
        return "PersonDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", email='" + email + '\'' +
                ", department='" + department + '\'' +
                ", chief=" + chief +
                ", userDtos=" + userDtos +
                '}';
    }
}
