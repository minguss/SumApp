package com.ibm.sum.app;

import org.junit.Assert;
import org.junit.Test;

import com.ibm.sumapp.Adder;

public class AdderTest {

	@Test
	public void testAdder() {
		Adder adder = new Adder();
		
		int actual = adder.add(1, 1);
		Assert.assertEquals(2, actual);
		
	}
}
