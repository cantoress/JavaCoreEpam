package user.search;

import common.business.search.BaseSearchCondition;

public class UserSearchCondition extends BaseSearchCondition<Long> {

    private String firstName;
    private String lastName;

    public boolean searchByFirstName() {
        return (firstName != null) && (firstName.equals(""));
    }

    public boolean searchByLastName() {
        return (lastName != null) && (lastName.equals(""));
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
}
