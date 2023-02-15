package com.company;

import java.io.*;

public class FileManager {

    private String pathToFile;
    private FileWriter fw;
    private FileReader fr;
    private boolean append;

    public FileManager(String pathToFile, boolean append) throws IOException {
        this.pathToFile = pathToFile;
        fw = new FileWriter(pathToFile, append);
        fr = new FileReader(pathToFile);
        this.append = append;
    }


    public void WriteMovie(String movie, String director, int year) throws IOException{
        open();
        fw.write("\n");
        String line = movie+"|"+director+"|"+year;

        for (int i = 0; i < line.length(); i++) {
            fw.write((int) line.charAt(i));
        }


        close();
    }

    public void ReadAllMovies() throws IOException {
        open();
        int c;
        System.out.println("******* MOVIE COLLECTION *******");
        while((c = fr.read())!=-1){

            if((char) c == '|'){
                System.out.print(" ");
            }else {
                System.out.print((char) c);
            }


        }

        close();

    }

    public void getTitles() throws IOException{
        open();
        int c;

        System.out.println("**** Movie list ****");

        while ((c = fr.read())!=-1){

            if ((char) c == '\n'){
                c=fr.read();
                while ((char) c != '|'  && c!=-1 ){
                    System.out.print((char) c);
                    c=fr.read();
                }
                System.out.print("\n");

            }


        }

        close();
    }

    public void getAuthors() throws IOException{
        open();
        int c;
        System.out.println("**** Author list **** ");

        while ((c = fr.read())!=-1){

            if ((char) c == '\n' && c!=-1){

                int counter = 0;
                while (counter!=1){

                    if ((char) c == '|'){
                        counter+=1;
                    }
                    c = fr.read();
                }

                while ((char) c != '|'  && c!=-1 ){
                    System.out.print((char) c);
                    c=fr.read();
                }

                System.out.print("\n");



            }
        }


        close();

    }



    public void close() throws IOException{
        fr.close();
        fw.close();
    }

    public void open() throws IOException{
        fr = new FileReader(pathToFile);
        fw = new FileWriter(pathToFile, append);
    }



}
