package br.com.fintech.controller;

import br.com.fintech.dao.ContaDAO;
import br.com.fintech.filter.LoginFilter;
import br.com.fintech.model.Conta;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ContaServlet", value = "/conta-servlet")
public class ContaServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
    }

    public ContaServlet() {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ContaDAO dao = new ContaDAO();
        List<Conta> lista = dao.getAll();

        request.setAttribute("listaConta", lista);
        request.getRequestDispatcher("conta.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String agencia =  request.getParameter("agencia");
       String numero = request.getParameter("numero");
       String nrBanco = request.getParameter("nrBanco");
       int agency = Integer.parseInt(agencia);
       int nrConta = Integer.parseInt(numero);
       int numBanco = Integer.parseInt(nrBanco);
       

       Conta conta = new Conta();
       conta.setAgencia(agency);
       conta.setNrConta(nrConta);
       conta.setNrBanco(numBanco);
       conta.setEmail(LoginFilter.usuario.getEmail());

        ContaDAO dao = new ContaDAO();

        int row = dao.insert(conta);
        if (row > 0) {
            request.setAttribute("msg", "Conta cadastrada!");
           List<Conta> lista = dao.getAll();
           request.setAttribute("listaConta", lista);
        } else {
            request.setAttribute("err", "Erro ao cadastrar conta!");
        }
        request.getRequestDispatcher("conta.jsp").forward(request, response);
    }

 }
