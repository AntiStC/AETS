package ru.sspk.ssdmd.model.dto;

public class AdminDto {

    private Long id;
    private String login;

    public AdminDto() {
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

        public AdminDto build() {
            return new AdminDto(this);
        }
    }

    private AdminDto(Builder builder) {
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
    public String toString() {
        return "AdminDto{" +
                "id=" + id +
                ", login='" + login + '\'' +
                '}';
    }
}
