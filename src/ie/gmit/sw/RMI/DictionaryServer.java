package ie.gmit.sw.RMI;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class DictionaryServer 
{
	public static void main(String[] args) throws Exception
	{
		DictionaryService ds = new DictionaryServiceIMPL();
		
		LocateRegistry.createRegistry(1099);
		Naming.rebind("getDictionary", ds);
		
		System.out.println("Server is ready");
	}
	
	
}
