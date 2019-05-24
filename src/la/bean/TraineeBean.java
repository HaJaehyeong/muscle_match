package la.bean;

public class TraineeBean {
    private int traineeId;
    private String traineeName;

    TraineeBean(int traineeId, String traineeName) {
        this.traineeId = traineeId;
        this.traineeName = traineeName;
    }

    void setTraineeId(int traineeId){
        this.traineeId = traineeId;
    }
    void setTraineeName(String traineeName){
        this.traineeName = traineeName;
    }
    int getTraineeId(){
        return this.traineeId;
    }
    String getTraineeName(){
        return this.traineeName;
    }

}
