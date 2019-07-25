/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top.richardhao.lean.test.base.stringtest;

import java.util.Scanner;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import org.apache.commons.text.StringEscapeUtils;

/**
 *
 * @author RichardHaoFang
 */
public class RegexTest {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
//        System.out.println("\u263A");
//        System.out.println(StringEscapeUtils.escapeJava("\1"));
//        System.out.println(StringEscapeUtils.unescapeJava("\1"));
//        System.out.println(Pattern.matches("1*", "1111"));
        while(in.hasNextLine()) {
            String source = in.nextLine();
            String regex = in.nextLine();
            System.out.println("regexEscape:"+StringEscapeUtils.escapeJava(regex));
            System.out.println("reslut:"+Pattern.matches(regex, source));
            System.out.println("________________________________________________");
        }
    }
}