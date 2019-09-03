package top.richardhao.lean.test.base.stringtest;

import java.util.Arrays;
import java.util.regex.Pattern;

public class SplitDemo {

    public static void main(String args[]) {
        String input =
                "This!! usually use!! of exclamation !!points";
        System.out.println(Arrays.deepToString(Pattern.compile("!!").split(input)));
        System.out.println(Arrays.deepToString(Pattern.compile("!!").split(input,3)));
    }
}
