package locadora.model.dao;

import java.io.IOException;
import locadora.model.Cliente;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author larissav
 */
public class ClienteDao {
    private final String SELECT = "SELECT * FROM clientes";
    private final String INSERT = "INSERT INTO clientes (NOME,SOBRENOME,RG,CPF,ENDERECO) VALUES(?,?,?,?,?)";
    private final String DELETE = "DELETE FROM clientes WHERE ID=?";
    private final String UPDATE = "UPDATE clientes SET nome = ?, sobrenome = ?, rg = ?, cpf = ?, endereco = ? WHERE id = ?";
    
    public void inserir(Cliente cliente) throws SQLException, IOException{
        try(Connection con= (new Conexao()).getConnection();
            PreparedStatement pst=con.prepareStatement(INSERT);){

            pst.setString(1, cliente.getNome());
            pst.setString(2, cliente.getSobrenome());
            pst.setString(3, cliente.getRg());
            pst.setString(4, cliente.getCpf());
            pst.setString(5, cliente.getEndereco());
            pst.executeUpdate();
        }
    }
    
    public void atualizar(Cliente cliente) throws SQLException, IOException{
        try(Connection con= (new Conexao()).getConnection();
            PreparedStatement pst=con.prepareStatement(UPDATE);){

            pst.setString(1, cliente.getNome());
            pst.setString(2, cliente.getSobrenome());
            pst.setString(3, cliente.getRg());
            pst.setString(4, cliente.getCpf());
            pst.setString(5, cliente.getEndereco());
            pst.executeUpdate();
        }
    }
    
    public List<Cliente> getLista() throws SQLException, IOException{
        List<Cliente> lista = new ArrayList();
        try(Connection con= (new Conexao()).getConnection();
            PreparedStatement pst=con.prepareStatement(SELECT);){
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                lista.add(new Cliente(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("sobrenome"),
                        rs.getString("rg"),
                        rs.getString("cpf"),
                        rs.getString("endereco")));
            }
            return lista;
        }
        
    }

    public void remover(int idCliente) throws SQLException, IOException {
       try(Connection con= (new Conexao()).getConnection();
            PreparedStatement pst=con.prepareStatement(DELETE);){
            pst.setInt(1, idCliente);
            pst.executeUpdate();
       }       
    }
}

