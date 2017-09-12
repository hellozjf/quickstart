package com.hellozjf.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * This class is used for copy files in src/main/java to code/jpo, 
 * while change the first few lines to make jpo valid.
 * 
 * @author zjf
 *
 */
public class CreateJPO {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        File dir = new File("src/main/java");
//        System.out.println(file.getAbsolutePath());
        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isFile()) {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                PrintWriter writer = new PrintWriter(new FileWriter("code/jpo/" + file.getName()));
                String str = null;
                while ((str = reader.readLine()) != null) {
                    if (str.contains("${CLASSNAME}") && str.contains("${CLASS:emxDomainObject}")) {
                        str = str.replaceAll("//", "");
                        writer.println(str);
                        str = reader.readLine();
                        writer.println("//" + str);
                    } else if (str.contains("${CLASSNAME}")) {
                        str = str.replaceAll("//", "");
                        writer.println(str);
                        str = reader.readLine();
                        str = str.replaceAll("//", "");
                        writer.println(str);
                        str = reader.readLine();
                        str = str.replaceAll("//", "");
                        writer.println(str);
                    } else {
                        writer.println(str);
                    }
                }
                writer.close();
                reader.close();
            }
        }
    }

}
