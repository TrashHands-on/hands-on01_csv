package com.briefing.trash.dev.competition;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortPractice {

    public static final String DIR_PATH = "resources/csv";
    public static final String INPUT_FILE_NAME = "input.csv";
    public static final String OUTPUT_FILE_NAME = "out.csv";

    /**
     * エントリポイントだよ。
     * @param args　未使用
     * @throws IOException
     */
    public static void main(String[] args) throws IOException 
    {

    	// 初期化処理
    	init();

    	//時間計測開始
        final LocalDateTime start = LocalDateTime.now();
        System.out.println("### START " + start);

        // ファイル読み込み
        // ちょっとめんどくさくなったのでStreamを使って横着する
        Path inputPath = Paths.get(DIR_PATH + "/" + INPUT_FILE_NAME);
        List<Bullet> bulletList = Files.lines(inputPath).parallel()
                .map(Bullet::new)
                .collect(Collectors.toList());
        // ヘッダを取得しつつリストから除去
        String header = bulletList.remove(0).toString();
        // 配列形式に変換(XXX 全体的に冗長)
        Bullet[] bullets = bulletList.stream()
        		.toArray(Bullet[]::new);        

        // ソート
        ISort<Bullet> sorter = new BubbleSort();
        Bullet[] sortedBullets = sorter.sort(bullets,null);

        // ファイル書き出し
        Path outputPath = Paths.get(DIR_PATH + "/" + OUTPUT_FILE_NAME);
        List<String> writeList = Arrays.asList(sortedBullets).stream()
                .map(Bullet::toString)
                .collect(Collectors.toList());
        // ヘッダ追記
        writeList.add(0, header);
        // ファイルアウト
        Files.write(outputPath, writeList, StandardOpenOption.CREATE_NEW);

        // 終了
        final LocalDateTime end = LocalDateTime.now();
        System.out.println("### END   " + end);
        System.out.println("### takes " + start.until(end, ChronoUnit.MILLIS));
    }

    /**
     * 初期化処理
     * <li>前回実施したソート結果CSVの除去</li>
     * @throws IOException 
     */
    private static void init() throws IOException 
    {
    	Files.deleteIfExists(Paths.get(DIR_PATH + "/" + OUTPUT_FILE_NAME));
    }
}
