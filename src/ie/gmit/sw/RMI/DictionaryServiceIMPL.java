package ie.gmit.sw.RMI;

import java.rmi.RemoteException;

import ie.gmit.sw.Dictonary;

public class DictionaryServiceIMPL implements DictionaryService
{
	private Dictonary dic=new Dictonary();
	private static final long serialVersionUID = 1L;
	
	@Override
	public String lookup(String s) throws RemoteException 
	{
		return dic.getDefinition(s);
	}

}
