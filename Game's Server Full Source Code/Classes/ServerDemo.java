package Classes;

import Interface.ClientHandler;
import Interface.Server;

public class ServerDemo {

	public static void main(String[] args) {
		ClientHandler ch = new MyClientHandler();
		int port = 6400;

		Server pipeServer = new MyServer(port, ch);
		pipeServer.start(ch);

	}
}