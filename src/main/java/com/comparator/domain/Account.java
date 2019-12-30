package com.comparator.domain;

import com.comparator.util.IndexNo;

public class Account {

	@IndexNo(index = 0)
	private String accNo;
	
	@IndexNo(index = 1)
	private String statementDate;

	@IndexNo(index = 2)
	private String billedOrUnbilled;

	@IndexNo(index = 3)
	private String endpoint;

	@IndexNo(index = 4)
	private String resource;

	@IndexNo(index = 5)
	private String parameter;

	@IndexNo(index = 6)
	private String sor;
	

	public Account() {
		super();
	}

	public Account(String accNo, String sor) {
		super();
		this.accNo = accNo;
		this.sor = sor;
	}

	public String getAccNo() {
		return accNo;
	}

	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}

	public String getSor() {
		return sor;
	}

	public void setSor(String sor) {
		this.sor = sor;
	}

	public String getBilledOrUnbilled() {
		return billedOrUnbilled;
	}

	public void setBilledOrUnbilled(String billedOrUnbilled) {
		this.billedOrUnbilled = billedOrUnbilled;
	}

	public String getEndpoint() {
		return endpoint;
	}

	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}

	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}

	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}

	public String getStatementDate() {
		return statementDate;
	}

	public void setStatementDate(String statementDate) {
		this.statementDate = statementDate;
	}

	@Override
	public String toString() {
		return "Account [accNo=" + accNo + ", statementDate=" + statementDate + ", billedOrUnbilled=" + billedOrUnbilled
				+ ", endpoint=" + endpoint + ", resource=" + resource + ", parameter=" + parameter + ", sor=" + sor
				+ "]";
	}

}
