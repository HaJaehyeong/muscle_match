package la.DAO;
import DbManager;
import la.bean.TrainingBean;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;


import java.sql.Connection;
import java.util.Date;
import java.util.List;

import la.bean.TrainingBean;


public class TrainingDAO {
    private Connection con;
<<<<<<< Updated upstream
    private DbManager db;
    private String sql = null;
    private PreparedStatement st = null;
    private ResultSet rs = null;

    public TrainingDAO() throws DAOException {
        db = new DbManager();
        con = db.getConnection(con);
    }

    public List<TrainingBean> findAllTraining() throws DAOException{
        // 全てのトレーニングを取得する
        if(con == null) {
            con = db.getConnection(con);
        }

        try {
            // training_tableとjoin_taraining tebleを外部結合することで、検索したユーザーがどのトレーニングに参加しているのかを
            // 判断する stateカラムを取得することができる
            // state(join, cancel) stateの値がない場合は、nullを返す（仕方なくnullを返すようにしている。）

            // TODO: muscleCategoryNameとareaNameも結合して、一個のリストに入れる
            String sql = "select *, jt.state" +
                    "from training as tr left outer join join_training as jt" +
                    "on tr.taining.id = jt.training_id" +
                    "&& tr.tainee.id = jt.trainee_id";
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

    public List<TrainingBean> findTrainingByFilter(int muscleCategoryId, int areaId, String date) throws DAOException {
        if(con == null) db.getConnection(con);
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
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime dateTimeData = LocalDateTime.parse(date, dtf);
            st.setDate(3, dateTimeData);

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
            TrainingBean bean = new TrainingBean(trainingId, trainingName, traineeId, muscleCategoryId, areaId, date, type, state);
            list.add(bean);
        } catch (Exception e) {
            throw new DAOException("データベースの操作に失敗しました。");
        }

    }
=======
    TrainingDAO(){}

//    List<TrainingBean> findAllTraining(){
//
//    }
//
//    List<TrainingBean> findTrainingByfilter(int muscleCategoryId, int areaId, Date date) {
//
//    }
//
//    List<TrainingBean> findTrainingBytrainee(int traineeId) {
//
//    }
//
//    List<TrainingBean> findJoinedTrainingByTrainee(int traineeId) {
//
//    }

    void joinTraining(int trainingId, int traineeId) {

    }

    void cancelTraining(int trainingId, int traineeId) {

    }

    void createTraining() {

    }

    void editTraining() {

    }

    void removeTraining() {

    }

>>>>>>> Stashed changes
}
