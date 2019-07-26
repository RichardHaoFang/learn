/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top.richardhao.lean.test.base.stringtest;

import java.util.regex.Pattern;

/**
 *
 * @author RichardHaoFang
 */
public class RegexTest9 {

    public static String knights
            = "Then, when you have found the shrubbery,you must "
            + "Cut down the mightiest tree in the forest... "
            + "with... a herring!A";

    public static void main(String args[]) {
        System.out.println(Pattern.compile("(?i)[aeiou]\\1"));
        System.out.println(Pattern.matches("(?i)[aeiou]\\1", "aa"));
        System.out.println(Pattern.matches("(?i)[aeiou]\\1", "ab"));
        System.out.println(Pattern.matches("(?i)[aeiou]\\1", "aa"));
        System.out.println(knights.replaceAll("(?i)[aeiou]", "_"));
    }
}
