package com.tameofthrones.test.kingom;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.tameofthrones.kingdom.AllyFinder;

public class AllyFinderTest
{
	AllyFinder ally = new AllyFinder();

	@Rule
	public ExpectedException thrown = ExpectedException.none();

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

	@Test
	public void test_failure_IllegalArumentexception()
	{
		thrown.expect(IllegalArgumentException.class);
		ally.findAlly("KSJ OWLAOWLBOWLC");
	}
}
