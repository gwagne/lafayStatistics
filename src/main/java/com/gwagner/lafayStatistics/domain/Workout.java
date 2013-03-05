package com.gwagner.lafayStatistics.domain;

import java.util.List;

public class Workout {

    private List<Exercise> exercices;

    public Workout(List<Exercise> exercices) {
        this.exercices = exercices;
    }

    public List<Exercise> getExercices() {
        return exercices;
    }

    public void setExercices(List<Exercise> exercices) {
        this.exercices = exercices;
    }
}
