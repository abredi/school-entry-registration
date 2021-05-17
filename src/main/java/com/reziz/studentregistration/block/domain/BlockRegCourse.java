package com.reziz.studentregistration.block.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
public class BlockRegCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long courseId;
    private Long blockId;

}
