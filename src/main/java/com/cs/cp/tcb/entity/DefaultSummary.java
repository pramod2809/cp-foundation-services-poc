package com.cs.cp.tcb.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name="tcbs_data")
@Table(name="tcbs_data")
public class DefaultSummary implements Serializable {

	private static final long serialVersionUID = 7809200551672852690L;

	@Id
	@GeneratedValue
	private long id;


	@Column(length=30, nullable=false)
	private String seqNo;

	@Column(length=15, nullable=false)
	private String account;

	@Column(length=15, nullable=false)
	private String trend;

	@Column(length=100, nullable=false)
	private String defaultDate;


	@Column(length=10, nullable=false)
	private String debtAmount;

	@ManyToOne
	@JoinColumn(name="users_id")
	private TcbEntity tcbEntity;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getTrend() {
		return trend;
	}

	public void setTrend(String trend) {
		this.trend = trend;
	}

	public String getDefaultDate() {
		return defaultDate;
	}

	public void setDefaultDate(String defaultDate) {
		this.defaultDate = defaultDate;
	}

	public String getDebtAmount() {
		return debtAmount;
	}

	public void setDebtAmount(String debtAmount) {
		this.debtAmount = debtAmount;
	}

    public TcbEntity getTcbEntity() {
        return tcbEntity;
    }

    public void setTcbEntity(TcbEntity tcbEntity) {
        this.tcbEntity = tcbEntity;
    }
}
