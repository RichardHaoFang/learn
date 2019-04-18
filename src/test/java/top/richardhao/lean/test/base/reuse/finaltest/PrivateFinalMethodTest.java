/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package top.richardhao.lean.test.base.reuse.finaltest;

/**
 *
 * @author RichardHaoFang
 */
public class PrivateFinalMethodTest {
    
    
}

//public final class C{
//}

class B extends A{
}

class A{
    
    public final void test(){
        System.out.println("I am A.");
    }
}
