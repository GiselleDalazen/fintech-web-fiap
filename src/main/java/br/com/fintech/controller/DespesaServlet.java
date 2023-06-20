package br.com.fintech.controller;

import br.com.fintech.dao.DespesaDAO;
import br.com.fintech.filter.LoginFilter;
import br.com.fintech.model.Despesa;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "DespesaServlet", value = "/despesa-servlet")
public class DespesaServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
    }

    public DespesaServlet() {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DespesaDAO dao = new DespesaDAO();
        List<Despesa> lista = dao.getAllById(LoginFilter.usuario.getEmail());

        request.setAttribute("listaDespesas", lista);
        request.getRequestDispatcher("despesa.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String nome =  request.getParameter("nome");
       String valor = request.getParameter("valor");
       float vlr = Float.parseFloat(valor);

       Despesa despesa = new Despesa();
       despesa.setNome(nome);
       despesa.setValor(vlr);
       despesa.setEmail(LoginFilter.usuario.getEmail());

        DespesaDAO dao = new DespesaDAO();

        int row = dao.insert(despesa);
        if (row > 0) {
            request.setAttribute("msg", "Despesa cadastrada!");
           List<Despesa> lista = dao.getAllById(LoginFilter.usuario.getEmail());
           request.setAttribute("listaDespesas", lista);
        } else {
            request.setAttribute("err", "Erro ao cadastrar despesa!");
        }
        request.getRequestDispatcher("despesa.jsp").forward(request, response);
    }

 }
