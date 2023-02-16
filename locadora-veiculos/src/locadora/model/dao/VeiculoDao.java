package locadora.model.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import locadora.model.Automovel;
import locadora.model.Locacao;
import locadora.model.Motocicleta;
import locadora.model.Van;
import locadora.model.Veiculo;
import locadora.model.enums.Categoria;
import locadora.model.enums.Estado;
import locadora.model.enums.Marca;
import locadora.model.enums.ModeloAutomovel;
import locadora.model.enums.ModeloMotocicleta;
import locadora.model.enums.ModeloVan;

/**
 *
 * @author larissav
 */
public class VeiculoDao {
    private final String SELECT = "SELECT * FROM veiculos";
    private final String INSERT = "INSERT INTO veiculos (marca, estado, categoria, valor_de_compra, placa, ano, modelo, tipo) VALUES(?,?,?,?,?,?,?,?)";
    private final String UPDATE = "UPDATE veiculos SET estado = ? WHERE placa = ?";
    
    public void inserir(Veiculo veiculo) throws SQLException, IOException{
        try(Connection con= (new Conexao()).getConnection();
            PreparedStatement pst=con.prepareStatement(INSERT);){

            pst.setString(1, veiculo.getMarca().getDescricao());
            pst.setString(2, veiculo.getEstado().getDescricao());
            pst.setString(3, veiculo.getCategoria().getDescricao());
            pst.setDouble(4, veiculo.getValorParaVenda());
            pst.setString(5, veiculo.getPlaca());
            pst.setInt(6, veiculo.getAno());
            if(veiculo instanceof Automovel){
                pst.setString(7, ((Automovel) veiculo).getModelo().getDescricao());
                pst.setString(8, "AUTOMOVEL");
            } else if (veiculo instanceof Motocicleta) {
                pst.setString(7, ((Motocicleta) veiculo).getModelo().getDescricao());
                pst.setString(8, "MOTOCICLETA");                
            } else if (veiculo instanceof Van) {
                pst.setString(7, ((Van) veiculo).getModelo().getDescricao());
                pst.setString(8, "VAN");   
            }
            pst.executeUpdate();
        }
    }
    
    public List<Veiculo> getLista() throws SQLException, IOException{
        List<Veiculo> lista = new ArrayList();
        try(Connection con= (new Conexao()).getConnection();
            PreparedStatement pst=con.prepareStatement(SELECT);){
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                String tipo = rs.getString("tipo");
                Veiculo veiculo = null;
                if (tipo.equals("AUTOMOVEL")) {
                    veiculo = new Automovel(
                        ModeloAutomovel.valueOf(rs.getString("modelo")),
                        new Locacao(),
                        Marca.valueOf(rs.getString("marca")),
                        Estado.valueOf(rs.getString("estado")),
                        Categoria.valueOf(rs.getString("categoria")),
                        rs.getDouble("valor_de_compra"),
                        rs.getString("placa"),
                        rs.getInt("ano")
                      );
                } else if (tipo.equals("MOTOCICLETA")) {
                    veiculo = new Motocicleta(
                        ModeloMotocicleta.valueOf(rs.getString("modelo")),
                        new Locacao(),
                        Marca.valueOf(rs.getString("marca")),
                        Estado.valueOf(rs.getString("estado")),
                        Categoria.valueOf(rs.getString("categoria")),
                        rs.getDouble("valor_de_compra"),
                        rs.getString("placa"),
                        rs.getInt("ano")
                    );
                } else if (tipo.equals("VAN")) {
                  veiculo = new Van(
                        ModeloVan.valueOf(rs.getString("modelo")),
                        new Locacao(),
                        Marca.valueOf(rs.getString("marca")),
                        Estado.valueOf(rs.getString("estado")),
                        Categoria.valueOf(rs.getString("categoria")),
                        rs.getDouble("valor_de_compra"),
                        rs.getString("placa"),
                        rs.getInt("ano")
                    );
                }
                lista.add(veiculo);
            }
            return lista;
        }
        
    }

    public void alterarEstado(Veiculo veiculo) throws SQLException, IOException {
       try(Connection con= (new Conexao()).getConnection();
            PreparedStatement pst=con.prepareStatement(UPDATE);){
            pst.setString(1, veiculo.getEstado().getDescricao());
            pst.setString(2, veiculo.getPlaca());
            pst.executeUpdate();
        }    
    }
}
