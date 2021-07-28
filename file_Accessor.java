package BC;

import java.util.*;
import java.io.*;

import java.nio.file.*;

public class file_Accessor
{
	private ArrayList<pair> read_file;
	
	//Finding ini address
	private String SystemDrive=System.getenv("SystemDrive");;
	private String userName=System.getProperty("user.name");;
	private Path path=FileSystems.getDefault().getPath(SystemDrive+"\\users\\"+userName+"\\Documents"+"\\My Games"+"\\Borderlands 2"+"\\WillowGame"+"\\Config"+"\\WillowEngine.ini");;
	private Path path2=FileSystems.getDefault().getPath("C:\\Users\\V\\Desktop\\MyEngine.ini");;
	
	//input
	private InputStream IS;
	private Reader R;
	private BufferedReader BFR;
	private String temp="";
	
	//output	
	private FileWriter FW;
	
	//constructor
	file_Accessor(){
	read_file=new ArrayList<pair>(2245);
	}
	
	void readFile(){ 
		if(!Files.isReadable(path))
			System.out.println("File is not Readable");
		if(!Files.isWritable(path2))
			System.out.println("Write Access to File is not available");
		
		try{
		IS= new FileInputStream(path.toString());
	}
	catch(FileNotFoundException fnfound)
	{
		System.out.println(fnfound);
	}
	R=new InputStreamReader(IS);
	BFR=new BufferedReader(R);
		//reading the ini 
		try{
		while((temp=BFR.readLine())!=null)
		{
			if(temp.indexOf("=")==-1)
			read_file.add(new pair(temp));
			else
			{
				int separator=temp.indexOf("=");			
				read_file.add(new pair(temp.substring(0,separator),temp.substring(separator+1,temp.length())));

			}
		}
		BFR.close();
		}
		catch(IOException ioe){
		System.out.println(ioe);
		}
		System.out.println(read_file.size());
	}
		
	void writeFile(){
		try{
	FW=new FileWriter(path.toString());
	}
	catch(IOException obj){
		System.out.println(obj);
	}
	
		//writing  the new changed file
		System.out.println(read_file.size());
		try{
		for(pair P:read_file){ 
				if(P.value==""){
					FW.write(P.key+"\r\n");	
				}
				else
					FW.write(P.key+"="+P.value+"\r\n");
			}
		
		FW.flush();
        FW.close();
		}
		catch(IOException e){
				System.out.println(e);
		}
	}
		void writeCheck(){
			try{
		byte[] og=Files.readAllBytes(path);
		byte[] New=Files.readAllBytes(path2);
		if(Arrays.compare(New,og)==0)
			System.out.println("true");
		else
			System.out.println("false");
		}
		catch(IOException obj){
		System.out.println(obj);
	}
		}
		
	
	void changeFile(ArrayList<pair> new_settings){
		System.out.println("Inside changefile");
		Iterator<pair> new_vals_iterator=new_settings.iterator();
		ListIterator<pair> orignal_file_iterator=read_file.listIterator();
		
		while(new_vals_iterator.hasNext())
		{
			pair temp=new_vals_iterator.next();
			int changefrom=1103;  //till 1271
				if(temp.key.equals(read_file.get(1523).key)){
					System.out.println("Found");
					read_file.get(1523).value=temp.value;
					continue;
				}
				for(int i=changefrom;i<1279;i++)
				{
					if(read_file.get(i).key.equals(temp.key)){
						
						read_file.get(i).value=temp.value;
						break;
						
					
					}
				}
				
					
			
			//find the key in the read_file and replace it with the value from new_settings
			//get a listiterator from the line after systemsettings
			
		}
			
	}
}