/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package top.richardhao.lean.test.base.reuse.finaltest;

import javax.swing.JFrame;

/**
 *
 * @author RichardHaoFang
 */
public class FinalInitTest {
    
    public static void main(String args[]) {
        FinalInitTestA test = new FinalInitTestA();
        System.out.println(test);
    }
    
}

class FinalInitTestA {
    
    private final static JFrame x = new JFrame();
    
    static {
         x.show();
    }
}
