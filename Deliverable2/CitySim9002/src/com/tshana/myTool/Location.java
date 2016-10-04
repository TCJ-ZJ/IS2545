package com.tshana.myTool;

import com.tshana.data.Information;

public class Location {
	private String location;
	private int locationNum;
	private Visitor visitor;
	public void setParam(int locationNum,Visitor visitor){
		Information info = new Information();
		this.locationNum=locationNum;
		this.location = info.getLocation(locationNum);
		this.visitor=visitor;
	}
	public void locationStart(){
		System.out.println("Visitor "+this.visitor.getNum()+" is going to "+this.location+".");
		Preference preference = new Preference();
		preference.setParam(this.visitor,this);	
		preference.preferenceStart();
	}
	public int getlocationNum(){
		return this.locationNum;
	}
	public String getLocation(){
		return this.location;
	}
	
	public String stubget(Information info){
		return info.getLocation(this.locationNum);
	}
}
