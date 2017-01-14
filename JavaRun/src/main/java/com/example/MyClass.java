package com.example;

import java.io.File;

public class MyClass {

    public static void main(String[] args){

        File file=new File("E:/1Temp");
        deletFile(file);
    }

    private static void deletFile(File file) {
        if(file.isFile()||file.listFiles().length==0){
            file.delete();
        }else{
            File[] files = file.listFiles();
            for(File delFile:files){
                deletFile(delFile);
            }
        }
        file.delete();
    }
}
