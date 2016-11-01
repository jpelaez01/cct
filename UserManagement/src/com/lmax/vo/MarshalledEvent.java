package com.lmax.vo;

public class MarshalledEvent {
	private String idList = new String();
	public String getIdList() {
		return idList;
	}

	public void setIdList(String idList) {
		this.idList = idList;
	}

	public MarshalledEvent(String idList) {
		super();
		this.idList = idList;
	}
	
}
