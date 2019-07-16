/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package top.richardhao.lean.test.base.stringtest;

/**
 *
 * @author RichardHaoFang
 */
public class StringFormat {

    public static void main(String args[]) {
        System.out.format("Row1: [%d %f]\n", 10, 12.123);
        System.out.printf("Row1: [%d %f]\n", 10, 12.123);
    }
}
