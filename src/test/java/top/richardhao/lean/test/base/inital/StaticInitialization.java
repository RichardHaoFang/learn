/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top.richardhao.lean.test.base.inital;

/**
 *静态初始化
 * @author RichardHaoFang
 */
public class StaticInitialization {

    public static void main(String[] args) {
        A a = new A();
        System.out.println("Main invokered");
    }
    
}

class A {
    
    static {
        System.out.println("block invokered");
        a = new A();
    }
    
    public static A a = new A();
    
    public static int x = getX();

    public int y = getY();
    
    public A() {
        System.out.println("new Instance of A created");
    }
    
    public static int getX(){
        System.out.println("static value of x initial");
        return 1;
    }
    
    public int getY(){
        System.out.println("Instance value of y initial");
        return 1;
    }
    
}
