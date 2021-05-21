package BC;

import java.util.*;
import java.io.*;

import java.nio.file.*;

public class dem
{
	public static void main(String ggae[]) throws Exception,IOException
	{
		// data structures
		ArrayList<pair> config_vals=new ArrayList<pair>(2245);
		String temp="";
	
		
		//Finding ini address
		String SystemDrive=System.getenv("SystemDrive");
		String userName=(System.getProperty("user.name"));
		Path path=FileSystems.getDefault().getPath(SystemDrive+"\\users\\"+userName+"\\Documents"+"\\My Games"+"\\Borderlands 2"+"\\WillowGame"+"\\Config"+"\\WillowEngine.ini");
		Path path2=FileSystems.getDefault().getPath("C:\\Users\\V\\Desktop\\MyEngine.ini");
		
		//input
		InputStream IS= new FileInputStream("C:\\Users\\V\\BC\\WillowEngine.ini");
		Reader R=new InputStreamReader(IS);
		BufferedReader BFR=new BufferedReader(R);
		
		
	
		
		//output
		FileWriter FW=new FileWriter("C:\\Users\\V\\Desktop\\MyEngine.ini");
		
		//reading the ini 
		while((temp=BFR.readLine())!=null)
		{
			
			if(temp.indexOf("=")==-1)
			config_vals.add(new pair(temp));
			else
			{
				int separator=temp.indexOf("=");			
				config_vals.add(new pair(temp.substring(0,separator),temp.substring(separator+1,temp.length())));

			}
		}
		BFR.close();
		
		//chaning the file
		int changefrom=1099;  //till 1271
		for(int i=changefrom;i<1271;i++)
		{
			if(config_vals.get(i).key.equals("ResX"))
				config_vals.get(i).value=String.valueOf(1366);
			
		}
		
		
		//writing  the new changed file
		for(pair P:config_vals)
		{ 
			try
			{
			if(P.value=="")
			{
				//if(!K.equals("[URL]"))
				//FW.write("\r\n");
				
				FW.write(P.key+"\r\n");	
			}
			else
				
			FW.write(P.key+"="+P.value+"\r\n");			
			}
			catch(IOException e){
				System.out.println(e);
			}
		}
		FW.close();
		
		byte[] og=Files.readAllBytes(path);
		byte[] New=Files.readAllBytes(path2);
		if(Arrays.compare(New,og)==0)
			System.out.println("true");
		else
			System.out.println("false");
		
	}
}