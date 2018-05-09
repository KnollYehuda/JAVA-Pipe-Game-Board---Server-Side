package Classes;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

import Interface.ClientHandler;
import Interface.Server;

public class MyServer implements Server {

	private int port;
	private ClientHandler ch;
	private volatile boolean stop;

	public MyServer(int port) {
		this.port = port;
		this.stop = false;
	}

	public MyServer(int port, ClientHandler ch) {
		this.port = port;
		this.ch = ch;
		this.stop = false;
	}

	@Override
	public void start(ClientHandler ch) {
		this.ch=ch;
		new Thread(()-> {
			try {
				runServer();
			} catch (Exception e) {
			}
		}).start();
		
	}
	
	@Override
	public void stop() {
		stop = true;

	}

	private void runServer() throws Exception {
		// System.out.println("Server Accepting :)");
		InputStream inFromClient = null;
		OutputStream outToClient = null;
		Socket aClient = null;

		ServerSocket server = new ServerSocket(this.port);
		server.setSoTimeout(600000);
		while(!stop)
		{
			try {
				// System.out.println("Waiting...");
				aClient = server.accept(); // blocking call
				// System.out.println("Client Connected...");
				inFromClient = aClient.getInputStream();
				outToClient = aClient.getOutputStream();
	
				// interact (read & write) with the client according to protocol
				ch.handleClient(inFromClient, outToClient);
				
				}
			
			catch (SocketTimeoutException e) {}
			
			finally {		
				inFromClient.close();
				outToClient.close();
				aClient.close();
			//this.stop();
			
			}
		}
		
		server.close();

	}
}

