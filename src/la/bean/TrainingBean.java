package la.bean;

import java.util.Date;

public class TrainingBean {
    private int trainingId;
    private String trainingName;
    private int traineeId;
    private int muscleCategoryId;
    private int areaId;
    private Date date;
    private Enum type;

    TrainingBean(int trainingId, String trainingName, int traineeId, int muscleCategoryId,
                    int areaId, Date date, Enum type) {
        this.trainingId = trainingId;
        this.trainingName = trainingName;
        this.traineeId = traineeId;
        this.muscleCategoryId = muscleCategoryId;
        this.areaId = areaId;
        this.date = date;
        this.type = type;
    }

    void setTrainingName(String name) {
        this.trainingName = name;
    }
    void setTraineeId(int traineeId) {
        this.traineeId = traineeId;
    }
    void setMuscleCategoryId(int muscleCategoryId) {
        this.muscleCategoryId = muscleCategoryId;
    }
    void setAreaId(int areaId) {
        this.areaId = areaId;
    }
    void setDate(Date date) {
        this.date = date;
    }
    void setType(Enum type) {
        this.type = type;
    }
    int getTrainingId() {
        return this.trainingId;
    }
    int getTraineeId() {
        return this.traineeId;
    }
    int getMuscleCategoryId() {
        return this.muscleCategoryId;
    }
    int getAreaId() {
        return this.areaId;
    }
    Date getDate() {
        return this.date;
    }
    Enum getType() {
        return this.type;
    }

}
