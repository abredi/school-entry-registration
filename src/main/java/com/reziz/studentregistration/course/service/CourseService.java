package com.reziz.studentregistration.course.service;

import com.reziz.studentregistration.course.domain.Course;
import com.reziz.studentregistration.course.domain.CourseDTO;
import com.reziz.studentregistration.course.domain.Prerequisite;
import com.reziz.studentregistration.course.repository.CourseRepository;
import com.reziz.studentregistration.course.repository.PrerequisiteRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Service
@Validated
@AllArgsConstructor
public class CourseService {
    @Autowired
    private final CourseRepository courseRepository;
    private final PrerequisiteRepository prerequisiteRepository;
    public Course save(@Valid CourseDTO course) {
        Iterable<Long> idx = course.getPrerequisite();
        List<Course> prerequisites = new ArrayList<>();
         courseRepository.findAllById(idx).forEach(c -> {
             prerequisites.add(c);
//             prerequisites.add(prerequisiteRepository.save(new Prerequisite(c)));
         });
        var persistEntry = new Course(course.getName(), course.getMaximumSeat(), prerequisites);
        return courseRepository.save(persistEntry);
    }

    public Course findById(Long id) {
        return courseRepository.findById(id).orElseGet(Course::new);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }
}
