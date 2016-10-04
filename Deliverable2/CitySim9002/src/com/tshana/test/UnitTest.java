package com.tshana.test;

import static org.junit.Assert.*;
import org.mockito.*;

import java.util.Random;
import java.util.prefs.PreferenceChangeEvent;

import org.junit.Test;

import com.tshana.data.Information;
import com.tshana.myTool.Location;
import com.tshana.myTool.Preference;
import com.tshana.myTool.Visitor;

public class UnitTest {

	@Test
	public void visitorCase() {
		Information info = new Information();
			Visitor visitor= new Visitor();
			visitor.setParam(1, 3);
			assertTrue(visitor.getVisitor()=="Blogger");
	}
	
	@Test
	public void locsCase(){
		Information info = new Information();
		Visitor visitor= new Visitor();
		visitor.setParam(1, 3);
		Location location = new Location();
		location.setParam(1, visitor);
		assertTrue(location.getLocation()=="Squirrel Hill");
	}
	
	@Test
	public void preferenceCase(){
		Information info = new Information();
		Visitor visitor= new Visitor();
		visitor.setParam(1, 3);
		Location location = new Location();
		location.setParam(1, visitor);
		Preference pre = new Preference();
		pre.setParam(visitor, location);
		assertTrue(pre.getPre()==false);
	}
	
	@Test
	public void iteration(){
		Information info = new Information();
		Random ran = new Random();
		int k = ran.nextInt(5);
		assertFalse(k>4);
		assertFalse(k<0);
	}
	
	@Test
	public void visitors() {
		Information info = new Information();
		assertEquals("Student", info.getVisitor(0));
		assertEquals("Professor", info.getVisitor(1));
		assertEquals("Business Person",info.getVisitor(2));
		assertEquals("Blogger", info.getVisitor(3));
	}
	
	@Test
	public void locations() {
		Information info = new Information();
		assertEquals("The Cathedral of Learning", info.getLocation(0));
		assertEquals("Squirrel Hill", info.getLocation(1));
		assertEquals("The Point",info.getLocation(2));
		assertEquals("Downtown", info.getLocation(3));
	}
	
	@Test
	public void stubVisitor() {
		Visitor visitor= new Visitor();
		visitor.setParam(1, 1);
		Information info = Mockito.mock(Information.class);
		Mockito.when(info.getVisitor(1)).thenReturn("JIE");
		assertEquals("JIE",visitor.stubget(info));
	}
	
	@Test
	public void stubLocation() {
		Visitor visitor= new Visitor();
		visitor.setParam(1, 1);
		Location locs = new Location();
		locs.setParam(1, visitor);
		Information info = Mockito.mock(Information.class);
		Mockito.when(info.getLocation(1)).thenReturn("PITT");
		assertEquals("PITT",locs.stubget(info));
	}
	
	@Test
	public void stubPreference() {
		Visitor visitor= new Visitor();
		visitor.setParam(1, 1);
		Location locs = new Location();
		locs.setParam(1, visitor);
		Preference pre = new Preference();
		pre.setParam(visitor, locs);
		Information info = Mockito.mock(Information.class);
		Mockito.when(info.getPreference(1, 1)).thenReturn(false);
		assertFalse(pre.stubget(info));
	}
	
}
