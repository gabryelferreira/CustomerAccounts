/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Arrays;
import negocio.Customer;

/**
 *
 * @author gabry
 */
public class Principal {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //instanciando cliente
        Customer customer = new Customer();
        
        //declarando array de String que contem os campos da busca da query
        String[] camposBusca = null;
        
        //declarando array de String que contem um nome para melhor
        //visualizacao da query na tela
        String[] camposNome = null;
        
        //declarando variavel que vai conter a query
        String sqlQuery;
        
        //declarando variavel para ser utilizada para dar replaceAll nas
        //arrays camposBusca e camposNome
        String replace = "[\\[\\]\\\\]";
        
        
        
        
        //setando dados de usuário e cadastrando
        customer.setId_customer(1650);
        customer.setCpf_cnpj("11111111111");
        customer.setIs_active(true);
        customer.setNm_customer("Gabryel Ferreira");
        customer.setVl_total((float) 1020.10);
        customer.cadastrarCliente();
        
        //setando dados de usuário e cadastrando
        customer.setId_customer(1735);
        customer.setCpf_cnpj("22222222222");
        customer.setIs_active(true);
        customer.setNm_customer("Junior Bahia");
        customer.setVl_total((float) 24000.50);
        customer.cadastrarCliente();
        
        //setando dados de usuário e cadastrando
        customer.setId_customer(1900);
        customer.setCpf_cnpj("33333333333");
        customer.setIs_active(true);
        customer.setNm_customer("Gerson Magrao");
        customer.setVl_total((float) 1500.00);
        customer.cadastrarCliente();
        
        //setando dados de usuário e cadastrando
        customer.setId_customer(200);
        customer.setCpf_cnpj("44444444444");
        customer.setIs_active(true);
        customer.setNm_customer("Juninho Pernambucano");
        customer.setVl_total((float) 30000.15);
        customer.cadastrarCliente();
        
        //setando dados de usuário e cadastrando
        customer.setId_customer(500);
        customer.setCpf_cnpj("55555555555");
        customer.setIs_active(true);
        customer.setNm_customer("Neymar Junior");
        customer.setVl_total((float) 570.43);
        customer.cadastrarCliente();
        
        //setando dados de usuário e cadastrando
        customer.setId_customer(1700);
        customer.setCpf_cnpj("66666666666");
        customer.setIs_active(true);
        customer.setNm_customer("Agostinho Carrara");
        customer.setVl_total((float) 15.00);
        customer.cadastrarCliente();
        
        //setando dados de usuário e cadastrando
        customer.setId_customer(2800);
        customer.setCpf_cnpj("55555555555");
        customer.setIs_active(true);
        customer.setNm_customer("Silvio Luiz");
        customer.setVl_total((float) 234.00);
        customer.cadastrarCliente();
        
        //setando dados de usuário e cadastrando
        customer.setId_customer(2700);
        customer.setCpf_cnpj("33333333333");
        customer.setIs_active(true);
        customer.setNm_customer("Silvio Santos");
        customer.setVl_total((float) 150000.38);
        customer.cadastrarCliente();
        
        //setando dados de usuário e cadastrando
        customer.setId_customer(2100);
        customer.setCpf_cnpj("22222222222");
        customer.setIs_active(true);
        customer.setNm_customer("Raul Gil");
        customer.setVl_total((float) 20000.15);
        customer.cadastrarCliente();
        
        //buscando média do campo vl_total apenas para os itens que este valor 
        //seja maior que 560 e o campo id_customer esteja entre 1500 e 2700.
        camposBusca = new String[1];
        camposNome = new String[1];
        camposBusca[0] = "avg(vl_total)";
        camposNome[0] = "Saldo";
        sqlQuery = "select " + Arrays.toString(camposBusca) + " from tb_customer_account where vl_total > 560 and id_customer >= 1500 and id_customer <= 2700";
        sqlQuery = sqlQuery.replaceAll(replace, "");
        System.out.println("Média do saldo dos usuários onde o saldo é maior que 560 e que o id do usuário está entre 1500 e 2700:");
        customer.buscarCliente(camposBusca, camposNome, sqlQuery);
        
        
        
        //buscando clientes que fazem parte do calculo da media do vl_total
        //acima
        camposBusca = new String[3];
        camposNome = new String[3];
        camposBusca[0] = "id_customer";
        camposBusca[1] = "nm_customer";
        camposBusca[2] = "vl_total";
        camposNome[0] = "Id";
        camposNome[1] = "Nome";
        camposNome[2] = "Saldo";
        sqlQuery = "select " + Arrays.toString(camposBusca) + " from tb_customer_account where vl_total > 560 and id_customer >= 1500 and id_customer <=2700 order by vl_total desc";
        sqlQuery = sqlQuery.replaceAll(replace, "");
        System.out.println("Usuários que fazem parte do cálculo: ");
        customer.buscarCliente(camposBusca, camposNome, sqlQuery);
        
        //No caso das duas queries, ele nao acha nenhum registro pois nao
        //existe nenhum cliente no sistema com id entre 1500 e 2700
        
    }
    
    

    
}
