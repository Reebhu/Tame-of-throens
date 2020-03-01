package com.tameofthrones.kingdom;

public enum KingdomEnum
{
	SPACE("Gorilla"),
	LAND("Panda"),
	WATER("Octopus"),
	ICE("Mammoth"),
	AIR("Owl"),
	FIRE("Dragon");

	private String emblem;

	KingdomEnum(String emblem)
	{
		this.emblem = emblem;
	}

	public String getEmblem()
	{
		return emblem.toLowerCase();
	}
}
