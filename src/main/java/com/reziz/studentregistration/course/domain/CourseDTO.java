package com.reziz.studentregistration.course.domain;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class CourseDTO {
    @NotEmpty
    private String name;
    @Min(1)
    private Integer maximumSeat;
    private List<Long> prerequisite;
}
