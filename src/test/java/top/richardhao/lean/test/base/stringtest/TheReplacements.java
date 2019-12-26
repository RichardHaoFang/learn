package top.richardhao.lean.test.base.stringtest;

import top.richardhao.lean.test.base.IO.TextFile;

import java.io.*;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TheReplacements {


    /*! Here's a block of text to use as input to
    the regular expression mather. Note  that we'll
    first extract the block of text by looking for
    the special delimiters, then process the
    extracted blocks.!*/

    public static void main(String[] args) {
        String s = "/*! Here's a block of text to use as input to\n"+
    "the regular expression mather. Note  that we'll\n"+
    "first extract the block of text by looking for\n"+
    "the special delimiters, then process the\n"+
    "extracted blocks.!*/";
        Matcher mInput =
                Pattern.compile("/\\*!(.*)!\\*/",Pattern.DOTALL)
                .matcher(s);
        if(mInput.find()) {
            s = mInput.group(1);
        }
        System.out.println(s);
        s = s.replaceAll(" {2,}"," ");
        System.out.println(s);
        s = s.replaceAll("(?m)^ +","");
        System.out.println(s);
        s = s.replaceFirst("[aeiou]", "(VOWEL1)");
        System.out.println(s);
        StringBuffer sbuf = new StringBuffer();
        Pattern p = Pattern.compile("[aeiou]");
        Matcher m = p.matcher(s);
        while(m.find()) {
            m.appendReplacement(sbuf,"$0*");
        }
        m.appendTail(sbuf);
        System.out.println(sbuf);
    }
}
