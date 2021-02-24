/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ccs.dhis_data_importer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Agnaldo Samuel
 */
public class teste {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        Path path = Paths.get("C:\\py-dhis-data-entry\\config\\dhis_config.yaml");
        Charset charset = StandardCharsets.UTF_8;
        try {
            String content = new String(Files.readAllBytes(path), charset);
            content = content.replaceAll("dhis2_username:", "dhis2_username: Agnaldo.Samuel");

            Files.write(path, content.getBytes(charset));
            
        } catch (IOException e) {
            System.out.println("Hello World!");
        } catch (Exception e) {
            System.out.println("Hello World!");
        }

    }
}
