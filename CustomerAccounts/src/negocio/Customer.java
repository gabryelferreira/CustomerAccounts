/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;
import java.sql.SQLException;
/**
 *
 * @author gabry
 */
public class Customer{
    //criando campos de informacao do usuario
    int id_customer;
    String cpf_cnpj;
    String nm_customer;
    boolean is_active;
    float vl_total;
    DBConexao conexao;

    //criando getters e setters das informacoes/variaveis do usuario

    public void setId_customer(int id_customer) {this.id_customer = id_customer;}
    
    public void setCpf_cnpj(String cpf_cnpj) {this.cpf_cnpj = cpf_cnpj;}

    public void setNm_customer(String nm_customer) {this.nm_customer = nm_customer;}

    public void setIs_active(boolean is_active) {this.is_active = is_active;}

    public void setVl_total(float vl_total) {this.vl_total = vl_total;}
    

    //funcao para testar conexao
    public boolean testarConexao(){
        conexao = new DBConexao();
        return conexao.isConexao();
    }
    
    
    //funcao para cadastro de cliente, sem passagem de parametros pois apenas
    //da o mesmo insert em todos os casos
    public void cadastrarCliente(){
        if (testarConexao()){
            String sqlQuery = "insert into tb_customer_account(id_customer, cpf_cnpj, nm_customer, is_active, vl_total) values(" + this.id_customer + ", '" + this.cpf_cnpj + "', '" + this.nm_customer + "', " + this.is_active + ", " + this.vl_total + ")";
            try {
                conexao.setPreparedStmt(conexao.getCon().prepareStatement(sqlQuery));
                conexao.getPreparedStmt().execute();
            } catch(SQLException e){
                System.out.println("Erro!" + e);
            }
        } else {
            System.out.println("Erro de conexão");
        }
            
            
            
            
    }
    //funcao que recebe os campos que vai buscar, os campos com um nome
    //para uma melhor visualização na tela e a query para fazer a busca
    public void buscarCliente(String[] camposBusca, String[] camposNome, String sqlQuery){
        if (testarConexao()){
            String[] v;
            String sql = sqlQuery;
            try {
                conexao.setRs(conexao.getSt().executeQuery(sqlQuery));
                while(conexao.getRs().next()){
                    for (int i = 0; i < camposBusca.length; i++){
                        v = new String[camposBusca.length];
                        v[i] = conexao.getRs().getString(camposBusca[i]);
                        System.out.print(camposNome[i] + " = " + v[i]);
                        if (i < camposBusca.length-1)
                            System.out.print(" / ");
                    }
                    System.out.println("");
                }
                System.out.println("");
            } catch(SQLException e){
                System.out.println("ERRO!" + e);
            }
        } else {
            System.out.println("Erro de conexao");
        }
    }
    

    
            
}
