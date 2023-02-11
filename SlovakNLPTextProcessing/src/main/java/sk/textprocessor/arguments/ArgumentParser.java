package sk.textprocessor.arguments;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import sk.textprocessor.exceptions.InvalidParametersException;


/*Táto triede sa použiva pre nastavenie argumentov ako -token atd..*/
public class ArgumentParser {

    /*-token a ostatne metody na spracovanie textu ktore tu budu by mohli mať iba boolean hodnotu ciže bud boly zadane True alebo neboly False*/

    @Parameter(names = "-newFile", description = "Tokenize text")
    private String newFile = "";
    @Parameter(names = "-token", description = "Tokenize text")
    private boolean tokenize = false;

    @Parameter(names = "-extsents", description = "Extract sentences")
    private boolean extractSentences = false;

    /*Pomocou parametra input možme vložit na spracovanie nejaký textovy dokument tým že zadame jeho nazov.*/
    @Parameter(names = "-input", description = "Input file")
    private String inputFile = "";

   /*Konštuktor pre triedu vytvoríme v nom Jcommander object ktory spracuje parametre pokial uživatel zada zle parametre
    vyskoči vynimka InvalidParametersException */
    public ArgumentParser(String[] args) throws InvalidParametersException {
        JCommander jCommander = JCommander.newBuilder()
                .addObject(this)
                .build();
        try {
            jCommander.parse(args);
        } catch (ParameterException e) {
            throw new InvalidParametersException("Chyba: Nespravne zadané parametry");
        }
    }



    /*Funkcia pre zistenie či dany parameter bol zadany  */
    public String newFileName() { return newFile;}
    public boolean isTokenize() {
        return tokenize;
    }
    public boolean isExtractSentences() {
        return extractSentences;
    }

    public String getInputFile() {
        return inputFile;
    }
}
