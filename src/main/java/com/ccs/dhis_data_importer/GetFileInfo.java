/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ccs.dhis_data_importer;

import java.io.BufferedReader;
import java.io.File;  // Import the File class
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetFileInfo { 
    
  public List<String> GetFormNames(String fileLocation) throws IOException {
      
      BufferedReader br = new BufferedReader(new FileReader(fileLocation)); 
      List<String> form_names = new ArrayList<>();
      
      String lines; 
      while ((lines = br.readLine()) != null){
          
          if(lines.contains("forms")){
              
            Pattern p = Pattern.compile("[\"'](.+)[\"']");
            System.out.print("Input: "+lines+" -> Matches: ");
            Matcher m = p.matcher(lines);
            if (m.find()) {
                System.out.print(m.group());
                while (m.find()){
                    System.out.print(", "+m.group());
                    System.out.println();
                   form_names.add(m.group().substring(1,  m.group().length() -1 ))  ;
                   
                }
            } else {
                System.out.println("NONE");
            }
        
      }
  
  } 
   return form_names;
  }
  
  
  public boolean CheckFileExists(String fileLocation){
    boolean exist = true;
    
    File myObj = new File(fileLocation);
    if (myObj.exists()) {
     return(true);
    } else {
        exist = false;

    }
        return exist;
  }
  
  public static void main(String[] args) throws Exception  {
      String filePath= "C:\\py-dhis-data-entry\\config\\extra_config.py";
      Helper help = new Helper();
      List<String> formNames = help.GetFormNames(filePath);
       for (String form_name : formNames) {
           System.out.println(form_name);
    }

           
           
      
  
  } 
        
  

}