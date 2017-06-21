package com.briefing.trash.dev.competition.prepare;

public enum Gender {

	FEMALE(0, "F"),
	MALE(1, "M");
	
	public final int key;
	public final String val;
	
	private Gender(int key, String val) {
		this.key = key;
		this.val = val;
	}
	
}
