package additionally;



import java.io.*;

public class Task01{

    public static void main(String[] args) throws Exception{
        Upper upper = new Upper();

        String file = Reader.reader("text.txt");
        String out = upper.upeerString(file);

        System.out.println(out);



    }
}

class Reader {
    public static String reader(String fileName) throws Exception {

        FileReader fileReader = new FileReader(fileName);
        String string = new String();


        // perevod faila v stroky
        if (fileReader.ready()) {
            char[] chars = new char[1000];
            fileReader.read(chars);
            string = new String(chars);
        }

        // razdelenie slov zapatimi
        string=string.trim();
        string=string.concat(",");
        string=string.replace('\u0000', ',');
        string=string.replace(' ', ',');
        string=string.replace('\r',',');
        string=string.replace('\n',',');
        string=string.replaceAll(",,", ",");

        return string;

    }
}

class Upper{
    String upeerString(String string){
        String chengString=new String();
        String upperString = new String();
        int lengthWord;
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
    }
}