import java.net.*;
import java.io.*;
public class Serverecho{
	public static void main(String[]args)throws IOException{
	ServerSocket sock=null;
	BufferedReader fromClient=null;
	OutputStreamWriter toClient=null;
	Socket client=null;
	try{
		sock=new ServerSocket(1024);
		System.out.println("Server Ready");
		client=sock.accept();
		System.out.println("Client connected");
		fromClient=new BufferedReader(new
InputStreamReader(client.getInputStream()));
	toClient=new OutputStreamWriter(client.getOutputStream());
	String line;
	while(true){
		line=fromClient.readLine();
		if((line==null)||(line.equals("bye")))
		break;
		System.out.println("client[" +line+ "]\n");
		toClient.write("server[" +line+ "]\n");
		toClient.flush();
	}
	fromClient.close();
	toClient.close();
	client.close();
	System.out.println("Client disconnected");
	}
	catch(IOException ioe){
		System.out.println(ioe);
	}
	}
}

