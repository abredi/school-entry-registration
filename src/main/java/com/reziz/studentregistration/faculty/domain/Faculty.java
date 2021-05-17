package com.reziz.studentregistration.faculty.domain;

import com.reziz.studentregistration.course.domain.Course;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long facultyID;
    private String facultyName;
    private String email;
//    @ManyToMany(mappedBy = "courseId")
//    private Set<Course> courseList=new HashSet<Course>();

}
