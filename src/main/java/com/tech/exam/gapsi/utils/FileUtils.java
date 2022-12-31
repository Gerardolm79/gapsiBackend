
package com.tech.exam.gapsi.utils;

import com.tech.exam.gaspi.entity.Provider;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


public class FileUtils {
    
    public static boolean writeData(Provider provider){
        File file = new File("bd.json");
        FileWriter writer;
        try{
            writer = new FileWriter(file, true);
            var printW = new PrintWriter(writer);
            printW.println(provider.toString() + ", Active" );
            printW.close();
            writer.close();
            return true;
        }catch(IOException e){
            e.printStackTrace();
        }
        return false;
    }
    
    public static boolean overWriteData(String data){
        File file = new File("bd.json");
        FileWriter writer;
        try{
            writer = new FileWriter(file);
            var printW = new PrintWriter(writer);
            printW.print(data);
            printW.close();
            writer.close();
            return true;
        }catch(IOException e){
            e.printStackTrace();
        }
        return false;
    }
    
    
    public static List<Provider> readData() {
        File file = new File("bd.json");
        FileReader reader;
        Provider provider;
        List<Provider> providers=new ArrayList<>();
        try {
            reader = new FileReader(file);
            var bReader = new BufferedReader(reader);
            String data;
            String[] element;
            while( (data=bReader.readLine())!=null){
                
                provider = new Provider();
                System.out.println("data:" + data);
                element = data.split(",");
                provider.setId(Long.parseLong(element[0]));
                provider.setCommercialName(element[1]);
                provider.setBusinessName(element[2]);
                provider.setAddress(element[3]);
                providers.add(provider);
                
            }
            bReader.close();
            reader.close();
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return providers;
    }
    
    public static Provider saveProvider(Provider provider) {
        File file = new File("bd.json");
        FileReader reader;
        boolean result = true;
        try {
            reader = new FileReader(file);
            var bReader = new BufferedReader(reader);
            String data;
            String[] element;
            
            long count=0;
            while( (data=bReader.readLine())!=null){
                
                System.out.println("data:" + data);
                element = data.split(",");
                
                if(!data.trim().equals("") && provider.getCommercialName().equalsIgnoreCase(element[1].trim())){
                    System.out.println("Provider already exists ..."  + provider.toString());
                    provider.setId(Long.parseLong(element[0]));
                    result = false;
                    break;
                }
                count++;
            }
            bReader.close();
            reader.close();
            if(result){
                provider.setId(count);
                writeData(provider);                
                return provider;
            }else{
                return provider;
            }
        } catch (FileNotFoundException ex) {
            result = false;
            ex.printStackTrace();
        } catch (IOException ex) {
            result = false;
            ex.printStackTrace();
        }
        return provider;
    }
    
    
    public static boolean deleteData(long id, String name ) {
        File file = new File("bd.json");
        FileReader reader;
        
        boolean result = false;
        
        try {
            reader = new FileReader(file);
            var bReader = new BufferedReader(reader);
            String line;
            String data = "";
            String[] element;
            while( (line=bReader.readLine())!=null){
                
                System.out.println("data:" + data);
                element = line.split(",");
                System.out.println(id + "-" + element[0] + " / " + name + "-" + element[1]);
                if( id>=0 && Long.parseLong(element[0])==id ){
                    result = true;
                    line = line.replace("Active", "Deleted");
                    
                }else if( name!=null && name.equalsIgnoreCase(element[1].trim()) ){
                    result = true;
                    line = line.replace("Active", "Deleted");
                    
                }
                    data += line + "\n";
                
                
            }
            bReader.close();
            reader.close();
            if(result){
                overWriteData(data);
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return result;
    }
    
}
