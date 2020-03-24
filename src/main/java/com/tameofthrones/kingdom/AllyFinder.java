package com.tameofthrones.kingdom;

public class AllyFinder
{
	public String findAlly(String input)
	{
		// Name of the kingdom
		final String kingdomName = input.split(" ")[0];

		// Message being sent to that kingdom
		final String msg = getMessage(input, kingdomName).toLowerCase();

		final KingdomEnum kingdomEnum = KingdomEnum.valueOf(kingdomName.toUpperCase());

		// Create the kingdom object with its emblem.
		final Kingdom ally = Kingdom.Builder.create().withKingdom(kingdomEnum).withEmblem().build();

		final boolean hasAlligence = ally.hasAlligence(msg.toCharArray());

		if (hasAlligence)
		{
			return kingdomName;
		}
		return "";
	}

	private String getMessage(String input, String kingdomName)
	{

		return input.replace(kingdomName + " ", "");
	}
}
