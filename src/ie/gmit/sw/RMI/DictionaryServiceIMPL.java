package ie.gmit.sw.RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import ie.gmit.sw.Dictionary;

public class DictionaryServiceIMPL extends UnicastRemoteObject implements DictionaryService 
{
	protected DictionaryServiceIMPL() throws RemoteException {
		super();
	}

	private Dictionary dic=new Dictionary("dictonary.txt");
	private static final long serialVersionUID = 1L;
	
	@Override
	public String lookup(String s) throws RemoteException 
	{
		return dic.getDefinition(s);
	}

}
