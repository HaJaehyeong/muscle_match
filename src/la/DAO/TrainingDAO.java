package la.DAO;
import la.DbManager;
import la.bean.TrainingBean;

import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.time.LocalDateTime;
import java.util.List;


public class TrainingDAO {
    private Connection con;
    private DbManager db;
    private String sql = null;
    private PreparedStatement st = null;
    private ResultSet rs = null;

    public TrainingDAO() throws DAOException {
        db = new DbManager();
        con = db.getConnection();
    }

    public List<TrainingBean> findAllTraining() throws DAOException, SQLException {
        // 全てのトレーニングを取得する
        if(con == null) {
            con = db.getConnection();
        }

        try {
            // training_tableとjoin_taraining tebleを外部結合することで、検索したユーザーがどのトレーニングに参加しているのかを
            // 判断する stateカラムを取得することができる
            // state(join, cancel) stateの値がない場合は、nullを返す（仕方なくnullを返すようにしている。）
            // MUSCLE_CATEGORY_NAME AREA_NAMEも取得
            String sql = "select *, jt.STATE, m.MUSCLE_CATEGORY_NAME, a.AREA_NAME " +
                    "from TRAINING as tr" +
                    "left outer join JOIN_TRAINING as jt" +
                    "on tr.TRAINING_ID = jt.TRAINING_ID && tr.TRAINEE_ID = jt.TRAINEE_ID" +
                    "inner join MUSCLE_CATEGORY as m" +
                    "on tr.MUSCLE_CATEGORY_ID = m.MUSCLE_CATEGORY_ID" +
                    "inner join AREA as a " +
                    "on tr.AREA_ID = a.AREA_ID;";

            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            List<TrainingBean> list = new ArrayList<>();
            while (rs.next()) {
                createTrainingBeanList(list, rs);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new DAOException("レコードの取得に失敗しました。");
        } finally {
            db.closeResources(st, rs, con);
        }
    }

    public List<TrainingBean> findTrainingByFilter(int muscleCategoryId, int areaId, String date) throws DAOException, SQLException {
        if(con == null) db.getConnection();
        try {
            String sql = "select * from TRAINING " +
                    "where TRAINING.MUSCLE_CATEGORY_ID = ?" +
                    "and" +
                    "TRAINING.AREA_ID = ?" +
                    "and" +
                    "TRAINING.DATE = ?";

            st = con.prepareStatement(sql);
            st.setInt(1, muscleCategoryId);
            st.setInt(2, areaId);

            // TODO: String DateをDateTimeに変更する
//            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
//            LocalDateTime dateTimeData = LocalDateTime.parse(date, dtf);
//            st.setDate(3, dateTimeData);

            rs = st.executeQuery();
            List<TrainingBean> list = new ArrayList<>();
            while (rs.next()) {
                createTrainingBeanList(list, rs);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new DAOException("レコードの取得に失敗しました。");
        } finally {
            db.closeResources(st, rs, con);
        }

    }

    public List<TrainingBean> findTrainingBytrainee(int traineeId) throws DAOException{
        if(con == null) db.getConnection();
        try {
            String sql = "select * from TRAINING where TRAINING.TRAINEE_ID = ?";

            st = con.prepareStatement(sql);
            st.setInt(1, traineeId);
            rs = st.executeQuery();
            List<TrainingBean> list = new ArrayList<>();
            while (rs.next()) {
                createTrainingBeanList(list, rs);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new DAOException("レコードの取得に失敗しました。");
        } finally {
            db.closeResources(st, rs, con);
        }
    }

    private void createTrainingBeanList(List<TrainingBean> list, ResultSet rs) throws DAOException{
        try {
            int trainingId = rs.getInt("TRAINING_ID");
            int muscleCategoryId = rs.getInt("MUSCLE_CATEGORY_ID");
            int areaId = rs.getInt("MUSCLE_CATEGORY_ID");
            String trainingName = rs.getString("TRAINING_NAME");
            Date date = rs.getDate("DATE");
            // active or inactiveを取得
            String type = rs.getString("TYPE");
            int traineeId = rs.getInt("TRAINEE_ID");
            // join or cancel or null(参加・キャンセルもしていないトレーニング)
            String state = rs.getString("STATE");
            String muscleCategoryName = rs.getString("muscleCategoryName");
            String areaName = rs.getString("areaName");
            TrainingBean bean = new TrainingBean(trainingId, trainingName, traineeId, muscleCategoryId, areaId, date, type, state, muscleCategoryName, areaName);
            list.add(bean);
        } catch (Exception e) {
            throw new DAOException("データベースの操作に失敗しました。");
        }

    }

//    public List<TrainingBean> findJoinedTrainingByTrainee(int traineeId) {
//
//    }

    // 참가 버튼을 누르면 레코드 추가
    public void joinTraining(int trainingId, int traineeId) throws DAOException{
        if(con == null)
            db.getConnection();

        try {
            PreparedStatement pstmt = null;
            String sql = "insert into JOIN_TRAINING(training_id, trainee_id, state) values(?, ?, 'join')";
            pstmt.setInt(1, trainingId);
            pstmt.setInt(2, traineeId);
            pstmt = con.prepareStatement(sql);
            pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            throw new DAOException("レコードの挿入に失敗しました。");
        } finally {
            db.closeResources(st, rs, con);
        }
    }

    public void cancelTraining(int trainingId, int traineeId) throws DAOException{
        if(con == null)
            db.getConnection();

        try {
            PreparedStatement pstmt = null;
            String sql = "update JOIN_TRAINING set state = 2 where training_id = ? and trainee_id = ?;";
            pstmt.setInt(1, trainingId);
            pstmt.setInt(2, traineeId);
            pstmt = con.prepareStatement(sql);
            pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            throw new DAOException("レコードの挿入に失敗しました。");
        } finally {
            db.closeResources(st, rs, con);
        }
    }

//    void createTraining() {
//
//    }
//
//    void editTraining() {
//
//    }
//
//    void removeTraining() {
//
//    }
}
