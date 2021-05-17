package com.reziz.studentregistration.entry.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
public class Entry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty
    private String entryName;
    @NotEmpty
    private int fPPNum;
    @NotEmpty
    private int mPPNum;
    @NotEmpty
    private LocalDate startDate;
    @NotEmpty
    private LocalDate endDate;
}
