package com.tameofthrones.test.cipher;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.tameofthrones.cipher.SeasarCipher;

public class SeasarCipherTest
{
	private final SeasarCipher cipher = SeasarCipher.getInstance();

	@Test
	public void test_success_OWL()
	{
		final char[] expected = "rzo".toCharArray();
		final char[] actual = cipher.encodeEmblem("owl".toCharArray());
		assertEquals(getString(expected), getString(actual));
	}

	@Test
	public void test_success_PANDA()
	{
		final char[] expected = "ufsif".toCharArray();
		final char[] actual = cipher.encodeEmblem("panda".toCharArray());
		assertEquals(getString(expected), getString(actual));
	}

	@Test
	public void test_success_OCTOPUS()
	{
		final char[] expected = "vjavwbz".toCharArray();
		final char[] actual = cipher.encodeEmblem("octopus".toCharArray());
		assertEquals(getString(expected), getString(actual));
	}

	@Test
	public void test_success_Mammoth()
	{
		final char[] expected = "thttvao".toCharArray();
		final char[] actual = cipher.encodeEmblem("mammoth".toCharArray());
		assertEquals(getString(expected), getString(actual));
	}

	@Test
	public void test_success_Dragon()
	{
		final char[] expected = "jxgmut".toCharArray();
		final char[] actual = cipher.encodeEmblem("dragon".toCharArray());
		assertEquals(getString(expected), getString(actual));
	}

	private String getString(char[] charArr)
	{
		return String.valueOf(charArr);
	}
}
