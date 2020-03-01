package com.tameofthrones.input;

import com.tameofthrones.kingdom.Kingdom;
import com.tameofthrones.kingdom.KingdomEnum;
import com.tameofthrones.message.MessageDecoder;

public class Ally
{
	public String findAlly(String input)
	{
		// Name of the kingdom
		final String kingdomName = input.split(" ")[0];

		// Message being sent to that kingdom
		final String msg = input.split(" ")[1].toLowerCase();

		final KingdomEnum kingdomEnum = KingdomEnum.valueOf(kingdomName.toUpperCase());

		// Create the kingdom object with its emblem.
		final Kingdom kingdom = Kingdom.Builder.create().withKingdom(kingdomEnum).withEmblem().build();

		final MessageDecoder msgDecode = new MessageDecoder();

		final boolean hasAlligence = msgDecode.processMessage(msg.toCharArray(), kingdom.getEmblemChars());

		if (hasAlligence)
		{
			return kingdomName;
		}
		return "";
	}
}
