package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Cell;

public class Test2 {

	@Test
	public void test1() {
		Cell cell = new Cell(true);
		assertEquals(cell.toString(), "X");
	}
	@Test
	public void test2() {
		Cell cell = new Cell(false);
		assertEquals(cell.toString(), ".");
	}
	
	@Test
	public void test3() {
		Cell cell = new Cell();
		assertEquals(cell.toString(), ".");
	}
}
