package com.briefing.trash.dev.competition.prepare;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;

import org.jsoup.Jsoup;

import com.briefing.trash.dev.competition.SortPractice;

/**
 * 力技でCSVデータを生成する
 */
public class InputCsvGenerator {

	/** HEX_CODEって何？ */
	private static final String HEADER = "会員No.,氏名,性別,推しメン,ファン歴年数,年齢,HEX_CODE";

	public static void main(String[] args) throws IOException {
		System.out.println("はじめ");
		// ファイル削除
		Files.deleteIfExists(Paths.get(SortPractice.DIR_PATH + "/" + SortPractice.INPUT_FILE_NAME));

		try(BufferedWriter bw = Files.newBufferedWriter(Paths.get(SortPractice.DIR_PATH + "/" + SortPractice.INPUT_FILE_NAME), StandardCharsets.UTF_8, StandardOpenOption.CREATE_NEW);) 
		{
			bw.write(HEADER);
			bw.newLine();
			for (String resource :UrlConst.PAGE_LIST)
			{
				System.out.println(UrlConst.BASE_URL + resource);
				List<String> list = Jsoup.connect(UrlConst.BASE_URL + resource).get()
						.getElementsByAttributeValue("width", "1000")
						.get(0).children().get(0).children().parallelStream()
						.map(elem -> FirstNameCandidates.getList().stream().map(name -> new Member(elem.getElementsByIndexEquals(1).text() + " " + name.name, name.gender)).collect(Collectors.toList()))
						.flatMap(mems -> mems.stream())
						.map(Member::toString)
						.collect(Collectors.toList());
				for (String record:list) 
				{
					bw.write(record);
					bw.newLine();
				}
				bw.flush();
			}
		}
		System.out.println("おわり");
	}
}
