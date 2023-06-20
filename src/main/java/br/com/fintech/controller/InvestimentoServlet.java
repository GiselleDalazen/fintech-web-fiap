package br.com.fintech.controller;

import br.com.fintech.dao.InvestimentoDAO;
import br.com.fintech.filter.LoginFilter;
import br.com.fintech.model.Investimento;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.sql.Date;



@WebServlet(name = "InvestimentoServlet", value = "/investimento-servlet")
public class InvestimentoServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
    }

    public InvestimentoServlet() {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        InvestimentoDAO dao = new InvestimentoDAO();
        List<Investimento> lista = dao.getAllById(LoginFilter.usuario.getEmail());

        request.setAttribute("listaInvestimentos", lista);
        request.getRequestDispatcher("invest.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String nome =  request.getParameter("nome");
       String valor = request.getParameter("valor");
       String dataInicial = request.getParameter("dataInicial"); 
       float vlr = Float.parseFloat(valor);
      
 
       
       Investimento investimento = new Investimento();
       investimento.setNome(nome);
       investimento.setVlInvestimento(vlr);
       investimento.setDtInicial(dataInicial);
       investimento.setEmail(LoginFilter.usuario.getEmail());

        InvestimentoDAO dao = new InvestimentoDAO();

        int row = dao.insert(investimento);
        if (row > 0) {
            request.setAttribute("msg", "Investimento cadastrada!");
           List<Investimento> lista = dao.getAllById(LoginFilter.usuario.getEmail());
           request.setAttribute("listaInvestimento", lista);
        } else {
            request.setAttribute("err", "Erro ao cadastrar investimento!");
        }
        request.getRequestDispatcher("invest.jsp").forward(request, response);
    }

 }


