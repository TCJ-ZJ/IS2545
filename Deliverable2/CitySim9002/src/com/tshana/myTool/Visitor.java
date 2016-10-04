package com.tshana.myTool;

import java.security.PublicKey;
import java.util.Random;

import javax.sound.midi.MidiDevice.Info;

import com.tshana.data.Information;

public class Visitor {
	private String visitor;
	private int num;
	private int visitNum;
	public void setParam(int num,int visitNum){
		Information info = new Information();
		this.num=num+1;
		this.visitNum = visitNum;
		this.visitor = info.getVisitor(visitNum);
	}
	public void visitorStart(){
		System.out.println("Visitor "+this.num+" is a "+this.visitor);
		visit();
	}
	
	public int getNum(){
		return this.num;
	}
	
	public int getvisitNum(){
		return this.visitNum;
	}
	
	public String getVisitor(){
		return this.visitor;
	}
	
	public String stubget(Information info){
		return info.getVisitor(this.visitNum);
	}
	
	private void visit(){
		Random ran = new Random();
		boolean flag = true;
		boolean start = true;
		int locationNum;
		while(flag){
			if(start){
				locationNum = ran.nextInt(4);
				start=false;
			}else{
				locationNum = ran.nextInt(5);
			}
			if(locationNum<4){
				Location location = new Location();
				location.setParam(locationNum,this);
				location.locationStart();
			}else{
				System.out.println("Visitor "+this.num+" has left the city.");
				flag=false;
			}
		}
	}
}
