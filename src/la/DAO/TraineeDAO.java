package la.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import la.bean.TraineeBean;
import la.DbManager;

public class TraineeDAO {
    private Connection con;
    DbManager dm;

    public TraineeDAO() throws DAOException {
        dm = new DbManager();
        con = dm.getConnection();
    }

    public TraineeBean findByTraineeId(int traineeId) throws DAOException {
        if (con == null) {
            con = dm.getConnection();
        }

        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * from TRAINEE where TRAINEE_ID ="+traineeId;
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            TraineeBean bean = null;
            if (rs.next()) {
                int t_id = rs.getInt("TRAINEE_ID");
                String t_name = rs.getString("TRAINEE_NAME");
                bean = new TraineeBean(t_id, t_name);
            }

            return bean;

        } catch (Exception e) {
            e.printStackTrace();
            throw new DAOException("fail");
        } finally {
            try {
                if(rs != null) rs.close();
                if(st != null) st.close();

                dm.closeConnection(con);
            } catch (Exception e) {
                e.printStackTrace();
                throw new DAOException("close fail");
            }
        }

    }

//    private void close() throws SQLException {
//        if(con != null) {
//            con.close();
//            con = null;
//        }
//    }


}
