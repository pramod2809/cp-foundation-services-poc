package com.cs.cp.tcb.repository;


import com.cs.cp.tcb.entity.TcbEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends CrudRepository<TcbEntity,Long> {
    TcbEntity findByDebtorId(String debtorId);
}
