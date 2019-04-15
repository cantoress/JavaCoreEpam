package user.dto;

import common.business.dto.BaseDto;
import user.domain.ClientType;

public class UserDto extends BaseDto<Long> {

    private String firstName;
    private String lastName;
    private int age;
    private int passport;

    private ClientType clientType = ClientType.NORMAL;

    public UserDto() {
    }

    public UserDto(String firstName, String lastName, int age, int passport, ClientType clientType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.passport = passport;
        this.clientType = clientType;
    }

    public UserDto(Long id) {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPassport() {
        return passport;
    }

    public void setPassport(int passport) {
        this.passport = passport;
    }

    public ClientType getClientType() {
        return clientType;
    }

    public void setClientType(ClientType clientType) {
        this.clientType = clientType;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", passport=" + passport +
                ", clientType=" + clientType +
                ", id=" + id +
                '}';
    }
}

