package compulsory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Dictionary {

    public Dictionary(ArrayList<String> dictionary){
        try {
            File file=new File("C:\\Users\\manub\\IdeaProjects\\cirona\\src\\main\\java\\words.txt");    //creates a new file instance
            FileReader fr=new FileReader(file);   //reads the file
            BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream
            String line;
            while((line=br.readLine())!=null) {
                dictionary.add(line);      //appends line to string buffer
            }
            fr.close();    //closes the stream and release the resources
        }
        catch(IOException e) {
            e.printStackTrace();
        }
      //  System.out.println(dictionary);
    }

    public boolean isWord(String str) {
        return true;
    }
}

