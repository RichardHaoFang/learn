/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package top.richardhao.lean.test.base.packagetest;

import static top.richardhao.lean.test.base.packagetest.staticclass.StaticImport.getx;

/**
 *
 * @author RichardHaoFang
 */
public class StaticClass {
    
    public static void main(String args[]) {
        System.out.println(getx(1));
    }
}