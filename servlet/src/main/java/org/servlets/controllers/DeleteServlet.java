package org.servlets.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.servlets.dao.UnitDAO;
import org.servlets.models.Unit;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteServlet extends HttpServlet {
    private UnitDAO unitDAO = new UnitDAO();
    private ObjectMapper objectMapper = new ObjectMapper();

    public DeleteServlet(UnitDAO unitDAO) {
        this.unitDAO = unitDAO;
    }

    public DeleteServlet() {
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Unit unit = objectMapper.readValue(request.getReader(), Unit.class);
        unitDAO.delete(unit);
        response.setStatus(HttpServletResponse.SC_OK);
    }
}
