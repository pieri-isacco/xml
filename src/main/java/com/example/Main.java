package com.example;

import java.io.File;
import java.sql.Date;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class Main {
    public static void main(String[] args) {
       

     Alunno a = new Alunno("Claudio", "Benvenuti", new Date(1979,9,22));
     Alunno b = new Alunno("Il Fresco", "Di Zona", new Date(2007,7,70));
     ArrayList<Alunno> alunni = new ArrayList<>();
     alunni.add(b);
     alunni.add(a);
     Classe c1= new Classe(5, "BIA", "3A", alunni);


       

 try {
     XmlMapper xmlMapper = new XmlMapper();
        String s1 = xmlMapper.writeValueAsString(c1);

        xmlMapper.writeValue(new File("test.xml"), c1);

        Classe c2 = xmlMapper.readValue(new File("test.xml"), Classe.class);
        System.out.println(c2.numero);
        System.out.println(c2.sezione);
        System.out.println(c2.aula);
 } catch (Exception e) {
    System.out.println(e.getLocalizedMessage());
    // TODO: handle exception
 }      

    }
}