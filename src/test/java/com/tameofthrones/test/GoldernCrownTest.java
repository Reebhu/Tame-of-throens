package com.tameofthrones.test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.tameofthrones.Solution;

public class GoldernCrownTest
{

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

	private final PrintStream originalOut = System.out;

	private final PrintStream originalErr = System.err;

	@Before
	public void setUpStreams()
	{
		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));
	}

	@After
	public void restoreStreams()
	{
		System.setOut(originalOut);
		System.setErr(originalErr);
	}

	@Test
	public void testInput1()
	{
		final URL inputURL = GoldernCrownTest.class.getResource("TestInput1.txt");
		final String path = inputURL.getPath().replace("%20", " ");
		final String args[] = {
				path
		};
		Solution.main(args);
		assertEquals("SPACE LAND ICE FIRE\r\n", outContent.toString());
	}

	@Test
	public void testInput2()
	{
		final URL inputURL = GoldernCrownTest.class.getResource("TestInput2.txt");
		final String path = inputURL.getPath().replace("%20", " ");
		final String args[] = {
				path
		};
		Solution.main(args);
		assertEquals("NONE\r\n", outContent.toString());
	}

	@Test
	public void testInput3()
	{
		final URL inputURL = GoldernCrownTest.class.getResource("TestInput3.txt");
		final String path = inputURL.getPath().replace("%20", " ");
		final String args[] = {
				path
		};
		Solution.main(args);
		assertEquals("SPACE AIR LAND ICE\r\n", outContent.toString());
	}

}
