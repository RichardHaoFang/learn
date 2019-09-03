package top.richardhao.lean.test.base.stringtest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Resetting {

    public static void main(String args[]) {
        Matcher m = Pattern.compile("[frb][aiu][gx]")
                .matcher("fix rug with bags");
        while(m.find()) {
            System.out.print(m.group() + " ");
        }
        System.out.println();
        m.reset("fix the rig with bags");
        while(m.find()) {
            System.out.print(m.group() + " ");
        }
        System.out.println();
    }
}
