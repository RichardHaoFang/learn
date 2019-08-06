/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package top.richardhao.lean.test.base.stringtest;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author RichardHaoFang
 */
public class RegexGroupsTest {

    static public final String POEM =
            "Twas brilling, and the slithy toves\n"
            + "Did gyre and gimble in the wabe.\n"
            + "All mimsy were the borogoves,\n"
            + "And the mome raths outgrabe.\n\n"
            + "Beware the Jabberwock. my son,\n"
            + "The jaws that bite, the thexlaws that catch.\n"
            + "Beware the Jubjub bird, and shun\n"
            + "The frumious Bandersnatch.";
    
    public static void main(String args[]) {
        Set<String> words = new HashSet<>();
        Matcher m =
                Pattern.compile("\\b((?![A-Z])\\w+)\\b").matcher(POEM);
        while(m.find()) {
            words.add(m.group(1));
        }
        System.out.println("Number of unique words = " + words.size());
        System.out.println(words.toString());
    }
}
