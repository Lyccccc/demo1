package net.coderchen.demo1.demo;

/**
 * Created by Liuyuchen on 2018/06/06.
 * 测试异常堆栈打印顺序
 */
public class ExceptionSequenceTest {
    public static void main(String[] args) {
        try {
            fun2();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void fun1(){
        try{
            String a = null;
            a.split(",");
        }catch(RuntimeException e){
            throw e;
        }
    }

    public static void fun2() throws Exception {
        try{
            fun1();
        }catch(RuntimeException e){
            throw new Exception("", e);
        }
    }
}
