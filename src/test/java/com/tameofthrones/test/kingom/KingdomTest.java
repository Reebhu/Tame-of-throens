package com.tameofthrones.test.kingom;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.tameofthrones.kingdom.Kingdom;
import com.tameofthrones.kingdom.KingdomEnum;

public class KingdomTest
{

	@Test
	public void test_HappyPath()
	{
		final Kingdom kingdom = getKingdom(KingdomEnum.ICE);
		assertTrue(kingdom.hasAlligence("thafstwftvdsao".toCharArray()));
	}

	@Test
	public void test_NotAlly()
	{
		final Kingdom kingdom = getKingdom(KingdomEnum.AIR);
		assertFalse(kingdom.hasAlligence("roafwfeoweg".toCharArray()));
	}

	private Kingdom getKingdom(KingdomEnum kingdomEnum)
	{
		return Kingdom.Builder.create().withKingdom(kingdomEnum).withEmblem().build();
	}
}
