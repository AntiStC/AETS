package ru.sspk.ssdmd.model.dto;

import java.util.Set;

public class UserDto {
    private Long id;
    private String login;
    private String password;
    private Set<RoleUserDto> roles;

    public UserDto() {
    }

    public static class Builder {

        private Long id;
        private String login;
        private String password;
        private Set<RoleUserDto> roles;

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

        public Builder setRoles(Set<RoleUserDto> roles) {
            this.roles = roles;
            return this;
        }

        public UserDto build() {
            return new UserDto(this);
        }
    }

    private UserDto(Builder builder) {
        this.id = builder.id;
        this.login = builder.login;
        this.password = builder.password;
        this.roles = builder.roles;
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

    public Set<RoleUserDto> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleUserDto> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                '}';
    }
}
