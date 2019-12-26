/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package top.richardhao.lean.test.base.stringtest;

import java.util.Arrays;

/**
 *
 * @author RichardHaoFang
 */
public class RegexSplit {

    public static String knights =
            "Then, when you have found the shrubbery,you must "+
            "Cut down the mightiest tree in the forest... " +
            "with... a herring!";

    public static void split(String regex) {
        System.out.println(Arrays.toString(knights.split(regex, 1)));
    }
    public static void main(String[] args) {
//        split(" ");
//        split("\\W+");
//        split("n\\W+");
        System.out.println(knights.replaceFirst("f\\w+", "located"));
        System.out.println(knights.replaceAll("shrubbery|tree|herring", "banana"));
    }
}
