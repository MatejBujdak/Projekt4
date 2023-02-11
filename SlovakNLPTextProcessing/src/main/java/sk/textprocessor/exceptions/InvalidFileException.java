package sk.textprocessor.exceptions;


/*Táto trieda je vlastná výnimka pre chybu pri čitani zo zadaneho suboru t*/
public class InvalidFileException extends Exception{
    public InvalidFileException(String message) {
        super(message);
    }
}
