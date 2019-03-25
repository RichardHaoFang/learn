/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top.richardhao.lean.test.base.inital;

import java.util.Arrays;
import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *数组初始化测试
 * @author RichardHaoFang
 */
public class ArrayTest {
    
    public ArrayTest() {
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
     public void lengthTest() {
         int[] a = {1,2,34,4};
//         a.length = 10;数组length属性不能修改
        Random random = new Random(47);
        a = new int[random.nextInt(20)];
         System.out.println(Arrays.toString(a));
     }
     
     @Test
     public void integerArrayTest() {
         Random random = new Random(45);
         //数组元素会被编译器初始化为null
         Integer[] a = new  Integer[random.nextInt(100)];
         System.out.println(Arrays.toString(a));
     }
     
     @Test
     public void integerTest() {
         Integer a;
//         System.out.println(a);
     }
}
