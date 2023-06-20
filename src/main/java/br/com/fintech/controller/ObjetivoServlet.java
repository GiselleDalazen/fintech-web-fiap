package br.com.fintech.controller;

import br.com.fintech.dao.ObjetivoDAO;
import br.com.fintech.filter.LoginFilter;
import br.com.fintech.model.Objetivo;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ObjetivoServlet", value = "/objetivo-servlet")
    public class ObjetivoServlet extends HttpServlet {

        @Override
        public void init() throws ServletException {
            super.init();
        }
        public ObjetivoServlet(){

        }

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            super.doGet(request, response);
            ObjetivoDAO dao = new ObjetivoDAO();
            List<Objetivo> lista = dao.getAllById(LoginFilter.usuario.getEmail());

            request.setAttribute("listaObjetivos", lista);
            request.getRequestDispatcher("objetivo.jsp").forward(request, response);

        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            super.doPost(request, response);
            String nome = request.getParameter("nome");
            String valor = request.getParameter("valor");
            float vlr = Float.parseFloat(valor);

            java.util.Date date = new java.util.Date();
            Objetivo objetivo = new Objetivo();
            objetivo.setValor(vlr);
            objetivo.setData(new java.sql.Date(date.getTime()));
            objetivo.setDescricao(nome);
            objetivo.setEmail(LoginFilter.usuario.getEmail());

            ObjetivoDAO dao = new ObjetivoDAO();

            int row = dao.insert(objetivo);
            if (row > 0) {
                request.setAttribute("msg", "Objetivo cadastrado!");
                List<Objetivo> lista = dao.getAllById(LoginFilter.usuario.getEmail());
                request.setAttribute("listaObjetivos", lista);
            } else {
                request.setAttribute("err", "Erro ao cadastrar objetivo!");
            }
            request.getRequestDispatcher("objetivo.jsp").forward(request, response);
        }

    }


