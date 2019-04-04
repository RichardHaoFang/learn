/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top.richardhao.lean.test.base.innerclass;

import javax.swing.JFrame;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author haof
 */
public class InnerClass {
    
    public InnerClass() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void hello() {
         Outer outer = new Outer();
     }
}

class Outer {
    
    public void test() {
        final JFrame frame = new JFrame();
        new Runnable() {
            
            @Override
            public void run() {
                System.out.println(frame.getBackground());
            }
        };
    }
}

interface Inner {
    
    public void test();
}
