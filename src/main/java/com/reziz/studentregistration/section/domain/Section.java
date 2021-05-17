package com.reziz.studentregistration.section.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.reziz.studentregistration.student.domain.Student;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
@Table(name="section")
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="capacity")
    private Long capacity;
    @Column(name="room_location")
    private String roomLocation;
    @Column(name="block_id")
    private Long blockId;
    @Column(name="faculty_id")
    private Long facultyId;
   @Column(name="course_id")
    private Long courseId;
    @Column(name="students")
    private String students;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "sections", fetch = FetchType.EAGER)
    private List<Student> student = new ArrayList<>();


}
