package com.cs.cp.tcb.model.request;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class TcbDetailsRequestModel {
    private long id;
    private String debtorId;
    private List<DefaultSummaryRequestModel> defaultSummary;
}
