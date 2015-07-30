package additionally;

import java.io.*;
import additionally.Task01.*;
import java.util.Random;

public class Task02 {
    public static void main(String[] args) throws Exception {
        Sort sort = new Sort();
        Write write=new Write();


//        write.writeNum();

        System.out.println(sort.select());
    }
}


class Write{
    void writeNum() throws Exception{
        Random random = new Random();

        FileOutputStream stream = new FileOutputStream(new File("text1.txt"));

        DataOutputStream dataOutputStream = new DataOutputStream(stream);  //   1

        for (int i =0;i<10;i++)
            dataOutputStream.writeChars(String.valueOf(random.nextInt(10)));
    }
}



class Sort{
    String select()  throws Exception {
        String string = Reader.reader("text1.txt");
        int[] mas = new int[string.length()/2];

        int t;
        for(int i = 0; string.length()>0;i++){
            t = string.indexOf(',');
            mas[i]=Integer.parseInt(string.substring(0, t));
            string = string.substring(t+1);
        }

        for(int i=1;i<mas.length;i++){
            if(mas[i-1] > mas[i]){
                t=mas[i-1];
                mas[i-1]=mas[i];
                mas[i]=t;
                i=0;
            }
        }

        for(int i =0;i<mas.length;i++){
            string=string.concat(String.valueOf(mas[i]));
        }
        return string;
    }
}
