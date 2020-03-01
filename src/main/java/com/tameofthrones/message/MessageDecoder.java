package com.tameofthrones.message;

import java.util.Map;

import com.tameofthrones.chiper.LookUp;
import com.tameofthrones.chiper.SeasarCipher;

public class MessageDecoder
{
	public boolean processMessage(char[] msg, char[] emblem)
	{
		// Obtain encode emblem.
		emblem = SeasarCipher.getInstance().encodeEmblem(emblem);

		// Create the lookup map fpr given emblem.
		final Map<Character, Integer> lookup = LookUp.getInstance().lookUpEmblem(emblem);

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

}
