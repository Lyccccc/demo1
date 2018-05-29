package net.coderchen.demo1.demo;

import net.coderchen.demo1.exception.MyException;
import net.coderchen.demo1.exception.MyRuntimeException;

/**
 * Created by Liuyuchen on 2018/05/24.
 */
public class ExceptionTest {
    public static void main(String[] args) {
        try {
            tryException();
        } catch (MyException e) {
            e.printStackTrace();
        }
        ;
        tryMyRuntimeException();
    }

    public static void tryException() throws MyException {
        throw new MyException();
    }

    public static void tryMyRuntimeException(){
        throw new MyRuntimeException();
    }
}
