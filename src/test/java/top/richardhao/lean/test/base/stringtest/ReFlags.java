package top.richardhao.lean.test.base.stringtest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReFlags {

    public static void main(String args[]) {
        Pattern p = Pattern.compile("^java",
                Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
        Matcher m = p.matcher(
                "java has regex\nJava has Regex\nJAVA has regex");
        while(m.find()) {
            System.out.println(m.group());
        }
    }
}
