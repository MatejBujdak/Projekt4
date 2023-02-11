package FileCreator;

import java.io.*;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;

public class NewFile {

    public boolean fileCreated = true;
    String filename, path;

    public static String fullPath;

//  function that creates a new file
    public void NewFileCreate(String fileName){
    path = System.getProperty("user.home") + "/OneDrive/Počítač";
    filename = fileName + ".txt";
    fullPath = Paths.get(path, filename).toString();

    try{
        Files.createFile(Paths.get(fullPath));
    }catch(IOException e){
        System.out.println(e.getMessage());
    }
}

//   function that overwrites the selected file
   public void rewriteFile(String rewrite){

        if(fileCreated){
            try {
                FileWriter fw = new FileWriter(fullPath);
                fw.write(rewrite);
                fw.close();
            }
            catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
            }else{

            try {
                FileWriter fw = new FileWriter("JavaText.txt");
                fw.write(rewrite);
                fw.close();
            }
            catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
        }





}




