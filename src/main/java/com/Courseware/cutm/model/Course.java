package com.Courseware.cutm.model;

import jakarta.persistence.*;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseid;

    private String coursename;

    private String coursecategory;

    public Course(int courseid, String coursename, String coursecategory) {
        this.courseid = courseid;
        this.coursename = coursename;
        this.coursecategory = coursecategory;
    }

    public Course() {
    }


    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getCoursecategory() {
        return coursecategory;
    }

    public void setCoursecategory(String coursecategory) {
        this.coursecategory = coursecategory;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseid=" + courseid +
                ", coursename='" + coursename + '\'' +
                ", coursecategory='" + coursecategory + '\'' +
                '}';
    }
}
