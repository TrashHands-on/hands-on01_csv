package com.briefing.trash.dev.competition.prepare;

public enum FavouriteMember {

	AYAKA("あーりん", "佐々木彩夏","Pink");
	
	public final String nickName;
	public final String name;
	public final String color;
	
	private FavouriteMember(String nickName, String name, String color)
	{
		this.nickName = nickName;
		this.name = name;
		this.color = color;
	}
}
