package org.sourceit.zakharov.additionally;

import java.util.Scanner;

public class Task03 {

    public static void main(String[] args) {


        Scanner scanner=new Scanner(System.in);
        Find something= new Find();

        System.out.println("Enter type ");

        something.search(scanner.next(), "data.txt");

    }
}


class Find{

    String file;

     void search(String type, String name){
        try {
            file = Reader.reader(name);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(type.equalsIgnoreCase("char")) findChar();
        else if(type.equalsIgnoreCase("string")) findString();
        else if(type.equalsIgnoreCase("int")) findInt();
        else if(type.equalsIgnoreCase("double"))  findDouble();
        else System.out.println("incorrect value");


    }


    void findChar(){
        int t;
        String[] mas = new String[file.length()/2];

        for(int i = 0,y=0; file.length()>0;i++){
            t = file.indexOf(',');
            if(t==1){
                mas[y]=file.substring(0, t);
                y++;
            }
            file = file.substring(t+1);

        }
        for(int i = 0; mas[i]!=null ;i++){
            System.out.println(mas[i]);
        }
    }


    void findString(){
        int t;
        String[] mas = new String[file.length()/2];

        for(int i = 0,y=0; file.length()>0;i++){
            t = file.indexOf(',');
            if(t>1){
                mas[y]=file.substring(0, t);
                y++;
            }
            file = file.substring(t+1);

        }
        for(int i = 0; mas[i]!=null ;i++){
            System.out.println(mas[i]);
        }
    }


    void findInt(){
        int[] mas = new int[file.length()/2];
        int t;
        for(int i = 0,y=0; file.length()>0;i++){
            t = file.indexOf(',');
            try {
                mas[y]=Integer.parseInt(file.substring(0, t));
                y++;
            }
            catch (Exception e){}

            file = file.substring(t+1);
        }
        for(int i = 0; mas[i]!=0 ;i++){
            System.out.println(mas[i]);
        }
    }



    void findDouble(){
        double[] mas = new double[file.length()/2];
        int t;
        for(int i = 0,y=0; file.length()>0;i++){
            t = file.indexOf(',');
            try {
                mas[y]=Double.parseDouble(file.substring(0, t));
                if ((mas[y]%1)==0)  y--;
                y++;
            }
            catch (Exception e){}

            file = file.substring(t+1);
        }
        for(int i = 0; mas[i]!=0 ;i++){
            System.out.println(mas[i]);
        }
    }

}

