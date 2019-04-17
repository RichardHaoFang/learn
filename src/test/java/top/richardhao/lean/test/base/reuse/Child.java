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
public class Child extends Root{

    public Component2 component1 = new Component2();
    public Child() {
        System.out.println("Child");
    }

    @Override
    public void show() {
        System.out.println("child");
    }
    
    
}
