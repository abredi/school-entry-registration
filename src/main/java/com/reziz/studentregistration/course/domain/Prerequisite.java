package com.reziz.studentregistration.course.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
public class Prerequisite {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
