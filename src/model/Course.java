/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author asaad
 */
public class Course {
    
    private Long id;
    private String courseName;
    private Integer totalLectures;
    private String courseCategory;

    public Course(String courseName, Integer totalLectures, String courseCategory) {
        this.courseName = courseName;
        this.totalLectures = totalLectures;
        this.courseCategory = courseCategory;
    }

    public Course() {
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getTotalLectures() {
        return totalLectures;
    }

    public void setTotalLectures(Integer totalLectures) {
        this.totalLectures = totalLectures;
    }

    public String getCourseCategory() {
        return courseCategory;
    }

    public void setCourseCategory(String courseCategory) {
        this.courseCategory = courseCategory;
    }
    
    
    
}
