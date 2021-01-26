package com.springrest.springrest.entities;

public class Course {
    private long id;
    private String tittle;
    private String description;

    public Course(long id, String tittle, String description) {
        this.id = id;
        this.tittle = tittle;
        this.description = description;
    }
    public Course(){
        super();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", tittle='" + tittle + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
