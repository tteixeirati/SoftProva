package br.com.tiago;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JavaApplication1 {
    public static void main(String[] args) throws IOException {
		String path = new File(".").getCanonicalPath();

        JSONParser parser = new JSONParser();

        try {     
        	JSONArray a = (JSONArray) parser.parse(new FileReader(path+"\\tarefas.json"));
            for (Object o : a)
            {
                JSONObject jsonObject =  (JSONObject) o;

    		    String titulo = (String) jsonObject.get("titulo");
    		    System.out.println(titulo);

    		    String descricao = (String) jsonObject.get("descricao");
    		    System.out.println(descricao);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
