package top.richardhao.lean.test.base.stringtest;

import top.richardhao.lean.test.base.IO.TextFile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JStringExtractor {

    static final String STR_EXT_REGEX =
            "\"(?:[^\"\\\\\\n\\r]|?:(\\\\(?:[unbtfr\\\\'\"]|[0-9A-Fa-f]{4}|[0-7]{1,2}|[0-3][0-7]{2})))*\"";

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java JStringExtractor file");
            System.exit(0);
        }
        String src = TextFile.read(args[0]);
        Pattern p =
                Pattern.compile(STR_EXT_REGEX);
        Matcher m = p.matcher(src);
        while(m.find()) {
        }
    }
}
