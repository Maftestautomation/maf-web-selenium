package com.epam.maf.model;

import static com.epam.maf.constants.Constants.*;

public class UserPool {

    public static User getAccount(){return new User();}
    public static User getValidAccount() {
        return new User(VALID_EMAIL, PASSWORD);
    }

    public static User getInvalidAccount(){
        return new User(INVALID_EMAIL,PASSWORD);
    }
}
