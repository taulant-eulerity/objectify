package com.company.javaserver2;

import com.company.user.MyEntity;
import com.company.user.User;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;

public class OfyService {
    static {
        ObjectifyService.register(MyEntity.class);
        ObjectifyService.register(User.class);
        // Add more registrations as necessary
    }

    public static Objectify ofy() {
        return ObjectifyService.ofy();
    }

    public static ObjectifyFactory factory() {
        return ObjectifyService.factory();
    }
}
