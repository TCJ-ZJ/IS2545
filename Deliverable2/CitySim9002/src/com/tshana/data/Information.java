package com.tshana.data;

public class Information {
	public String[] visitors={"Student","Professor","Business Person","Blogger"};
	public String[] locations = {"The Cathedral of Learning","Squirrel Hill","The Point","Downtown"};
	public boolean[][] preference={{false,true,true,true},{true,true,true,true},{false,true,false,false},{false,false,false,false}};
	public String getVisitor(int n){
		return visitors[n];
	}
	public String getLocation(int n){
		return locations[n];
	}
	public boolean getPreference(int n,int m){
		return preference[n][m];
	}
}
