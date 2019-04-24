/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package top.richardhao.lean.test.base.polymorphic;

/**
 *
 * @author RichardHaoFang
 */
public class Polymorphic {
    
    public static void main(String args[]) {
        B b = new B(1);
    }
}

class A{

    public A() {
        System.out.println("A");
    }
    
    public A(int s) {
        System.out.println("111");
    }

}

class B extends A{

    public B(int a) {
    }

    
}