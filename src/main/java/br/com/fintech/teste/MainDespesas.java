package br.com.fintech.teste;

import br.com.fintech.dao.DespesaDAO;
import br.com.fintech.filter.LoginFilter;
import br.com.fintech.model.Despesa;

import java.util.List;

public class MainDespesas {

    public static void main(String[] args) {

        testaInsertDespesa();
   //     testaGetAllDespesas();
//        testaDespesaById();
//        testaUpdateDespesa();
//        testaDeleteDespesa();

    }

    private static void testaInsertDespesa() {

        Despesa despesa = new Despesa();
        despesa.setValor(560);
        despesa.setNome("Açougue");
        despesa.setEmail("cris@mail.com");

        DespesaDAO dao = new DespesaDAO();
        dao.insert(despesa);

    }

    private static void testaGetAllDespesas() {

        DespesaDAO dao = new DespesaDAO();
        List<Despesa> despesas = dao.getAllById(LoginFilter.usuario.getEmail());

        for (Despesa despesa : despesas) {
            System.out.println("Despesa: " + despesa.toString());
        }

    }

    private static void testaDespesaById() {

        DespesaDAO dao = new DespesaDAO();
        Despesa despesa = dao.selectById(3);

        System.out.println("Despesa: " + despesa.toString());

    }

    private static void testaUpdateDespesa() {

        Despesa despesa = new Despesa();
        despesa.setNome("Empréstimo");
        despesa.setCodigo(4);

        DespesaDAO dao = new DespesaDAO();
        dao.update(despesa);
    }

    private static void testaDeleteDespesa() {

        DespesaDAO dao = new DespesaDAO();
        dao.delete(3);

    }

    private void testa() {

    }
}