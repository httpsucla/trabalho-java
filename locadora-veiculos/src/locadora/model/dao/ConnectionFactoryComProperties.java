package locadora.model.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author larissav
 */
public class ConnectionFactoryComProperties {
    public Connection getConnection() throws IOException {
        try {
            Properties prop = new Properties();
            prop.load(getClass().getResourceAsStream("/locadora/model/dao/bd.properties"));
            String dbDriver = prop.getProperty("db.driver");
            String dbUrl = prop.getProperty("db.url");
            String dbUser = prop.getProperty("db.user");
            String dbPwd = prop.getProperty("db.pwd");
            Class.forName(dbDriver);
            return DriverManager.getConnection(dbUrl, dbUser, dbPwd);
           // return DriverManager.getConnection("jdbc:postgresql://localhost/locadora", "root", "root");
        } catch (SQLException | ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }
}
