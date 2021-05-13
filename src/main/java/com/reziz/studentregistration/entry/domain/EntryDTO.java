package com.reziz.studentregistration.entry.domain;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Data
public class EntryDTO {
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
