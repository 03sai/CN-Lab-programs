import java.net.*;
import java.io.*;
public class Clientecho{ 
	public static void main(String[]args)throws IOException{
	BufferedReader fromServer=null,fromUser=null;
	PrintWriter toServer=null;
	Socket sock=null;
	try{
		if(args.length==0)
		sock=new Socket(InetAddress.getLocalHost(),1024);
	else
		sock=new Socket(InetAddress.getByName(args[0]),1024);
	fromServer=new BufferedReader(new
InputStreamReader(sock.getInputStream()));
	fromUser=new BufferedReader(new InputStreamReader(System.in));
	toServer=new PrintWriter(sock.getOutputStream(),true);
	String Usermsg,Servmsg;
	System.out.println("Type \"bye\" to quit");
	while(true){
		System.out.println("Enter msg to server:");
		Usermsg=fromUser.readLine();
		if(Usermsg.equals("bye")){
		toServer.println("bye"); 
		break;
	}
	else
		toServer.println(Usermsg);
		Servmsg=fromServer.readLine();
		System.out.println(Servmsg);
	}
	fromUser.close();
	fromServer.close();
	toServer.close();
	sock.close();
	}
	catch(IOException ioe){
	System.err.println(ioe);
	}
	}
}

