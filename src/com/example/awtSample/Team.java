package com.example.awtSample;

import java.util.HashSet;
import java.util.Set;

public class Team {
    private Set<String> members;
    private boolean scoreTeam = false;
    public int score;

    public void setScoreTeam(boolean scoreTeam) {
        this.scoreTeam = scoreTeam;
    }

    public Team() {
        this.members = new HashSet<>();
        this.score = 0;
    }

    public Set<String> getMembers() {
        return members;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
