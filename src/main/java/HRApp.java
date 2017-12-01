package HRSystem_rul.src.main.java;

import domain.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
//import java.util.HashSet;
import java.util.Properties;

public class HRApp {
    public static void main(String[] args){
//        inlezen van xml.properties
//        private Path pathToPropTXT = path;
//        private Path pathToPropXML = path;
//
//        try(FileInputStream fileInputStream = new FileInputStream(PROPERTY_FILE_AS_TEXT);
//            FileInputStream fileInputStream_XML = new FileInputStream(PROPERTY_FILE_AS_XML);
//            ){
//            Properties propertiesTXT = new Properties();
//            propertiesTXT.load(fileInputStream);
//            propertiesTXT.list(System.out);
//
//            Properties propertiesXML = new Properties();
//            propertiesXML.load(fileInputStream_XML);
//            propertiesXML.list(System.out);
//        }catch(IOException e){
//                System.out.println(e);
//        }

    }

    public static HashMap<String, Integer> countWorkerTypes(Worker[] workers){
        HashMap<String, Integer> workerCount = new HashMap<>();
        int countEmp =0;
        workerCount.put("employee", countEmp);
        int countMan = 0;
        workerCount.put("manager", countMan);
        int countDir = 0;
        workerCount.put("director", countDir);
        for(Worker w: workers){
            if(w instanceof Employee){
                workerCount.put("employee", countEmp++);        //++countEmp??
            }else if(w instanceof Manager){
                workerCount.put("manager", countMan++);
            }else if(w instanceof Director){
                workerCount.put("director", countDir++);
            }
        }
        return workerCount;
    }       //generic method?
}
