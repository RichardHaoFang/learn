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
public class RegexExercise10 {
    
    public static void main(String[] args) {
        String source = "Java now has regular expression";
        String[] regEx = {"^Java", "\\Breg.*",
                "n.w\\s+h(a|i)s", "s?", "s*", "s+", "s{4}", "s{1}.",
                "s{0,3}"};
        System.out.println("Source string: " + source);
        for(String pattern : regEx){
            System.out.println(
                    "Regular Expression: \"" + pattern +"\"");
            Pattern p = Pattern.compile(pattern);
            Matcher m = p.matcher(source);
            while(m.find()){
                System.out.println("Match \"" + m.group() +
                       "\" at position" + m.start()+ "-" +
                        (m.end() - 1));
            }
        }
    }
}
