package com.cs.cp.tcb.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name="tcbs_users")
@Table(name="tcbs_users")
public class TcbEntity implements Serializable {
    private static final long serialVersionUID= 1L;

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false,length = 100) //,unique = true
    private String debtorId;


    @OneToMany(mappedBy = "tcbEntity", cascade = CascadeType.ALL)
    private List<DefaultSummary> defaultSummary;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDebtorId() {
        return debtorId;
    }

    public void setDebtorId(String debtorId) {
        this.debtorId = debtorId;
    }

    public List<DefaultSummary> getDefaultSummary() {
        return defaultSummary;
    }

    public void setDefaultSummary(List<DefaultSummary> defaultSummary) {
        this.defaultSummary = defaultSummary;
    }
}
