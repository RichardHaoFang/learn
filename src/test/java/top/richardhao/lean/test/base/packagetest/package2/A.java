/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package top.richardhao.lean.test.base.packagetest.package2;

/**
 *
 * @author RichardHaoFang
 */
public class A {
     public int getX(){
        return 1;
    }
}


class B extends A{

    public static int M = 1;
    
    public int S = 10;
    
    public int getY() {
        return 2;
    }
    
    public static int getM(){
        return 1;
    }
    
    public static void main(String[] args) {
        System.out.println("|||||||||||||||||||||||test成功");
    }
    
    public int getX(){
        return 3;
    }
}