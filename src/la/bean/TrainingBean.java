package la.bean;

import java.util.Date;

public class TrainingBean {
    private int trainingId;
    private String trainingName;
    private int traineeId;
    private int muscleCategoryId;
    private int areaId;
    private Date date;
    private String type;
    // join trainingのstateを管理する
    private String state;
    private String muscleCategoryName;
    private String areaName;

    public TrainingBean(int trainingId, String trainingName, int traineeId, int muscleCategoryId,
                    int areaId, Date date, String type, String state, String muscleCategoryName, String areaName) {
        this.trainingId = trainingId;
        this.trainingName = trainingName;
        this.traineeId = traineeId;
        this.muscleCategoryId = muscleCategoryId;
        this.areaId = areaId;
        this.date = date;
        this.type = type;
        this.state = state;
        this.muscleCategoryName = muscleCategoryName;
        this.areaName = areaName;
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
    void setType(String type) {
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
    String getType() {
        return this.type;
    }

}
