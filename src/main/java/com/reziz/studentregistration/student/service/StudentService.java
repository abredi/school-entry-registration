package com.reziz.studentregistration.student.service;

import com.reziz.studentregistration.student.domain.Student;
import com.reziz.studentregistration.student.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Service
@Validated
@AllArgsConstructor
public class StudentService {
    @Autowired
    private final StudentRepository studentRepository;
    public Student save(@Valid Student student) {
        return studentRepository.save(student);
    }

    public Student findById(Long id) {
        return studentRepository.findById(id).orElseGet(Student::new);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    public Student findStudentByEmail(String email){
        return studentRepository.findStudentByEmail(email);
    }
}
