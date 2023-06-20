package br.com.fintech.teste;

import br.com.fintech.dao.ObjetivoDAO;
import br.com.fintech.filter.LoginFilter;
import br.com.fintech.model.Objetivo;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class MainObjetivo {

    public static void main(String[] args) {

        testaInsertObjetivo();
       // testaObjetivoById();
       // testaGetAllObjetivo();
       // testaDeleteObjetivo();
       // testaUpdateObjetivo();
    }
    private static void testaInsertObjetivo() {

        Objetivo carro = new Objetivo();
        carro.setCodigo(1);
        carro.setDescricao("Carro Novo");
        carro.setValor(50000.00);
        carro.setData(new Date(System.currentTimeMillis()));

        Objetivo apartamento = new Objetivo();
        apartamento.setCodigo(2);
        apartamento.setDescricao("Sair do Aluguel");
        apartamento.setValor(200000.00);
        apartamento.setData(new Date(System.currentTimeMillis()));

        Objetivo faculdade = new Objetivo();
        faculdade.setCodigo(3);
        faculdade.setDescricao("Me formar na facul");
        faculdade.setValor(30000.00);
        faculdade.setData(new Date(System.currentTimeMillis()));

        Objetivo ferias = new Objetivo();
        ferias.setCodigo(4);
        ferias.setDescricao("Ferias");
        ferias.setValor(5000.00);
        ferias.setData(new Date(System.currentTimeMillis()));

        Objetivo computador = new Objetivo();
        computador.setCodigo(5);
        computador.setDescricao("PC novo");
        computador.setValor(7000.00);
        computador.setData(new Date(System.currentTimeMillis()));

        ObjetivoDAO dao = new ObjetivoDAO();
        try {
            dao.insert(carro);
            dao.insert(apartamento);
            dao.insert(faculdade);
            dao.insert(ferias);
            dao.insert(computador);

            System.out.println("Objetivo inserido com sucesso!");
        } catch (Exception e){

            System.out.println("Erro ao inserir os dados \n"+ e.getMessage());
        }

    }

    private static void testaObjetivoById() {

        ObjetivoDAO dao = new ObjetivoDAO();
        Objetivo objetivo = dao.selectById(3);

        System.out.println("Objetivo: " + objetivo.getDescricao());
    }

    private static void testaGetAllObjetivo() {

        ObjetivoDAO dao = new ObjetivoDAO();
        List<Objetivo> objetivos = dao.getAllById(LoginFilter.usuario.getEmail());

        for (Objetivo objetivo: objetivos){
            System.out.println("Objetivo: " + objetivo.toString());
        }
    }
    private static void testaDeleteObjetivo() {

        ObjetivoDAO dao = new ObjetivoDAO();
        try {
            dao.delete(5);
            System.out.println("Dados deletados com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao deletar os dados \n"+ e.getMessage());
        }
    }

    private static void testaUpdateObjetivo() {

        Objetivo objetivo = new Objetivo();
        objetivo.setDescricao("Casamento em Paris");
        objetivo.setValor(60.100);
        objetivo.setData(new Date(System.currentTimeMillis()));
        objetivo.setCodigo(4);

        ObjetivoDAO dao = new ObjetivoDAO();
        try {
            dao.update(objetivo);
            System.out.println("Dados alterados com sucesso!");
        } catch (SQLException e){

            System.out.println("Erro ao alterar os dados \n"+ e.getMessage());
        }
    }
}
