import java.net.*;
import java.io.*;
import java.lang.String;
public class ClientFile{
	public static void main(String [] args)throws IOException{
	int i;
	//String s="ServerFile.txt";
	InputStream is=null;
	BufferedOutputStream bos=null;
	Socket sock=null;
	try{
		if(args.length==0)
		sock=new Socket(InetAddress.getLocalHost(),4000);
		else
		sock=new Socket(InetAddress.getByName(args[0]),4000);
	System.out.println("Connecting...");
	String s1="clientFile.txt";
	File myfile = new File(s1); 
	byte [] arrayy=new byte[1500];
	is=sock.getInputStream(); 
	bos=new BufferedOutputStream(new FileOutputStream(myfile));
	i=is.read(arrayy,0,arrayy.length);
	bos.write(arrayy,0,i); 
	bos.flush();
	}
	catch(IOException ioe){
	System.out.println(ioe);
	}
	}
	}

