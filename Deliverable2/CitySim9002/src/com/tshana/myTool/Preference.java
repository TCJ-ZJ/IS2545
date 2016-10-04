package com.tshana.myTool;

import javax.sound.midi.MidiDevice.Info;

import com.tshana.data.Information;

public class Preference {
	private Visitor visitor;
	private Location location;
	public void setParam(Visitor visitor,Location location){
		this.visitor=visitor;
		this.location=location;
	}
	
	public boolean getPre(){
		Information info = new Information();
		return info.getPreference(this.visitor.getvisitNum(),this.location.getlocationNum());
	}
	
	public boolean stubget(Information info){
		return info.getPreference(this.visitor.getvisitNum(),this.location.getlocationNum());
	}
	
	public void preferenceStart(){
		Information info = new Information();
		if(info.getPreference(this.visitor.getvisitNum(),this.location.getlocationNum())){
			System.out.println("Visitor "+this.visitor.getNum()+" did like "+this.location.getLocation()+".");
		}else{
			System.out.println("Visitor "+this.visitor.getNum()+" did not like "+this.location.getLocation()+".");
		}
	}
}
