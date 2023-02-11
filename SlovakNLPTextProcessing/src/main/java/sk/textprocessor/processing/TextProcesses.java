package sk.textprocessor.processing;

import FileCreator.NewFile;

import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.ArrayList;

/*V tejto triede budu funkcie na spracovanie textu ako tokenizacie atd.. nižie uvedana funkcia je samozrejme len provizorna */
public class TextProcesses {

    NewFile NewFile = new NewFile();
    public void tokenize(String text){

        StringTokenizer str= new StringTokenizer(text);
        ArrayList<String> result = new ArrayList<String>();
        String output = "";
        while (str.hasMoreTokens())
        {
            result.add(str.nextToken(" "));
        }
        output = result.toString();
        System.out.println(output);
        NewFile.rewriteFile(output);
    }

    public static void extractSentences(String text) {
        ArrayList<String> sentenses = new ArrayList<String>();
        sentenses.add("/**** ZOZNAM VIET ****/");

        Abbreviation skr = new Abbreviation();
        boolean dictionary = false;

        int sentense_last_char = 0;
        int word_last_char = 0;
        String word = "";
        String input = text;
        String next_line = "";

        input = next_line + " " + input;

        sentense_last_char = 0;
        word_last_char = 0;

        for (int i = 1; i < input.length() - 3; i++) {
            String ch = input.substring(i, i + 3);

//            vytvaranie slov
            if (input.charAt(i + 2) == ' ') {
                word = input.substring(word_last_char, i + 2).trim().toLowerCase();
                word_last_char = i + 3;
                dictionary = skr.isAbbreviation(word);
            }

            if ((ch.matches("([!?.])(\\s)[A-Z]")) && !dictionary && (input.substring(i-1,i).matches("[a-z]") )) {
                sentenses.add(input.substring(sentense_last_char, i + 1));
                sentense_last_char = i + 1;
            }
        }

        next_line = input.substring(sentense_last_char, input.length()).trim();
        sentenses.add(next_line);
        sentenses.add("/*** KONIEC ZOZNAMU VIET ***/");

        for (String sentence : sentenses) {
            System.out.println(sentence);
        }
    }

}

