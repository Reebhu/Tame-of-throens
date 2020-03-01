package com.tameofthrones.test;

import java.net.URL;

import org.junit.Test;

import com.tameofthrones.Solution;

public class GoldenCrownTest
{

	@Test
	public void testInput1()
	{
		final URL inputURL = GoldenCrownTest.class.getResource("TestInput1.txt");
		final String path = inputURL.getPath().replace("%20", " ");
		final String args[] = {
				path
		};
		Solution.main(args);
	}

	@Test
	public void testInput2()
	{
		final URL inputURL = GoldenCrownTest.class.getResource("TestInput2.txt");
		final String path = inputURL.getPath().replace("%20", " ");
		final String args[] = {
				path
		};
		Solution.main(args);
	}

	@Test
	public void testInput3()
	{
		final URL inputURL = GoldenCrownTest.class.getResource("TestInput3.txt");
		final String path = inputURL.getPath().replace("%20", " ");
		final String args[] = {
				path
		};
		Solution.main(args);
	}

}
