import java.net.*;
import java.io.*;
import java.lang.String;
public class ServerFile{
public static void main(String [] args)throws IOException{
ServerSocket sock=null;
BufferedInputStream bis=null;
Socket client=null;
OutputStream os=null;
int a;
try{
sock=new ServerSocket(4000);
System.out.println("Waiting...");
client=sock.accept();
System.out.println("Server Ready");
System.out.println("Accepted connection:" +client);
String s="ServerFile.txt";
File myfilee=new File(s);
byte [] array=new byte[(int)myfilee.length()];
bis=new BufferedInputStream(new FileInputStream(myfilee));
a=bis.read(array,0,array.length);
os=client.getOutputStream();
os.write(array,0,a);
os.flush();
}
catch(IOException ioe){
System.out.println(ioe);
}
}
}

