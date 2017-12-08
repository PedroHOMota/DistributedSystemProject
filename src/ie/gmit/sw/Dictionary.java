package ie.gmit.sw;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Dictionary 
{
	Map<String,String> dic= new HashMap<String, String>();
	
	public Dictionary(String dicPath)  
	{
		File file=new File(dicPath);
		BufferedReader stream;
		try{
			stream = new BufferedReader(new FileReader(file));
			String line="";
			String auxDefinition="";
			String auxName="A";
			System.out.println("Loading dic...");
			while((line=stream.readLine())!=null)
			{
				if(line.startsWith("!!"))
				{
					dic.put(auxName, auxDefinition);
					line=stream.readLine();
					auxName=line;
					auxDefinition="";
				}
				else
					auxDefinition+=line;
			}
			
			System.out.println("Loading Finished");
		}catch(IOException e)
		{
			e.getStackTrace();
		}
		
	}
	public String getDefinition(String s)
	{
		String def=dic.get(s);
		return def;
	}
}