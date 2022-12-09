package com.web_work.pojo;

public class SoftWare {
    private int id;
    private String name;
    private String depart;
    private String description;
    private String score;

    @Override
    public String toString() {
        return "SoftWare{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", depart='" + depart + '\'' +
                ", description='" + description + '\'' +
                ", score=" + score +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
