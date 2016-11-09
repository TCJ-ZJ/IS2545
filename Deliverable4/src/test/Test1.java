package test;

import static org.junit.Assert.*;

import javax.lang.model.element.VariableElement;

import org.junit.Test;

import main.Cell;
import main.MainPanel;

public class Test1 {

	@Test
	public void test1() {
		MainPanel panel = new MainPanel(15);
		assertEquals(panel.convertToInt(5), 5);
		
	}
	@Test
	public void test2() {
		MainPanel panel = new MainPanel(100);
		assertEquals(panel.convertToInt(60), 60);
		
	}
	@Test
	public void test3() {
		MainPanel panel = new MainPanel(5);
		assertEquals(panel.convertToInt(0), 0);
		
	}

}
