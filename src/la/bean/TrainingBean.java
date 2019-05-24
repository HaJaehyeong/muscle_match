package la.bean;

import java.io.Serializable;
import java.util.Date;

public class TrainingBean implements Serializable {
    private int trainingId;
    private String trainingName;
    private int traineeId;
    private int muscleCategoryId;
    private int areaId;
    private Date date;
    private Enum type;

    public TrainingBean(int trainingId, String trainingName, int traineeId, int muscleCategoryId,
                    int areaId, Date date, Enum type) {
        this.trainingId = trainingId;
        this.trainingName = trainingName;
        this.traineeId = traineeId;
        this.muscleCategoryId = muscleCategoryId;
        this.areaId = areaId;
        this.date = date;
        this.type = type;
    }

    public void setTrainingName(String name) {
        this.trainingName = name;
    }
    public void setTraineeId(int traineeId) {
        this.traineeId = traineeId;
    }
    public void setMuscleCategoryId(int muscleCategoryId) {
        this.muscleCategoryId = muscleCategoryId;
    }
    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public void setType(Enum type) {
        this.type = type;
    }
    public int getTrainingId() {
        return this.trainingId;
    }
    public int getTraineeId() {
        return this.traineeId;
    }
    public int getMuscleCategoryId() {
        return this.muscleCategoryId;
    }
    public int getAreaId() {
        return this.areaId;
    }
    public Date getDate() {
        return this.date;
    }
    public Enum getType() {
        return this.type;
    }

}
