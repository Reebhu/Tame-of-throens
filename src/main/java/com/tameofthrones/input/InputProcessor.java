package com.tameofthrones.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

import com.tameofthrones.kingdom.AllyFinder;

public class InputProcessor
{
	// ==CONSTANTS==
	private static final String NONE = "NONE";

	private static final String SPACE = "SPACE";

	private static final int requiredAllies = 3;

	private final AllyFinder allyFinder;

	// Getting the instance from constructor to reduce coupling.
	public InputProcessor(AllyFinder allyFinder)
	{
		this.allyFinder = allyFinder;
	}

	public String processInput(BufferedReader reader) throws IOException
	{
		final Set<String> allies = new LinkedHashSet<>();

		// Since we want to check if space can be the ruler.
		String answer = "";

		String input;
		while ((input = reader.readLine()) != null)
		{
			try
			{
				answer = allyFinder.findAlly(input);
				if (!answer.isEmpty())
				{
					allies.add(answer);
				}
			}
			catch (final IllegalArgumentException e)
			{
			}
		}
		return findOutput(allies);
	}

	private static String findOutput(Set<String> allies)
	{

		// The number of allies need to be greater than 3 to become the ruler.
		if (allies.size() >= requiredAllies)
		{
			final StringBuilder sb = new StringBuilder();
			sb.append(SPACE + " ");
			for (final String ally : allies)
			{
				sb.append(ally + " ");
			}
			return sb.toString().trim();
		}
		else
		{
			return NONE;
		}
	}
}
