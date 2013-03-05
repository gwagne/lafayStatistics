package com.gwagner.lafayStatistics.domain;

import java.util.List;

public class Exercise {

    private List<Set> sets;

    public Exercise(List<Set> sets) {
        this.sets = sets;
    }

    public List<Set> getSets() {
        return sets;
    }

    public void setSets(List<Set> sets) {
        this.sets = sets;
    }
}
