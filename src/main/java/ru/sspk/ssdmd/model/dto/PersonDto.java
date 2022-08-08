package ru.sspk.ssdmd.model.dto;

public class PersonDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String email;
    private String department;
    private Boolean chief;

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

        //TODO user onetomany

        public void setId(Long id) {
            this.id = id;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public void setMiddleName(String middleName) {
            this.middleName = middleName;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public void setChief(Boolean chief) {
            this.chief = chief;
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
                '}';
    }
}
