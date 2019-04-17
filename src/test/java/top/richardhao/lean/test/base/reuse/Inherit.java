/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package top.richardhao.lean.test.base.reuse;

/**
 *
 * @author RichardHaoFang
 */
public class Inherit {
    
    public static void main(String args[]) {
        C c = new C();
        c.show();
    }
}

class C extends B{
    public void show() {
        super.show();
        System.out.println("I am C.");
    }
}

class B extends A{
    public void show(){
        System.out.println("I am B");
    }
}

class A{

    public void show(){
        System.out.println("I am A.");
    }
}

