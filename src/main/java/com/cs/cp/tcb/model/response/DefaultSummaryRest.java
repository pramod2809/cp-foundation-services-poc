package com.cs.cp.tcb.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DefaultSummaryRest {
    private Long seqNo;
    private String account;
    private String trend;
    private String defaultDate;
    private String debtAmount;
}
