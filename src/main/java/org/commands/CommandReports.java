package org.commands;

import org.entities.Report;
import org.services.ServiceReport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import java.util.List;


public class CommandReports implements ICommand{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            return "/login";
        }

        if ("GET".equals(request.getMethod())) {
            ServiceReport serviceReport = new ServiceReport();
            List<Report> reports = serviceReport.findAll();
            // TODO display initiative
            request.setAttribute("Reports", reports);

        }

        return "/reports.jsp";
    }
}
