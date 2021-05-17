package com.reziz.studentregistration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reziz.studentregistration.student.controller.StudentController;
import com.reziz.studentregistration.student.domain.Student;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = StudentController.class)
class CourseControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void save() throws Exception {
        Student student = new Student();
        student.setFirstName("a");
        student.setId(0L);
        String studentBody = objectMapper.writeValueAsString(student);
        mvc.perform(post("/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(studentBody)).andExpect(status().isBadRequest());
    }

    @Test
    void get_shouldReturn400() throws Exception {
        mvc.perform(get("/student/0")).andExpect(status().isBadRequest());
    }

    @Test
    void get_shouldReturn200() throws Exception {
        mvc.perform(get("/student/1")).andExpect(status().isOk());
    }
}
