import java.io.*;
import java.net.*;
import java.util.Scanner;
public class server
{
  public static Socket socket;
    public static void main(String[]args) throws IOException {
        int port = 8080;
        String answer; String returnedMessage; String reply;
        ServerSocket server = new ServerSocket(port);
        System.out.println("Server start at port "+port+".");

        while(true)
        {
            socket = server.accept();
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            answer = br.readLine();
            System.out.println("Message sent from client: " + answer);

            if("NET 3202".equals(answer) || "net 3202".equals(answer) || "NET3202".equals(answer) || "net3202".equals(answer)){
                reply = "Correct!";
                returnedMessage = reply;
            }
            else{
                reply = "Wrong!";
                returnedMessage = reply;
            }

            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
           BufferedWriter bw = new BufferedWriter(osw);
            bw.write(returnedMessage);
            bw.newLine();
            System.out.println("Message replied to client: "+returnedMessage);
            bw.flush();
        }
    }
}
