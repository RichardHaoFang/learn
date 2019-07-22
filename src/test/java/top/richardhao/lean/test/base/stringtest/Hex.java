/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package top.richardhao.lean.test.base.stringtest;

import java.io.File;

/**
 *
 * @author RichardHaoFang
 */
public class Hex {
    
    public static void main(String args[]) {
//        if(args.length == 0)
//            System.out.println(format(BinaryFile.read("Hex.class")));
//        else
//            System.out.println(format(BinaryFile.read(new File(args[0]))));
    }

    public static String format(byte [] data) {
        StringBuilder result = new StringBuilder();
        int n = 0;
        for(byte b :data) {
            if(n%16 == 0) {
                result.append(String.format("%05X: " ,n));
            }
            result.append(String.format("%02X", b));
            n++;
            if(n%16 == 0) {
                result.append("\n");
            }
        }
        return result.toString();
    }
}
