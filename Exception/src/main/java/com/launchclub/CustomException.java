package com.launchclub.exception;

public class CustomException extends RuntimeException {
  
    public CustomException(String message) {
      super(message);
  }

public static class ConenctionNotFoundException extends CustomException {

    public ConenctionNotFoundException(String message) {
        super(message);
    }  
}

public static class IdAlreadyExistsException extends CustomException {

    public IdAlreadyExistsException(String message) {
        super(message);
    } 
}

public static class DataNotFoundException extends CustomException {
    
    public DataNotFoundException(String message) {
        super(message); 
     }
}

public static class IdNotFoundException extends CustomException {

    public IdNotFoundException(String message) {
        super(message);
    } 
}

public static class InvalidInputException extends CustomException {

    public InvalidInputException(String message) {
        super(message);
    }
}
}