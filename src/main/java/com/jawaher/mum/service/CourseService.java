package com.jawaher.mum.service;

import java.util.List;
import java.util.Optional;

import com.jawaher.mum.domain.Faculty;
import com.jawaher.mum.domain.Course;

public interface CourseService {

	public List<Course> findAll();
    public Optional<Course> getById(Long id);
    public Course getCourseByCourseName(String courseName);
    public List<Faculty> getFaculty(String courseName);
    public void update(Course s);
    public void remove( Course s);
    public Course save(Course s);
}
