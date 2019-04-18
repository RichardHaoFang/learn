/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package top.richardhao.lean.test.base.reuse.finaltest;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author RichardHaoFang
 */
public class FinalTest {

    public static void main(String args[]) throws InterruptedException {
        FinalClass f = new FinalClass();
        for(int i = 0;i < 10; i++) {
            Integer[] obj = new Integer[1];
            f.test(obj);
            Thread.sleep(100);
            obj[0] = 10;
        }
    }
    
}


class FinalClass {
    
    private final int I = 0;
    
    private final int j;
    
    public FinalClass() {
        j = 1;
    }
    
    public void test(Integer[] obj) {
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
//                    obj = new Object();
                    Thread.sleep(0);
                    System.out.println(obj[0]);
                } catch (InterruptedException ex) {
                    Logger.getLogger(FinalClass.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
    }
    
    
}