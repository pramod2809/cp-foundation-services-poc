package com.cs.cp.tcb.shared.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class TcbDTO implements Serializable {
    private static final long serialVersionUID= 1L;
    private long id;
    private String debtorId;
    private List<DefaultSummaryDTO> defaultSummary;
}
