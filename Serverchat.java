import java.io.*;
import java.net.*;
public class Serverchat
{
	public static void main(String[]args)throws IOException{
	ServerSocket sock=null;
	BufferedReader fromClient=null,fromUser=null;
	PrintWriter toClient=null;
	Socket client=null;
	try{
		sock=new ServerSocket(4444);
	System.out.println("Server Ready");
	client=sock.accept();
	System.out.println("Client connected");
	fromClient=new BufferedReader(new
InputStreamReader(client.getInputStream()));
	toClient=new PrintWriter(client.getOutputStream());
	fromUser=new BufferedReader(new InputStreamReader(System.in));
	String line,Usermsg;
	while(true){
	line=fromClient.readLine();
	if((line==null) || (line.equals("bye")))
	break;
	System.out.println("Client:" +line);
	System.out.print("me:");
	Usermsg=fromUser.readLine();
	toClient.println(Usermsg);
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
		
