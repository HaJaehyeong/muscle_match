import la.DAO.DAOException;
import la.bean.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class DbManager {
    public class DbManager {
        private String userName;
        private String password;
        private int port;
        String databaseName;

        // インスタンスを作った時点で、DBコネクションに必要な値をセットする
        public DbManager() throws DAOException{
            // TODO: 環境変数に設定する
            this.userName = "root";
            this.passward = "rootpassword";
            this.port = 3314;
            this.databaseName = "MUSCLE_MATCH";
        }

        public Connection getConnection(Connection con) throws DAOException {
            try {
                class.forName("com.mysql.cj.jdbc.Driver");
                String url = "jdbc:mysql://localhost:" + port + "/MUSCLE_MATCH?user=" + userName + "&password=" + passward;
                return con = DriverManager.getConnection(url);
            } catch(Exception e) {
                throw new DAOException("DBとの接続に失敗しました");
            }
        }

        private void closeConnection(Connection con) throws DAOException{
            if(con != null) {
                con.close();
                con = null;
            }
        }

        public void closeResources(PreparedStatement st, ResultSet rs, Connection con) throws DAOException {
            try {
                if(st != null) st.close();
                if(rs != null) rs.close();
                closeConnection(con);
            } catch () {
                throw new DAOException("リソースからの解放に失敗しました。");
            }
        }
    }
}

