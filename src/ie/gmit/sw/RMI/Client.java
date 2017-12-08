package ie.gmit.sw.RMI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client 
{
	DictionaryService ms; 
	
	public Client() throws Exception
	{
		ms = (DictionaryService) Naming.lookup("rmi://127.0.0.1:1099/getDictionary");
	}
	
	public String getDefinition(String s) throws RemoteException
	{
		return ms.lookup(s.toUpperCase());
	}
	
}
