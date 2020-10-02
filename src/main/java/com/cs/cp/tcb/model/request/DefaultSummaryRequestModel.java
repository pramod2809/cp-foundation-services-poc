package com.cs.cp.tcb.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DefaultSummaryRequestModel {
    private long id;
	private Long seqNo;
	private String account;
	private String trend;
	private String defaultDate;
	private String debtAmount;
}
