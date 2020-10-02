package com.cs.cp.tcb.model.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TcbRest {
    //private long id;
    //private String debtorId;
   private List<DefaultSummaryRest> defaultSummary;
}
