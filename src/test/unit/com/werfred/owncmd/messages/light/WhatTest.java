package com.werfred.owncmd.messages.light;

import org.junit.Assert;
import org.junit.Test;

public class WhatTest {

	@Test
	public void testOn() {
		What w = What.TURN_ON;
		Assert.assertEquals("1", w.getText());
	}
	
	@Test
	public void testOff() {
		What w = What.TURN_OFF;
		Assert.assertEquals("0", w.getText());
	}

}
