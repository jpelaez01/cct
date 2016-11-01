package com.lmax.vo;

import java.util.ArrayList;

public class LmaxEvent {

	private int ID;
	private int parentID;
	private ArrayList<Integer> idList = new ArrayList<Integer>();
	private boolean processed;

	public LmaxEvent(int iD, int parentID, ArrayList<Integer> idList, boolean processed) {
		super();
		ID = iD;
		this.parentID = parentID;
		this.idList = idList;
		this.processed = processed;
	}

	public ArrayList<Integer> getIdList() {
		return idList;
	}

	public void setIdList(ArrayList<Integer> idList) {
		this.idList = idList;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getParentID() {
		return parentID;
	}

	public void setParentID(int parentID) {
		this.parentID = parentID;
	}

	public boolean isProcessed() {
		return processed;
	}

	public void setProcessed(boolean processed) {
		this.processed = processed;
	}
	
	
}