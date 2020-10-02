package com.cs.cp.tcb.shared.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DefaultSummaryDTO {
    private long id;
    //private String addressId;
    private String seqNo;
    private String account;
    private String trend;
    private String defaultDate;
    private Double debtAmount;

    private TcbDTO tcbEntity;
}
