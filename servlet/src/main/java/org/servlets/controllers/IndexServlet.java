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
import java.io.PrintWriter;
import java.util.List;


@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    private UnitDAO unitDAO = new UnitDAO();
    private ObjectMapper objectMapper = new ObjectMapper();

    public IndexServlet(UnitDAO unitDAO) {
        this.unitDAO = unitDAO;
    }

    public IndexServlet() {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Unit> units = unitDAO.index();
        String json = objectMapper.writeValueAsString(units);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }
}
