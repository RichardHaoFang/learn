/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package top.richardhao.lean.test.base.stringtest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author RichardHaoFang
 */
public class RegexExerceise11 {

    public static void main(String args[]) {
        Pattern p = Pattern.compile(
        "(?i)((^[aeiou])|(\\s+[aeiou]))\\w+?[aeiou]\\b");
        Matcher m = p.matcher("Arline ate eight apples and "
                + "one orange while Anita hadn't any");
        while(m.find()) {
            System.out.println("Match \"" + m.group() +
                    "\" at positions " + m.start() + "-" +
                    (m.end() - 1));
        }
    }
}
