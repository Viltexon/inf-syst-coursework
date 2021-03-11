package org.commands;

import org.services.ServiceInitiative;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CommandPropose implements ICommand{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            return "/login";
        }

        if ("GET".equals(request.getMethod())) {
            return "/propose.jsp";
        }
        session.getAttribute("user");

        ServiceInitiative serviceInitiative = new ServiceInitiative();
        Boolean res = serviceInitiative.addInitiative(
                request.getParameter("name"),
                request.getParameter("description"),
                Integer.parseInt(session.getAttribute("user").toString()),
                Integer.parseInt(request.getParameter("budget"))
        );

        if (res) {
            return "initiatives";
        }
        return "propose";
    }
}
