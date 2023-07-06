package com.company.javaserver2;

import com.company.user.MyEntity;
import com.company.user.User;
import com.google.cloud.datastore.*;
import com.googlecode.objectify.ObjectifyService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String path = req.getRequestURI();

        if ("/get".equals(path)) {
            // Handle /get endpoint
            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();

            Iterable<MyEntity> entities = OfyService.ofy().load().type(MyEntity.class).iterable();

            out.println("<html>");
            out.println("<head><title>Entities</title></head>");
            out.println("<body>");

            for (MyEntity entity : entities) {
                out.println("<p>" + entity.getValue() + "</p>"); // Display the value of each entity
            }

            out.println("</body>");
            out.println("</html>");

            out.close();
        } else {
            // Handle other requests
            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();

            out.println("<html>");
            out.println("<head><title>Welcome Page</title></head>");
            out.println("<body>");
            out.println("<h1>Welcome, Taulant!</h1>");

            out.println("<form method='POST' action='/'>"); // Submitting to the same URL '/'
            out.println("<input type='submit' value='Save Hello'>");
            out.println("</form>");

            out.println("</body>");
            out.println("</html>");

            out.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        OfyService.ofy().save().entity(new User()).now();
        resp.sendRedirect("/");

//        Datastore datastore = DatastoreOptions.getDefaultInstance().getService(); // Authorized Datastore service
//        KeyFactory keyFactory = datastore.newKeyFactory().setKind("User"); // Create a key factory for "User" kind
//        Key key = datastore.allocateId(keyFactory.newKey()); // Generate a unique ID for the new entity
//
//        List<Value<String>> emptyList = new ArrayList<>();
//        emptyList.add(StringValue.of("")); // Add empty string to list
//
//        // Create the entity and set properties
//        Entity userEntity = Entity.newBuilder(key)
//                .set("list", emptyList)
//                .set("initList", emptyList)
//                .set("set", emptyList)
//                .set("initSet", emptyList)
//                .build();
//
//        datastore.put(userEntity); // Save the entity
//
//        resp.sendRedirect("/");
    }

    // Include your helper methods here
}
