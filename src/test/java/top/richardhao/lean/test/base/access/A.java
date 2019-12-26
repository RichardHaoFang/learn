/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package top.richardhao.lean.test.base.access;

/**
 *
 * @author RichardHaoFang
 */
public class A {

    public static void main(String[] args) {
        M m = new M();
        System.out.println(m.getN().x);
        m.getN().x = 10;
        System.out.println(m.getN().x);
    }
    
    private A() {
    }

}

class M{
    private N n = new N(1);

    public N getN() {
        return n;
    }
    
}

class N{

    public N(int x) {
        this.x = x;
    }

    int x = 0;
}