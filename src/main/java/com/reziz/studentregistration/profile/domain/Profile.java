package com.reziz.studentregistration.profile.domain;

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
public class Profile {
    @Id
    @GeneratedValue
    private Long id;
    @NotEmpty
    private String username;
    @NotEmpty
    private String specializationArea;
    @NotEmpty
    private String blockToTeach;
    private Long blockIntervalStart;
    private Long blockIntervalEnd;
    private String description;

    public Profile(String username, String specializationArea, String blockToTeach, Long blockIntervalStart, Long blockIntervalEnd, String description) {
        this.username = username;
        this.specializationArea = specializationArea;
        this.blockToTeach = blockToTeach;
        this.blockIntervalStart = blockIntervalStart;
        this.blockIntervalEnd = blockIntervalEnd;
        this.description = description;
    }
}
