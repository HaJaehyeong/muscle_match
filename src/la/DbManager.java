package la;

import la.DAO.DAOException;

import java.sql.*;

public class DbManager {
    private Connection con;
    private String driverName = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/MUSCLE_MATCH";
    private String user = "root";
    private String password = "password";

    public Connection getConnection() throws DAOException {
        try {
            Class.forName(driverName);
            con = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            throw new DAOException("접속실패（接続失敗）");
        }
        return con;
    }

    public void closeResources(PreparedStatement st, ResultSet rs, Connection c) {
        try {
            if(c != null) {
                c.close();
                c = null;
            }
            if (rs != null) rs.close();
            if (st != null) st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
