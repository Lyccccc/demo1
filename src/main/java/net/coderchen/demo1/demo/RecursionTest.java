package net.coderchen.demo1.demo;

/**
 * @Author Liuyuchen
 * @Date 2018/11/21
 * @Description
 */
public class RecursionTest {

    public static void main(String[] args) {
//        System.out.println(commonRecursion(100000));
        System.out.println(tailRecursion(1000000));
    }

    public static int commonRecursion(int n){
        if(n < 0){
            return 0;
        }
        System.out.println(n);
        return  n + commonRecursion(n-1);
    }

    public static int tailRecursion(int n){
        if(n < 0){
            return 0;
        }
        System.out.println(n);
        return tailRecursion(n-1);
    }
}
