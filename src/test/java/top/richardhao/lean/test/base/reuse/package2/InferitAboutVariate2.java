/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package top.richardhao.lean.test.base.reuse.package2;

import top.richardhao.lean.test.base.reuse.Child;
import top.richardhao.lean.test.base.reuse.Root;


/**
 *
 * @author RichardHaoFang
 */
public class InferitAboutVariate2 {

    public static void main(String args[]) {
        System.out.println("0000000000000000");
         Child child = new Child();
//        System.out.println(child.component1);
//        System.out.println(((Root) child).component1);
        child.show();
        ((Root)child).show();
    }
}
