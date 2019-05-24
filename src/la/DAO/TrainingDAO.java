package la.DAO;

import DbManager;

public class TrainingDAO {
    private Connection con;
    private DbManager db;
    private String sql = null;
    private PreparedStatement st = null;
    private ResultSet rs = null;

    public TrainingDAO() throws DAOException {
        db = new DbManager();
        con = db.getConnection(con);
    }
}
