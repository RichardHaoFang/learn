package top.richardhao.lean.test.base.stringtest;

import java.util.Scanner;

public class ScannerDelimiter {
    public static void main(String[] args){
        Scanner scanner = new Scanner("21, 42,   we78   , 99,  42");
        scanner.useDelimiter("\\s*,\\s*");
        while(scanner.hasNextInt()) {
            System.out.println(scanner.nextInt());
        }
    }
}
