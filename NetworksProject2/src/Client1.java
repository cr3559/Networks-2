import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client1 
{
	Socket clientSocket;

    public void setupClient()
    {	
    	
    	//Scanner used to collect input from the user
    	Scanner userInput = new Scanner(System.in);
        try
        {
        	int i = 0;
        	this.clientSocket = new Socket("127.0.0.1", 4446); 
        	while(i < 10)
        	{
        		
	    		// Setup a socket that will try to connect to a specific address(usually an IPv4 address)
	    		// and port number.
	
	            // First the client sets up its send connection
	            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream()); //USE PrintWriter out = new PrintWriter<clientSocket.getOutputStream(),true);(FROM GIRARD);
	            out.flush(); //Need this
	            
	            //Scanner to read message from  server
	            Scanner in = new Scanner(clientSocket.getInputStream());
	            
	            //String that holds the users input
	            String userString = userInput.nextLine() + "\n";
	            
	            while(userString.length() < 11 || userString.length() > 11)
	            {
	            	System.out.println("String is not 10 characters. Please enter a 10 character String.\n");
	            	userString = userInput.nextLine() + "\n";
	            }
	            
	            //Sends user input to the server
	            out.writeBytes(userString);
	            
	            //String sent back by the server
	            String message = in.nextLine();
	            
	            System.out.println(message);
	            i++;
        	}

            // Done talking
            this.clientSocket.close();

        }
        catch (UnknownHostException e) //bad address
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IOException e)	//error when setting up connection
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    public static void main (String[] args)
    {
    	Client1 client = new Client1();
    	client.setupClient();
    }
}
