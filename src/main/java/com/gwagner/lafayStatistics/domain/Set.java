package com.gwagner.lafayStatistics.domain;

public class Set {

    private Integer id;

    private Integer reps;

    public Set(Integer id, Integer reps) {
        this.id = id;
        this.reps = reps;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getReps() {
        return reps;
    }

    public void setReps(Integer reps) {
        this.reps = reps;
    }
}
