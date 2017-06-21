package com.briefing.trash.dev.competition.prepare;

import java.util.Random;
import java.util.UUID;
import java.util.zip.CRC32;
import java.util.zip.Checksum;

public class Utils {

	private static Random rnd = new Random();
	
	/**
	 * 年齢っぽい乱数を生成する。
	 * @return
	 */
	public static int getRandomOld() 
	{
		return rnd.nextInt(72) + 5;
	}
	/**
	 * UUID取得
	 * @return
	 */
	public static String getUUID()
	{
		return UUID.randomUUID().toString();
	}
	/**
	 * なるべく重複しないランダム値を取得する。
	 * 乱数とチェックサムを繋げたらそれなりに重複減りそうっていう安直な考えが根底にある。
	 * @param name
	 * @return
	 */
	public static String getRamdom(String name) 
	{
		String prefix = randomPrefix();
		String surfix = randomSurfix(name);
		// 乱数とチェックサムを繋げたらそれなりに重複減りそうっていう安直な考え
		return prefix + surfix;
	}

	/**
	 * ランダム値のサフィックスを取得する。中身は文字列のチェックサム。
	 * @param val
	 * @return
	 */
	private static String randomSurfix(String val) 
	{
		byte bytes[] = val.getBytes();
		Checksum checksum = new CRC32();
		checksum.update(bytes, 0, bytes.length);

		long checksumValue = checksum.getValue();
		return String.format("%20s", Long.toUnsignedString(checksumValue)).replace(" ", "0");
	}
	
	/**
	 * ランダム値のプレフィックスを取得する。
	 * @return
	 */
	private static String randomPrefix() {
		return String.format("%02d", (int)(Math.random() * 100));
	}

}
