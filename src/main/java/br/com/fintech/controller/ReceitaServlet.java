package br.com.fintech.controller;

import br.com.fintech.dao.ReceitaDAO;
import br.com.fintech.filter.LoginFilter;
import br.com.fintech.model.Receita;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ReceitaServlet", value = "/receita-servlet")
public class ReceitaServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
    }

    public ReceitaServlet() {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ReceitaDAO dao = new ReceitaDAO();
        List<Receita> lista = dao.getAllById(LoginFilter.usuario.getEmail());

        request.setAttribute("listaReceitas", lista);
        request.getRequestDispatcher("receita.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String descricao =  request.getParameter("descricao");
       String valor = request.getParameter("valor");
       float vlr = Float.parseFloat(valor);

       Receita receita = new Receita();
       receita.setDescricao(descricao);
       receita.setValor(vlr);
       receita.setEmail(LoginFilter.usuario.getEmail());

        ReceitaDAO dao = new ReceitaDAO();

        int row = dao.insert(receita);
        if (row > 0) {
            request.setAttribute("msg", "Receita cadastrada!");
           List<Receita> lista = dao.getAllById(LoginFilter.usuario.getEmail());
           request.setAttribute("listaReceitas", lista);
        } else {
            request.setAttribute("err", "Erro ao cadastrar receita!");
        }
        request.getRequestDispatcher("receita.jsp").forward(request, response);
    }

 }
