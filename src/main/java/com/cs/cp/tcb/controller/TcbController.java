package com.cs.cp.tcb.controller;


import com.cs.cp.tcb.model.request.TcbDetailsRequestModel;
import com.cs.cp.tcb.model.response.TcbRest;
import com.cs.cp.tcb.service.TcbService;
import com.cs.cp.tcb.shared.dto.TcbDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reports/basic/")
public class TcbController {

    @Autowired
    TcbService tcbService;


    @PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
            MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public TcbRest createTcbUser(@RequestBody TcbDetailsRequestModel requestModel) throws Exception {
        TcbRest returnValue = new TcbRest();

        ModelMapper modelMapper = new ModelMapper();
        TcbDTO tcbDTO = modelMapper.map(requestModel, TcbDTO.class);

        TcbDTO createdUser = tcbService.createUser(tcbDTO);
        returnValue = modelMapper.map(createdUser, TcbRest.class);

        return returnValue;
    }



    @GetMapping(path="/{id}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public TcbRest getTcbUserData(@PathVariable String id) throws Exception {
        TcbRest returnValue = new TcbRest();
        TcbDTO tcbDTO = tcbService.getUserByDebtorId(id);

        ModelMapper modelMapper = new ModelMapper();
        returnValue = modelMapper.map(tcbDTO, TcbRest.class);

        return returnValue;
    }



}
