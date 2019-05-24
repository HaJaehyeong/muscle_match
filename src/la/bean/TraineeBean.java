package la.bean;

import java.io.Serializable;

public class TraineeBean implements Serializable {
    private int traineeId;
    private String traineeName;

    public TraineeBean(int traineeId, String traineeName) {
        this.traineeId = traineeId;
        this.traineeName = traineeName;
    }

    public void setTraineeId(int traineeId){
        this.traineeId = traineeId;
    }
    public void setTraineeName(String traineeName){
        this.traineeName = traineeName;
    }
    public int getTraineeId(){
        return this.traineeId;
    }
    public String getTraineeName(){
        return this.traineeName;
    }

}
