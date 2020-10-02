package com.cs.cp.tcb.service;


import com.cs.cp.tcb.exceptions.ApplicationException;
import com.cs.cp.tcb.shared.dto.TcbDTO;

public interface TcbService {
    TcbDTO createUser(TcbDTO user) throws ApplicationException;
    TcbDTO getUserByDebtorId(String deptorId) throws ApplicationException;;
}
