package org.servlets;

import org.helpers.CommandHelper;
import org.commands.ICommand;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "proposeServlet", value = "/propose")
public class ControllerPropose extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ICommand command = CommandHelper.getCommand("propose");
        String path = command.execute(request, response);
        response.sendRedirect(path);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ICommand command = CommandHelper.getCommand("propose");
        String path = command.execute(request, response);
        request.getRequestDispatcher(path).forward(request, response);
    }
}
