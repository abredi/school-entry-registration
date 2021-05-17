package com.reziz.studentregistration.block.domain;

import com.reziz.studentregistration.entry.domain.Entry;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
public class Block {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty
    private String blockName;
    private Date startDate;
    private Date endDate;
    private int fPPNum;
    private int mPPNum;
   // private Long entry_Id;
    @JoinColumn(name = "entryId", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private Entry entry;
}
