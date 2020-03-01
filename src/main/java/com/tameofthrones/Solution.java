package com.tameofthrones;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.tameofthrones.input.Ally;

public class Solution
{
	// ==CONSTANTS==
	private static final String NONE = "NONE";

	private static final String SPACE = "SPACE";

	private static final int requiredAllies = 3;

	// == MAIN ==
	public static void main(String[] args)
	{
		final String filePath = args[0];
		final File file = new File(filePath);

		final Ally inputprocessor = new Ally();
		final StringBuilder output = new StringBuilder();

		// Since we want to check if space can be the ruler.
		output.append(SPACE + " ");
		String answer = "";
		BufferedReader reader;
		try
		{
			reader = new BufferedReader(new FileReader(file));
			String input;
			while ((input = reader.readLine()) != null)
			{
				try
				{
					answer = inputprocessor.findAlly(input);
					if (!answer.isEmpty())
					{
						output.append(answer + " ");
					}
				}
				catch (final IllegalArgumentException e)
				{
				}
			}
			printOutput(output);
		}
		catch (final IOException e)
		{
			System.out.println("Exception :" + e.getMessage());
		}

	}

	private static void printOutput(StringBuilder output)
	{
		final String[] allies = output.toString().split(" ");

		// The number of allies need to be greater than 3 to become the ruler.
		if (allies.length >= requiredAllies + 1)
		{
			System.out.println(output.toString().trim());
		}
		else
		{
			System.out.println(NONE);
		}
	}
}
