/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package top.richardhao.lean.test.base.packagetest.staticclass;

/**
 * 静态导入测试
 * @author RichardHaoFang
 */
public interface StaticImport {
//    private SS ss = new SS();
    public static int getx(){return 0;};
    public static int getx(int m){return 0;};
    public static int getx(int m,int n){return 0;};
}
