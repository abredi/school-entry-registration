package com.reziz.studentregistration.util;

import com.reziz.studentregistration.block.domain.Block;
import com.reziz.studentregistration.course.domain.Course;
import com.reziz.studentregistration.faculty.domain.Faculty;
import com.reziz.studentregistration.section.domain.Section;
import com.reziz.studentregistration.student.domain.Student;

import java.util.ArrayList;
import java.util.List;

public class SectionHelp {

    private Section section;
    private Faculty faculty;
    private Block block;
    private Course course;
    private List<Student> students = new ArrayList<>();

    public Section getSection() {
        return section;
    }

    public Block getBlock() {
        return block;
    }

    public void setBlock(Block block) {
        this.block = block;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student){
        students.add(student);
    }
}
