package com.tameofthrones;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.tameofthrones.input.InputProcessor;
import com.tameofthrones.kingdom.AllyFinder;

public class Solution
{

	// == MAIN ==
	public static void main(String[] args)
	{
		final String filePath = args[0];

		BufferedReader reader;
		try
		{
			final File file = new File(filePath);
			reader = new BufferedReader(new FileReader(file));

			final InputProcessor processor = new InputProcessor(new AllyFinder());
			final String output = processor.processInput(reader);
			System.out.println(output);

			reader.close();
		}
		catch (final IOException e)
		{
			System.out.println(e);
		}
	}
}
