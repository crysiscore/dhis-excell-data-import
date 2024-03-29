/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ccs.dhis_data_importer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Agnaldo Samuel
 */
public class Helper {

    public Helper() {
    }

    public static List<String> GetFormNames(String fileLocation) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileLocation), "UTF-8"));
        List<String> formNames = new ArrayList<>();

        String lines;
        while ((lines = br.readLine()) != null) {

            if (lines.contains("forms")) {

                Pattern p = Pattern.compile("[\"'](.+)[\"']");

                Matcher m = p.matcher(lines);
                if (m.find()) {
                    List<String> temp = Arrays.asList(m.group().split(","));
                    for (String form_name : temp) {
                        formNames.add(form_name.substring(1, form_name.length() - 1));
                        ///System.out.println(form_name.substring(1, form_name.length() -1 ));
                    }
                    break;
                } else {
                    System.out.println("Problema com os periodos no ficheiro de configuracao");
                }

            }

        }
        return formNames;
    }

    public static List<String> GetPeriods(String fileLocation) throws IOException {
        //File myObj = new File(fileLocation);   
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileLocation), "UTF-8"));
        // BufferedReader br = new BufferedReader(new FileReader(myObj)); 
        List<String> periodNames = new ArrayList<>();
        String lines;
        while ((lines = br.readLine()) != null) {

            if (lines.contains("periodos")) {

                Pattern p = Pattern.compile("[\"'](.+)[\"']");

                Matcher m = p.matcher(lines);
                if (m.find()) {
                    List<String> temp = Arrays.asList(m.group().split(","));
                    for (String period_name : temp) {

                        periodNames.add(period_name.substring(1, period_name.length() - 1));
                        //  System.out.println(period_name.substring(1, period_name.length() -1 ));
                    }
                    break;
                } else {
                    System.out.println("Problema com os periodos no ficheiro de configuracao");
                }

            }

        }
        return periodNames;
    }

    public static boolean CheckFileExists(String fileLocation) {
        boolean exist = true;

        File myObj = new File(fileLocation);
        if (myObj.exists()) {
            return (true);
        } else {
            exist = false;

        }
        return exist;
    }

   
}
