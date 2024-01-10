package Exceptions;

public class TryCatchFinallyMyException {
    
    public static void main(String[] args) throws MyException {
        MyException ex = new MyException("My custom exception");
        //show how to throw an exception
        throw ex;
    }
}

class MyException extends Exception {
    public MyException(String message) {
        super(message);
    }
}