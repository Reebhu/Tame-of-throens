package com.tameofthrones.cipher;

/**
 * Represents the Seasar Chiper. Made singleton as this class should be
 * instantiated just once.
 *
 * @author Reebhu
 */
public class SeasarCipher
{
	private static SeasarCipher INSTANCE;

	private static final int MAX_NO_ALPHABETS = 26;

	private final char[] queue = new char[MAX_NO_ALPHABETS];

	private static final char ch = 'a';

	public static SeasarCipher getInstance()
	{
		if (INSTANCE == null)
		{
			return new SeasarCipher();
		}
		return INSTANCE;
	}

	/**
	 * Create a queue with all the Alphabets of English in lowercase.
	 */
	private void fillQueue()
	{
		for (int i = 0; i < MAX_NO_ALPHABETS; i++)
		{
			queue[i] = (char) (ch + i);
		}
	}

	/**
	 * Encode the given charter according to Seasar Chiper.
	 *
	 * @param character
	 * @param len
	 * @return Encoded character.
	 */
	private char getEncodedChar(char character, int len)
	{
		final int index = character - ch;
		// Effectively working like a circular array i.e. when index > 26 it will start
		// at 0.
		return queue[(index + len) % MAX_NO_ALPHABETS];
	}

	/**
	 * Encode the emblem to Seasar Chiper
	 *
	 * @param emblem
	 * @return encoded emblem.
	 */
	public char[] encodeEmblem(char[] emblem)
	{
		for (int i = 0; i < emblem.length; i++)
		{
			emblem[i] = getEncodedChar(emblem[i], emblem.length);
		}
		return emblem;
	}

	private SeasarCipher()
	{
		fillQueue();
	}
}
