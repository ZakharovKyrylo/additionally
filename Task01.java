package additionally;

import Lection.LTask;

import java.io.*;

public class Task01 extends LTask{

    public static void main(String[] args) throws Exception{

        Reader reader = new Reader();
        String file = Reader.reader("text.txt");

        System.out.println(file);



    }
}

class Reader {
    public static String reader(String fileName) throws Exception {

        FileReader fileReader = new FileReader(fileName);
        String string = new String();
        String chengString=new String();
        String upperString = new String();

        int lengthWord;


        // perevod faila v stroky
        if (fileReader.ready()) {
            char[] chars = new char[1000];
            fileReader.read(chars);
            string = new String(chars);
        }

        // razdelenie slov zapatimi
        string=string.trim();
        string=string.concat(",");
        string=string.replace(' ', ',');
        string=string.replace('\r',',');
        string=string.replace('\n',',');
        string=string.replaceAll(",,", ",");


        while ( string.length() > 0){
            lengthWord = string.indexOf(',');
            if(lengthWord>2){
                upperString = string.substring(0, lengthWord);
                upperString = upperString.toUpperCase();
                chengString = chengString.concat(upperString + " ");

            }
            else
                chengString =chengString.concat(string.substring(0, lengthWord)+ " ");


            string = string.substring(lengthWord+1);
        }
        return chengString;
//        return string;
    }
}
