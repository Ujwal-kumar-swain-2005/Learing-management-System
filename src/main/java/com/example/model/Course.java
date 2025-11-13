package com.example.model;

public class Course {
    private int id;
    private String title;
    private String description;
    private int instructorId;
    private String category;
    private String level; 

    public Course() {}

    public Course(int id, String title, String description, int instructorId, String category, String level) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.instructorId = instructorId;
        this.category = category;
        this.level = level;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public int getInstructorId() { return instructorId; }
    public void setInstructorId(int instructorId) { this.instructorId = instructorId; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getLevel() { return level; }
    public void setLevel(String level) { this.level = level; }
}