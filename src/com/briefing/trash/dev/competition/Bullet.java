package com.briefing.trash.dev.competition;

/**
 * LinkedListの簡単実装
 */
public class Bullet implements Comparable<Bullet>{
	/** キー */
    final String key;
    /** オリジナルのレコード文字列 */
    final String val; // KEYも含む全文字列

    Bullet(String line) 
    {
        this.key = line.split(",")[0];
        this.val = line;
    }

    boolean isSmallerThan(Bullet bullet) 
    {
        return this.key.compareTo(bullet.key) > 0;
    }
    boolean isLargerThan(Bullet bullet)
    {
        return this.key.compareTo(bullet.key) < 0;
    }
    @Override
    public boolean equals(Object arg)
    {
        if (!(arg instanceof Bullet))
        {
            return false;
        }
        return this.key.equals(((Bullet)arg).key);
    }

    @Override
    public String toString()
    {
        return this.val;
    }

    @Override
    public int compareTo(Bullet bullet) {
        return this.key.compareTo(bullet.key);
    }
}
