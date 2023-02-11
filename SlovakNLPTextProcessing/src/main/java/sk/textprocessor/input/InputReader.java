package sk.textprocessor.input;

import sk.textprocessor.exceptions.InvalidFileException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*Trieda služi pre čitanie inputu uživatela */
public class InputReader {

    /*zatial je tu len funkcia na čitanie zo suboru*/
    public String readFile(String fileName) throws InvalidFileException {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            return sb.toString();
        } catch (IOException e) {
            throw new InvalidFileException("Chyba: Nespravne zadaný súbor");
        }
    }
}




