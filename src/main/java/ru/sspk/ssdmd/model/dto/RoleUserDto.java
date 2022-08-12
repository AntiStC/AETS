package ru.sspk.ssdmd.model.dto;

public class RoleUserDto {
    private Long id;
    private String name;

    public RoleUserDto() {
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

        public RoleUserDto build() {
            return new RoleUserDto(this);
        }
    }

    public RoleUserDto(Builder builder) {
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
    public String toString() {
        return "RoleUserDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
