package org.servlets.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.servlets.dao.UnitDAO;
import org.servlets.models.Unit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
    private UnitDAO unitDAO = new UnitDAO();
    private ObjectMapper objectMapper = new ObjectMapper();

    public UpdateServlet(UnitDAO unitDAO) {
        this.unitDAO = unitDAO;
    }

    public UpdateServlet() {
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Unit unit = objectMapper.readValue(request.getReader(), Unit.class);
        unitDAO.update(unit);
        response.setStatus(HttpServletResponse.SC_OK);
    }
}