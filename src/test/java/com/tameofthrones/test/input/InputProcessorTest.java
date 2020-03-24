package com.tameofthrones.test.input;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.io.BufferedReader;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.tameofthrones.input.InputProcessor;
import com.tameofthrones.kingdom.AllyFinder;

public class InputProcessorTest
{

	AllyFinder mockAllyFinder = Mockito.mock(AllyFinder.class);

	BufferedReader mockBufferedReader = Mockito.mock(BufferedReader.class);

	InputProcessor processor = new InputProcessor(mockAllyFinder);

	private static final String FIRE = "FIRE";

	private static final String LAND = "LAND";

	private static final String ICE = "ICE";

	@Before
	public void setup() throws IOException
	{
		when(mockBufferedReader.readLine()).thenReturn(FIRE, ICE, LAND, null);

		when(mockAllyFinder.findAlly(FIRE)).thenReturn(FIRE);
		when(mockAllyFinder.findAlly(ICE)).thenReturn(ICE);
		when(mockAllyFinder.findAlly(LAND)).thenReturn(LAND);
	}

	@Test
	public void test_success() throws IOException
	{
		final String actual = processor.processInput(mockBufferedReader);

		assertEquals("SPACE FIRE ICE LAND", actual);
	}

	@Test
	public void test_success_NONE() throws IOException
	{
		when(mockBufferedReader.readLine()).thenReturn(FIRE, ICE, null);
		when(mockAllyFinder.findAlly(FIRE)).thenReturn(FIRE);
		when(mockAllyFinder.findAlly(ICE)).thenReturn(ICE);

		final String actual = processor.processInput(mockBufferedReader);

		assertEquals("NONE", actual);
	}

	@Test
	public void test_success_SameAlly() throws IOException
	{
		when(mockBufferedReader.readLine()).thenReturn(ICE, ICE, ICE, null);
		when(mockAllyFinder.findAlly(ICE)).thenReturn(ICE);

		final String actual = processor.processInput(mockBufferedReader);

		assertEquals("NONE", actual);
	}

	@Test
	public void test_failure() throws IOException
	{

		when(mockBufferedReader.readLine()).thenReturn(ICE, null);

		final String actual = processor.processInput(mockBufferedReader);
		assertEquals("NONE", actual);
	}

	@Test
	public void test_success_with_Exception() throws IOException
	{
		when(mockBufferedReader.readLine()).thenReturn(FIRE, ICE, LAND, "UNKNOW", null);
		when(mockAllyFinder.findAlly("UNKNOW")).thenThrow(new IllegalArgumentException());

		final String actual = processor.processInput(mockBufferedReader);

		assertEquals("SPACE FIRE ICE LAND", actual);
	}
}
