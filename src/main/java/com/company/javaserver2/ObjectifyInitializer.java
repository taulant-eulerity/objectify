package com.company.javaserver2;

import com.google.appengine.api.datastore.DatastoreServiceConfig;
import com.googlecode.objectify.ObjectifyService;
import com.company.user.MyEntity;
import com.company.user.User;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ObjectifyInitializer implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ObjectifyService.init();
//        ObjectifyService.register(MyEntity.class);
//        ObjectifyService.register(User.class);
        // Add more registrations as necessary
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // App Engine does not currently invoke this method.
    }
}