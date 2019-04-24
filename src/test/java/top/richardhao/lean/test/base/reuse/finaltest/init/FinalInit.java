/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package top.richardhao.lean.test.base.reuse.finaltest.init;

/**
 *
 * @author RichardHaoFang
 */
public class FinalInit {

    private int x = 10;
    private void f(){
        System.out.println("private f()");
    }
    
    public static void main(String args[]){
        FinalInit b = new FinalInitChild();
        b.x = 1;
        System.out.println(b.x);
//        System.out.println(((FinalInitChild)b).y);
        b.f();
    }
}

class FinalInitChild extends FinalInit{
    
    private int y = 10;
    
    public void f(){
        System.out.println("public f()");
    }
}


class A{
    
    static final String s;
    
    static{
//        未初始化不能引用
//        System.out.println(s);
        s = "1";
    }
}

class B {
    int getX(){
        show();
        return 1;
    }
    
    void show(){
        System.out.println("I am B.");
    }
    
    private void f(){
        System.out.println("private f()");
    }
}

class C extends B{
    @Override
    int getX(){
        super.show();
        return 11;
    }
    
    void show(){
        System.out.println("I am C.");
    }
    
    public void f(){
        System.out.println("public f()");
    }
}