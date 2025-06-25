package com.mavan.junit;

import org.junit.Test;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

public class Calculator_test {
	Calculator c;

	@Before
	public void setup() {
		c = new Calculator();
		System.out.println("Test case setup");
	}

	@Test
	public void test_add() {
		c = new Calculator();
		Assert.assertEquals(10, c.add(5, 5));
	}

	@Test
	public void test_sub() {
		c = new Calculator();
		Assert.assertEquals(10, c.sub(15, 5));
	}

	@Test
	public void test_mul() {
		c = new Calculator();
		Assert.assertEquals(25, c.mul(5, 5));
	}

	@Test
	public void test_div() {
		c = new Calculator();
		Assert.assertEquals(2, c.div(10, 5));
	}

	@Test(expected = ArithmeticException.class)
	public void test_div2() {
		c = new Calculator();
		Assert.assertEquals(2, c.div(2, 0));
	}

	@After
	public void clear() {
		System.out.println("All test case finished");
	}

}
