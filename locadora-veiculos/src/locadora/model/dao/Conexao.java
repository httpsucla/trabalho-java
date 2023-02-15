package locadora.model.dao;

import java.io.IOException;
import java.util.Properties;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;


/**
 *
 * @author larissav
 */
public class Conexao {
    public Connection getConnection() throws SQLException, IOException{
        Properties prop = new Properties();
        prop.load(getClass().getResourceAsStream("/locadora/model/dao/bd.properties"));
        String url=prop.getProperty("db.url");
        String usuario=prop.getProperty("db.user");
        String senha=prop.getProperty("db.pwd");
        Connection con = DriverManager.getConnection(url,usuario,senha);
        return con;
    }
}
