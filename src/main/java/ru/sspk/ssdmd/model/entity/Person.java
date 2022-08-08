package ru.sspk.ssdmd.model.entity;

import javax.persistence.*;
import java.util.Objects;

@Table(name = "person", schema = "public", catalog = "sspk_aets")
@Entity
public class Person {

    @Column(name = "id_person")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "email")
    private String email;
    @Column(name = "department")
    private String department;
    @Column(name = "chief")
    private Boolean chief;

    public Person() {
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

        public Person build() {
            return new Person(this);
        }
    }

    private Person(Builder builder) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return firstName.equals(person.firstName)
                && lastName.equals(person.lastName)
                && middleName.equals(person.middleName)
                && Objects.equals(email, person.email)
                && department.equals(person.department)
                && chief.equals(person.chief);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName,
                lastName,
                middleName,
                email,
                department,
                chief);
    }

    @Override
    public String toString() {
        return "Person{" +
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
