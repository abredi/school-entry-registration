package com.reziz.studentregistration.course.service;

import com.reziz.studentregistration.course.domain.CourseDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseServiceTest {
    @Autowired
    private CourseService courseService;

    @Test
    void save() {
        var saved = courseService.save(new CourseDTO());
    }
}
