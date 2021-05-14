package com.reziz.studentregistration.profile.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
public class ProfileDTO {
    private String username;
    @NotEmpty
    private String specializationArea;
    @NotEmpty
    private String blockToTeach;
    private Long blockIntervalStart;
    private Long blockIntervalEnd;
    private String description;
}
