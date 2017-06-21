package com.briefing.trash.dev.competition.prepare;

import java.util.Arrays;
import java.util.List;

public enum FirstNameCandidates 
{

	MASAHIRO(Gender.MALE, "正広"),
	SHINGO(Gender.MALE, "慎吾"),
	GORO(Gender.MALE, "吾郎"),
	TAKUYA(Gender.MALE, "拓哉"),
	TSUYOSHI(Gender.MALE, "剛"),
	KATSUYUKI(Gender.MALE, "且行"),
	MAIMI(Gender.FEMALE, "舞美"),
	SAKI(Gender.FEMALE, "早貴"),
	AIRI(Gender.FEMALE, "愛理"),
	CHISATO(Gender.FEMALE, "千聖"),
	MAI(Gender.FEMALE, "舞");

	public final Gender gender;
	public final String name;
	
	private FirstNameCandidates(Gender gender, String name)
	{
		this.gender = gender;
		this.name = name;
	}
	
	public static List<FirstNameCandidates> getList()
	{
		return Arrays.asList(FirstNameCandidates.values());
	}
}
