package com.company.javaserver2;

import com.company.user.MyEntity;
import com.company.user.User;
import com.google.appengine.api.datastore.DatastoreServiceConfig;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;

public class OfyService {
    static {
        Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
        ObjectifyService.init(new ObjectifyFactory(datastore));
        ObjectifyService.register(MyEntity.class);
        ObjectifyService.register(User.class);
//        // Add more registrations as necessary
    }

    public static Objectify ofy() {
        return ObjectifyService.ofy();
    }
}
//git checkout origin/refactor/get-full-opto