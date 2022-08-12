package ru.sspk.ssdmd.model.entity;

import javax.persistence.*;
import java.util.Objects;

@Table(name = "role_user", schema = "public", catalog = "sspk_aets")
@Entity
public class RoleUser {
    @Column(name = "id_role")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;

    public RoleUser() {
    }

    public static class Builder {
        private Long id;
        private String name;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public RoleUser build() {
            return new RoleUser(this);
        }
    }

    public RoleUser(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleUser roleUser = (RoleUser) o;
        return Objects.equals(name, roleUser.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "RoleUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
