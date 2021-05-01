package com.reziz.studentregistration.block.domain;

import com.reziz.studentregistration.entry.domain.Entry;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
public class BlockDTO {
    @NotEmpty
    private String blockName;
    private Date startDate;
    private Date endDate;
    private int fPPNum;
    private int mPPNum;
    @Valid
    private Long entry;
}
