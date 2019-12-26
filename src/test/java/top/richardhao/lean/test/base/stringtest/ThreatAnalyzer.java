package top.richardhao.lean.test.base.stringtest;

import java.util.Scanner;
import java.util.regex.MatchResult;

public class ThreatAnalyzer {

    static String threatData =
            "50.27.82.161@01/10/2005\n" +
                    "204.45.234.4@02/11/2015\n" +
                    "58.27.82.161@02/11/2015\n" +
                    "58.27.82.161@02/11/2015\n" +
                    "58.27.82.161@02/12/2015\n" +
                    "58.27.82.161@02/12/2015\n" +
                    "[Next log section with different data format]";
    public static void main(String[] args){
        Scanner scanner = new Scanner(threatData);
        String pattern = "(\\d+[.]\\d+[.]\\d+[.]\\d+)@" +
                "(\\d{2}/\\d{2}/\\d{4})";
        while (scanner.hasNext(pattern)){
            scanner.next(pattern);
            MatchResult match = scanner.match();
            String ip = match.group(1);
            String date = match.group(2);
            System.out.format("Threat on %s form %s\n", date, ip);
        }
    }

}
