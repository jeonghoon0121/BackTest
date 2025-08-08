package com.ohgiraffers.section02.model.dto;

import java.sql.Date;
import java.sql.Time;

public class ExcerciseDTO extends WorkoutlogDTO{
    private int logId;
    private int exrID;
    private int exrSet;
    private int setCnt;
    public ExcerciseDTO(){};
    public ExcerciseDTO(int logID,int exrID, int exrSet, int exrCnt) {

        this.exrID=exrID;
        this.exrSet=exrSet;
        this.setCnt=exrCnt;
    }
    public int getLogId() {
        return logId;
    }

    public void setLogId(int logId) {
        this.logId = logId;
    }

    public int getExrSet() {
        return exrSet;
    }

    public void setExrSet(int exrSet) {
        this.exrSet = exrSet;
    }

    public int getSetCnt() {
        return setCnt;
    }

    public void setSetCnt(int setCnt) {
        this.setCnt = setCnt;
    }

    @Override
    public String toString() {
        return "ExcerciseDTO{" +
                "logId=" + logId +
                ", exrID=" + exrID +
                ", exrSet=" + exrSet +
                ", setCnt=" + setCnt +
                '}';
    }
}
