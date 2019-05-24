package la;

import la.DAO.DAOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbManager {
    private Connection con;
    private String driverName = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/MUSCLE_MATCH";
    private String user = "student";
    private String password = "1234";

    public Connection getConnection() throws DAOException {
        try {
            Class.forName(driverName);
            con = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            throw new DAOException("접속실패");
        }
        return con;
    }

    public void closeConnection(Connection c) throws SQLException {
        if(c != null) {
            c.close();
            c = null;
        }
    }
}
