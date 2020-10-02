package com.cs.cp.tcb.service.impl;

import com.cs.cp.tcb.entity.TcbEntity;
import com.cs.cp.tcb.exceptions.ApplicationException;
import com.cs.cp.tcb.exceptions.UserNotFoundException;
import com.cs.cp.tcb.repository.UsersRepository;
import com.cs.cp.tcb.service.TcbService;
import com.cs.cp.tcb.shared.Utils;
import com.cs.cp.tcb.shared.dto.DefaultSummaryDTO;
import com.cs.cp.tcb.shared.dto.TcbDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class TcbServiceImpl implements TcbService {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    Utils utils;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public TcbDTO createUser(TcbDTO tcbDTO) throws ApplicationException {

        if(usersRepository.findByDebtorId(tcbDTO.getDebtorId()) !=null) throw new UserNotFoundException("Debtor Id ",String.valueOf(tcbDTO.getDebtorId()));

        for(int i=0;i<tcbDTO.getDefaultSummary().size();i++)
        {
            DefaultSummaryDTO address = tcbDTO.getDefaultSummary().get(i);
            address.setTcbEntity(tcbDTO);
            //tcbDTO.getDefaultSummary().set(i, address);
        }

        ModelMapper modelMapper=new ModelMapper();
        TcbEntity tcbEntity=modelMapper.map(tcbDTO,TcbEntity.class);
        tcbEntity.setDebtorId(tcbDTO.getDebtorId());

        TcbEntity storedUserDetails=usersRepository.save(tcbEntity);

        TcbDTO returnValue=new TcbDTO();
        returnValue=modelMapper.map(storedUserDetails, TcbDTO.class);
        return returnValue;
    }



    @Override
    public TcbDTO getUserByDebtorId(String debtorId) throws ApplicationException {
        TcbDTO returnValue = new TcbDTO();
        TcbEntity tcbEntity = usersRepository.findByDebtorId(debtorId);
        if (tcbEntity == null)
            throw new UserNotFoundException("User with ID: " + debtorId + " not found");
        BeanUtils.copyProperties(tcbEntity, returnValue);
        return returnValue;
    }


}
