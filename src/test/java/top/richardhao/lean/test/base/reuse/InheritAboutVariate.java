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
public class InheritAboutVariate {

    public static void main(String[] args) {
        Child child = new Child();
        System.out.println(child.component1);
        System.out.println(((Root) child).component1);
    }
}

class Component1 {

    public Component1() {
        System.out.println("Component1");
    }
}

class Component2 {

    public Component2() {
        System.out.println("Component2");
    }
    
}

class Component3 {

    public Component3() {
        System.out.println("Component3");
    }

}