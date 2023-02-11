package sk.textprocessor.exceptions;

/*Táto trieda je vlastná výnimka pre chybu v parametroch*/
public class InvalidParametersException extends Exception{

    public InvalidParametersException(String message) {
        super(message);
    }
}

