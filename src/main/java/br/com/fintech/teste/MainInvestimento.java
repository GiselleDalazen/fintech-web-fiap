package br.com.fintech.teste;

import br.com.fintech.dao.InvestimentoDAO;
import br.com.fintech.filter.LoginFilter;
import br.com.fintech.model.Investimento;

import java.sql.Date;
import java.util.List;
import java.util.logging.Filter;

public class MainInvestimento {
    public static void main(String[] args) {

       testaInsert();
       testaGetAll();
       testaInvestimentoById();
       testaUpdate();
       testaDelete();


    }

    private static void testaInsert() {

        Investimento investimento = new Investimento();
        investimento.setVlInvestimento(556);
        investimento.setDtInicial(new Date(System.currentTimeMillis()));
        investimento.setDtResgate(new Date(System.currentTimeMillis()));
        investimento.setEmail(LoginFilter.usuario.getEmail());

        InvestimentoDAO dao = new InvestimentoDAO();
        dao.insert(investimento);

    }

       private static void testaGetAll() {

        InvestimentoDAO dao = new InvestimentoDAO();
        List<Investimento> investimentos = dao.getAllById(LoginFilter.usuario.getEmail());

        for (Investimento investimento: investimentos){
            System.out.println("Investimento: " + investimento.toString());
        }


    }


    private static void testaInvestimentoById() {

        InvestimentoDAO dao = new InvestimentoDAO();
        Investimento investimento = dao.selectById(24);

        System.out.println("Investimento: " + investimento.toString());

    }



    private static void testaUpdate() {

        Investimento investimento = new Investimento();
        investimento.setCdInvestimento(24);
        investimento.setVlInvestimento(6933);
        investimento.setDtInicial(new Date(System.currentTimeMillis()));
        investimento.setDtResgate(new Date(System.currentTimeMillis()));
        investimento.setEmail(LoginFilter.usuario.getEmail());

        InvestimentoDAO dao = new InvestimentoDAO();
        dao.update(investimento);

    }



    private static void testaDelete() {

        InvestimentoDAO dao = new InvestimentoDAO();
        dao.delete(25);


    }


}


