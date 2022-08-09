package ru.sspk.ssdmd.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Table(name = "admin", schema = "public", catalog = "sspk_aets")
@Entity
public class Admin {

    @Column(name = "id_admin")
    @Id
    private Long id;
    @Column(name = "login")
    private String login;

    public Admin() {
    }

    public static class Builder {

        private Long id;
        private String login;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setLogin(String login) {
            this.login = login;
            return this;
        }

        public Admin build() {
            return new Admin(this);
        }
    }

    private Admin(Builder builder) {
        this.id = builder.id;
        this.login = builder.login;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Admin admin = (Admin) o;
        return login.equals(admin.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login);
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", login='" + login + '\'' +
                '}';
    }
}
