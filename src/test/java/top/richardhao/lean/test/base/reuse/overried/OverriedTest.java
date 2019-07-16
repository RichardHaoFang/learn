/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top.richardhao.lean.test.base.reuse.overried;

/**
 *
 * @author RichardHaoFang
 */
public class OverriedTest {

    public static void main(String args[]) {
        B b = new B();
//        b.show();
//        ((A) b).show();
        System.out.println(b.x);
        System.out.println(((A)b).x);
    }

}

class A {

    public int x = 1;

    private void test() {
    }

    public void show() {
        System.out.println("I am A");
    }
}

class B extends A {

    public int x = 10;

    private void test(int x) {
    }

    @Override
    public void show() {
        super.show();
        System.out.println("I am B");
    }
}
