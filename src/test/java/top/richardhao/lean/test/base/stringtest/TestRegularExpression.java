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
public class TestRegularExpression {

    public static void main(String[] args){
        if (args.length < 2) {
            System.out.println("Usage:\njava TestRegualrExpression "+
                    "characterSequence regualtExpression");
            System.exit(0);
        }
        System.out.println("Input: \""+args[0]+"\"");
        for(String arg : args){
            System.out.println("Regualr expression: \""+arg+"\"");
            Pattern p = Pattern.compile(arg);
            Matcher m = p.matcher(args[0]);
            while(m.find()){
                System.out.println("Matcher: \""+m.group()+"\" at position "
                        + m.start()+"-"+(m.end()-1));
            }
        }
    }
    
}
