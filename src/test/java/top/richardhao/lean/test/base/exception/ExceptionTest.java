package top.richardhao.lean.test.base.exception;

public class ExceptionTest {
    public static void main(String[] args) {
        System.out.println(test());
    }

    public static String test() {
        try{
            return "123";
        }catch (Exception e) {
        } finally {
            System.out.println("finally");
            return "234";
        }
    }
}
