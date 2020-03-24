package com.tameofthrones.kingdom;

import java.util.HashMap;
import java.util.Map;

import com.tameofthrones.cipher.SeasarCipher;

public class Kingdom
{
	private KingdomEnum kingdom;

	private String emblem;

	/**
	 * Create a map with <char,int> as <key,value> pair to count the number of times
	 * char is repeated in the emblem.
	 *
	 * @param emblem
	 * @return
	 */
	private Map<Character, Integer> lookUpEmblem(char[] emblem)
	{
		final Map<Character, Integer> lookTable = new HashMap<>();
		for (final char key : emblem)
		{
			if (lookTable.containsKey(key))
			{
				lookTable.put(key, lookTable.get(key) + 1);
			}
			else
			{
				lookTable.put(key, 1);
			}
		}
		return lookTable;
	}

	/**
	 * Process the msg and tells if the kingdom is an ally to SPACE kingdom or not.
	 *
	 * @param msg
	 * @return
	 */
	public boolean hasAlligence(char[] msg)
	{
		char[] emblemChars = emblem.toCharArray();

		// Obtain encode emblem.
		emblemChars = SeasarCipher.getInstance().encodeEmblem(emblemChars);

		// Create the lookup map for given emblem.
		final Map<Character, Integer> lookup = lookUpEmblem(emblemChars);

		int i = 0;

		// Iterate over the msg and if the characters match reduce the count by 1 from
		// Map.If all the values in Map is found all the keys should have value 0 in
		// lookup.
		while (i < msg.length)
		{
			int count = 0;
			final char key = msg[i];
			if (lookup.containsKey(key))
			{
				count = lookup.get(key);
				if (count > 0)
				{
					lookup.put(key, count - 1);
				}
			}
			i++;
		}
		boolean hasWonAlligence = true;

		// Check for the values in lookUp and even if one value is greater than 0 all
		// the letters are not present in chiper message. Hence, that Kingdom will not
		// ally itself to King Shan.
		for (final Map.Entry<Character, Integer> entry : lookup.entrySet())
		{
			if (entry.getValue() > 0)
			{
				hasWonAlligence = false;
				break;
			}
		}

		return hasWonAlligence;
	}

	@Override
	public String toString()
	{
		return "Kingdom [kingdom=" + kingdom + ", emblem=" + emblem + "]";
	}

	private Kingdom(Builder builder)
	{
		kingdom = builder.kingdom;
		emblem = builder.emblem;
	}

	private Kingdom()
	{

	}

	public static class Builder
	{
		private KingdomEnum kingdom;

		private String emblem;

		public static Builder create()
		{
			return new Builder();
		}

		public Builder withKingdom(KingdomEnum kingdom)
		{
			this.kingdom = kingdom;
			return this;
		}

		public Builder withEmblem()
		{
			emblem = kingdom.getEmblem();
			return this;
		}

		public Kingdom build()
		{
			return new Kingdom(this);
		}
	}

}
