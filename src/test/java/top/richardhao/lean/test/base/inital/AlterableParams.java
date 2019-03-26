/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top.richardhao.lean.test.base.inital;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *可变参数列表测试
 * @author RichardHaoFang
 */
public class AlterableParams {
    
    public AlterableParams() {
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
//         show();
     }
     
    /**
     *
     * @param args
     * @param s
     */
    public void show(int... args) {
         System.out.println(args[0]+"++++"+args[1]);
     }
    
    public void show(String... args){
        System.out.println("2"+args[0]+"++++"+args[1]);
    }
}
