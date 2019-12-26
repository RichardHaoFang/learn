/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top.richardhao.lean.test.base.inital;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 非静态代码块初始化
 * @author haof
 */
public class InstaceInitialization {
    
    public static void main(String[] args) {
//        System.out.println("Invoker main");
//        B a = new B();
//        System.out.println("main invokered");
        C c = null;
        try {
            c = C.class.newInstance();
            System.out.println("123"+c);
        } catch (Exception ex) {
            System.out.println("异常");
        }
        System.out.println(c);
    }
}

class B {

    {
        System.out.println("InstanceInitialization block invokered");
        System.out.println(B.x);
        B b = new B();
    }
    
    public static int x = getX();
    
    public B() {
        System.out.println("new Instance of B created");
    }
    
    public static int getX() {
        System.out.println("static Data initialization");
        return 10;
    }
}

class C{

    public C(int c) {
    }
    
}