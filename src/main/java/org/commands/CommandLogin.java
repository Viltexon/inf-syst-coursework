package org.commands;

import org.entities.User;
import org.services.ServiceUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CommandLogin implements ICommand{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();

        if ("GET".equals(request.getMethod())) {
            return "/login.jsp";
        }

        String path;
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        ServiceUser serviceUser = new ServiceUser();
        Boolean statusLogin = serviceUser.login(email, password);

//        System.out.println(System.getProperty("user.dir"));

        if ( statusLogin ){
//            System.out.println("yes");
            User user = serviceUser.getUser(email);
            session.setAttribute("user", user.getIdentifier());
            path = "/initiatives";
        } else {
//            System.out.println("no");
            path = "/login";
        }

        return path;
    }
}
