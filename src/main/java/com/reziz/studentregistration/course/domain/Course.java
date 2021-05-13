package com.reziz.studentregistration.course.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
public class Course {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    @Min(1)
    private Integer maximumSeat;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Course> prerequisite;

    public Course(String name, Integer maximumSeat, List<Course> prerequisite) {
        this.name = name;
        this.maximumSeat = maximumSeat;
        this.prerequisite = prerequisite;
    }

    public void addPrerequisite(Course course) {
        prerequisite.add(course);
    }
}
