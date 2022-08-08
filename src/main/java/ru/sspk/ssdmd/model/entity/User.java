package ru.sspk.ssdmd.model.entity;

import ru.sspk.ssdmd.model.entity.enumEntity.RoleUser;

import javax.persistence.*;
import java.util.Objects;

@Table(name = "user", catalog = "public", schema = "sspk_aets")
@Entity
public class User {

    @Column(name = "id_user")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "login_user")
    private String login;
    @Column(name = "password")
    private String password;
    @Column(name = "role_user")
    @Enumerated(EnumType.STRING)
    private RoleUser role;

    public User() {
    }

    public static class Builder {

        private Long id;
        private String login;
        private String password;
        private RoleUser role;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setLogin(String login) {
            this.login = login;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setRole(RoleUser role) {
            this.role = role;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    private User(Builder builder) {
        this.id = builder.id;
        this.login = builder.login;
        this.password = builder.password;
        this.role = builder.role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleUser getRole() {
        return role;
    }

    public void setRole(RoleUser role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return login.equals(user.login)
                && password.equals(user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login,
                password);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
