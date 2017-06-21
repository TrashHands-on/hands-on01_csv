package com.briefing.trash.dev.competition;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;

/**
 * TODO イケてない
 * Bulletクラスに依存している
 */
public class BubbleSort implements ISort<Bullet>{

//    @Override
//    public Bullet[] sort(Bullet[] bullets) {
//        // ソート開始
//        final LocalDateTime sortStart = LocalDateTime.now();
//        System.out.println("## SORT START " + sortStart);
//
//        // バブルソート
//        Bullet[] ret = BubbleSort.bubbleSort(bullets);
//
//        // ソート終了
//        final LocalDateTime sortFinish = LocalDateTime.now();
//        System.out.println("### END   " + sortFinish);
//        System.out.println("### takes " + sortStart.until(sortFinish, ChronoUnit.MILLIS));
//        
//        return ret;
//    }
    
    /**
     * 
     * @param bullets
     * @return
     */
    private static Bullet[] bubbleSort(Bullet[] bullets) {
        Bullet tmp;
        int bulletsSize = bullets.length;

        for (int i = 0; i < bulletsSize; i++)
        {
            for (int j = i + 1; j < bulletsSize; j++)
            {
                if (bullets[i].compareTo(bullets[j]) > 0)
                { // XXX 昇順の場合小さい場合の方が次第に少なくなる気がするからisSmallerThanを利用したけど大丈夫か？
                    tmp = bullets[i];
                    bullets[i] = bullets[j];
                    bullets[j] = tmp;
                }
            }
        }
        return bullets;
    }

	@Override
	public Bullet[] sort(Bullet[] array, Comparator<Bullet> comparator) {
		// TODO Auto-generated method stub
		return null;
	}
}
