package com.reziz.studentregistration.student.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.reziz.studentregistration.section.domain.Section;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @Email @NotEmpty
    private String email;
    @NotEmpty
    private String track;
    @NotEmpty
    private Long entryId;

    @ManyToMany(fetch = FetchType.EAGER,  cascade = CascadeType.PERSIST)
    @JoinTable(name = "enrolled_section",
            joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id", nullable = true),
            inverseJoinColumns = @JoinColumn(name = "section_id", referencedColumnName = "id", nullable = true))
    @JsonIgnoreProperties("studentList")
    private List<Section> sections= new ArrayList<Section>();;

}
