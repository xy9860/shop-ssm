package com.xy9860.shop.model;
// Generated 2017-3-22 11:18:04 by Hibernate Tools 5.2.1.Final

/**
 * Status generated by hbm2java
 */
public class Status implements java.io.Serializable {

	private Integer tid;
	private String tstatus;

	public Status() {
	}

	public Status(Integer tid) {
		this.tid = tid;
	}

	public Integer getTid() {
		return this.tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public String getTstatus() {
		return this.tstatus;
	}

	public void setTstatus(String tstatus) {
		this.tstatus = tstatus;
	}

}
