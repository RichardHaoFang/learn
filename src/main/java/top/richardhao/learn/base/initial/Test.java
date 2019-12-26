/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package top.richardhao.learn.base.initial;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author RichardHaoFang
 */
public class Test {

    public static void main(String[] args) {
        Map<A,String> test = new HashMap();
        A a1 = new A();
        A a2 = new A();
        A a3 = new A();
        test.put(a1, "test1");
        test.put(a2, "test2");
        test.put(a3, "test3");
        System.out.println(test);
        System.out.println(test.get(a3));
    }
}


class A {

    @Override
    public boolean equals(Object obj) {
        return true;
    }
    
}