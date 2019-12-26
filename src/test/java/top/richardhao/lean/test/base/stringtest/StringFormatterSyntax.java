/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package top.richardhao.lean.test.base.stringtest;

import java.util.Formatter;

/**
 *
 * @author RichardHaoFang
 */
public class StringFormatterSyntax {
    public static void main(String[] args) {
        Receipt receipt = new Receipt();
        receipt.printTitle();
        receipt.print("Jack's Magic Beans", 4, 12345678904.25);
        receipt.print("Princess Peas", 3234234, 5.1);
        receipt.print("Three Bears Porridge", 1, 14.29);
        receipt.printTotal();
    }
}

class Receipt {
    private double total = 0;
    private Formatter f = new Formatter(System.out);
    public void printTitle() {
        f.format("%-15s %5s %10s\n", "Item", "Qty" ,"Price");
        f.format("%-15s %5s %10s\n", "----", "---" ,"-----");
        f.format("1234567890123456789012345678901234567890\n");
    }
    
    public void print(String name, int qty, double price) {
        f.format("%-15.15s %5s %10.2f\n", name, qty, price);
        total += price;
    }
    
    public void printTotal() {
        f.format("%-15s %5s %10.2f\n", "Tax", "", total*0.06);
        f.format("%-15s %5s %10s\n", "", "", "-----");
        f.format("%-15s %5s %10.2f\n","Total", "", total+1.06);
    }
}