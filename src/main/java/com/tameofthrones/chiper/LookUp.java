package com.tameofthrones.chiper;

import java.util.HashMap;
import java.util.Map;

/**
 * Lookup the emblem for number of charaters in the Emblem.
 * 
 * @author Reebhu
 */
public class LookUp
{
	private static LookUp INSTANCE = null;

	private LookUp()
	{
	}

	public static LookUp getInstance()
	{
		// synchronized block to remove overhead
		synchronized (LookUp.class)
		{
			if (INSTANCE == null)
			{
				return new LookUp();
			}
			return INSTANCE;
		}
	}

	/**
	 * Create a map with <char,int> as <key,value> pair to count the number of times
	 * char is repeated in the emblem.
	 *
	 * @param emblem
	 * @return
	 */
	public Map<Character, Integer> lookUpEmblem(char[] emblem)
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
}
