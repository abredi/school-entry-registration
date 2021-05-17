package com.reziz.studentregistration.section.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name="enrolled_section")
public class EnrolledSection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name="student_id")
    private Long studentId;
    @Column(name="section_id")
    private Long sectionId;

}
