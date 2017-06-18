package com.briefing.trash.dev.competition;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Set;

public class SortPractice {


    public static void main(String[] args) throws FileNotFoundException {

        //時間計測開始
        long start = System.currentTimeMillis();
        System.out.println("---START---");

        String fileInput = "/Users/kumetoshiyuki/Downloads/test01.csv";
        String fileOutput = "/Users/kumetoshiyuki/Downloads/TestOutput.csv";

        try {
            File fileIn = new File(fileInput);
            File fileOut = new File(fileOutput);

            if(fileOut.exists()) {fileOut.delete();}

            BufferedReader br = new BufferedReader(new FileReader(fileIn));

            String line;
            String headerStr = "";
            HashMap<Integer, String> map = new HashMap<Integer, String>();
            int i = 0;

            while ((line = br.readLine()) != null) {
              String[] data = line.split(",");
              if (i == 0) {
                  headerStr = line;
              } else {
                  Integer valueNum = Integer.parseInt(data[0]);
                  map.put(valueNum, line);
              }
              i++;
            }

            Set<Integer> itemIdSet = map.keySet();
            Object[] mapKey = itemIdSet.toArray();
            System.out.println(headerStr);
            HashMap<Integer, String> map2 = new HashMap<Integer, String>();

            for (int n = 0; n < mapKey.length; n++) {
                for (int m = mapKey.length-1; m > n; m--) {
                    if (Integer.parseInt(mapKey[m].toString()) < Integer.parseInt(mapKey[m-1].toString())) {
                      Object t = mapKey[m];
                      mapKey[m] = mapKey[m-1];
                      mapKey[m-1] = t;
                    }
                }
                map2.put(Integer.parseInt(mapKey[n].toString()), map.get(mapKey[n]));
                //System.out.println(map.get(mapKey[n]));
            }

            br.close();

            //確認
            for (int a = 0; a < map2.size(); a++ ) {
                System.out.println(map.get(mapKey[a]));
            }

            FileWriter fileWrite = new FileWriter(fileOutput, false);
            PrintWriter printWriter = new PrintWriter(new BufferedWriter(fileWrite));

            for (int a = 0; a < map2.size(); a++ ) {
                printWriter.println(map.get(mapKey[a]));
                //System.out.println(map.get(mapKey[a]));
            }

            printWriter.close();
            System.out.println("---CSV Output Done---");

          } catch (IOException e) {
            System.out.println(e);
          }

        System.out.println("---END---");
        //時間計測終了
        long end = System.currentTimeMillis();
        System.out.println("TIME:" + (end - start)  + "ms");
    }

    //後々関数は抽出

}
