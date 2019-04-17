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
public class Root {

    Component1 component1 = new Component1();
    
    public Root() {
        System.out.println("Root");
    }
    
    public void show(){
        System.out.println("root");
    }
}