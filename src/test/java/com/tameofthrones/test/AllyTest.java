package com.tameofthrones.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.tameofthrones.input.Ally;

public class AllyTest
{
	Ally ally = new Ally();

	@Test
	public void test_success()
	{
		assertEquals("FIRE", ally.findAlly("FIRE AJXGAMUTA"));
	}

	@Test
	public void test_success_withSPACEs()
	{
		assertEquals("FIRE", ally.findAlly("FIRE AJ XGA MU TA"));
	}

	@Test
	public void test_water()
	{
		assertEquals("WATER", ally.findAlly("WATER aadbvvwjz"));
	}

	@Test
	public void test_failure()
	{
		assertEquals("", ally.findAlly("AIR OWLAOWLBOWLC"));
	}
}
