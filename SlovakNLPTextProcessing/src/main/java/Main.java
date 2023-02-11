import FileCreator.NewFile;
import sk.textprocessor.arguments.ArgumentParser;
import sk.textprocessor.exceptions.InvalidFileException;
import sk.textprocessor.exceptions.InvalidParametersException;
import sk.textprocessor.input.InputReader;
import sk.textprocessor.processing.TextProcesses;

/*Hlavna trieda kde sa bude všetko špuštat*/
public class Main {

    public static void main(String[] args) {
        TextProcesses textprocessor = new TextProcesses();
        InputReader input = new InputReader();

        try {
            ArgumentParser parser = new ArgumentParser(args);
            String inputText = input.readFile(parser.getInputFile());
            String fileName = parser.newFileName();

            if(!fileName.equals("")){
                NewFile NewFile = new NewFile();
                NewFile.NewFileCreate(fileName);
                NewFile.fileCreated = true;
            }

            if (parser.isTokenize()) {
                textprocessor.tokenize(inputText);
            }
            if (parser.isExtractSentences()) {
                textprocessor.extractSentences(inputText);
            }
        } catch (InvalidParametersException | InvalidFileException e) {
            System.err.println(e.getMessage());
        }




    }
}
