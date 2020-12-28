package be.pxl.ja.streamingservice.exception;

public class DuplicateEmailException extends Exception{

    public DuplicateEmailException(String msg) {
        super(msg);
    }

}

