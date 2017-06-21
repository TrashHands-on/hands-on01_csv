package com.briefing.trash.dev.competition.prepare;

import java.time.LocalDate;

public class Member {

	public static final LocalDate start = LocalDate.of(2008, 5, 17);

	public final String memberNo;
	public final String name;
	public final Gender gender;
	public final FavouriteMember favourite;
	public final int career;
	public final int old;
	public final String UUID;

	/**
	 * 雑だなぁ
	 * @param name
	 * @param gender
	 */
	public Member(String name, Gender gender)
	{
		this.memberNo = Utils.getRamdom(name);
		this.name = name;
		this.gender = gender;
		this.favourite = FavouriteMember.AYAKA;
		this.career = 8;
		this.old = (int) Math.random() * 72;
		this.UUID = Utils.getUUID();
	}
	
	@Override
	public String toString()
	{
		return String.join(",", memberNo, name, gender.val, favourite.nickName, (career + ""), (old + "") + UUID);
	}
}
