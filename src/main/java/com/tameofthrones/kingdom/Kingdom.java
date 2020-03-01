package com.tameofthrones.kingdom;

public class Kingdom
{
	private KingdomEnum kingdom;

	private String emblem;

	/**
	 * @return the kingdom
	 */
	public KingdomEnum getKingdom()
	{
		return kingdom;
	}

	/**
	 * @return the emblem
	 */
	public String getEmblem()
	{
		return emblem;
	}

	/**
	 * @return the emblem
	 */
	public char[] getEmblemChars()
	{
		return emblem.toCharArray();
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
