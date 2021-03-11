package org.commands;

import org.entities.Initiative;
import org.services.ServiceInitiative;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import java.util.List;

public class CommandInitiatives implements ICommand{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            return "/login";
        }

        if ("GET".equals(request.getMethod())) {
            ServiceInitiative serviceInitiative = new ServiceInitiative();
            serviceInitiative.updateVotes();
            List<Initiative> initiatives = serviceInitiative.findAll();
            request.setAttribute("Initiatives", initiatives);

        }

        return "/initiatives.jsp";
    }
}
