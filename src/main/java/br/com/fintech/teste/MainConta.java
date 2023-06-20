package br.com.fintech.teste;

import br.com.fintech.dao.ContaDAO;
import br.com.fintech.filter.LoginFilter;
import br.com.fintech.model.Conta;

import java.util.List;
import java.util.Random;

public class MainConta {

    public static void main(String[] args) {

     testaInsert();
       // testaGetAll();
        //testaContaById();
       // testaUpdate();
       // testaDelete();

    }

    private static void testaInsert() {
        Random sequence = new Random();

        Conta conta = new Conta();
        conta.setIdConta(sequence.nextInt(9999) + sequence.nextInt(9999));
        conta.setAgencia(44);
        conta.setNrConta(sequence.nextInt(9999));
        conta.setNrBanco(1);
        conta.setEmail(LoginFilter.usuario.getEmail());

        ContaDAO dao = new ContaDAO();
        dao.insert(conta);

    }


    private static void testaGetAll() {

        ContaDAO dao = new ContaDAO();
        List<Conta> contas = dao.getAll();

        for (Conta conta: contas){
            System.out.println("Conta: " + conta.toString());
        }


    }

    private static void testaContaById() {

        ContaDAO dao = new ContaDAO();
        Conta conta = dao.selectById(13182);

        System.out.println("Conta: " + conta.toString());

    }

    private static void testaUpdate() {
        Conta conta = new Conta();
        conta.setIdConta(8727);
        conta.setAgencia(526);
        conta.setNrConta(131919);
        conta.setNrBanco(331);
        conta.setEmail(LoginFilter.usuario.getEmail());

        ContaDAO dao = new ContaDAO();
        dao.update(conta);
    }

    private static void testaDelete() {
        ContaDAO dao = new ContaDAO();
        dao.delete(12);
    }

}
