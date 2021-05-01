package com.reziz.studentregistration.entry.domain;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
public class EntryDTO {
    @NotEmpty
    private String entryName;
    private int fPPNum;
    private int mPPNum;
    private Date startDate;
    private Date endDate;
}
