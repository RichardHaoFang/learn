/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top.richardhao.lean.test.base.packagetest;

import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;
import top.richardhao.lean.test.base.packagetest.package2.*;

/**
 *
 * @author RichardHaoFang
 */
public class StaticClass {

    public static void main(String[] args) {
        Fa f = new Fa();
        M m = new M();
        Object obj = f.getB();
        try {
            Field field = obj.getClass().getField("S");
            field.setAccessible(true);
            try {
                int s = field.getInt(obj);
                System.out.println("!!!!!!!!!!!!!!!!!!!"+s);
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(StaticClass.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(StaticClass.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (NoSuchFieldException ex) {
            Logger.getLogger(StaticClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(StaticClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(StaticClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

class N{
    public static M getM() {
        return new M();
    }
}

class M{
    
    public static int S = 1;
}