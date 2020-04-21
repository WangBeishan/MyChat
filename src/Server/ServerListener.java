package Server;

import javax.swing.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerListener extends Thread {
    @Override
    public void run() {
        try {
            ServerSocket socket = new ServerSocket(12345);
            while(true) {
                Socket clientSock = socket.accept();
                JOptionPane.showMessageDialog(null,clientSock.getLocalAddress() + "connected");
                ChatSocket cs = new ChatSocket(clientSock);
                cs.start();
                ChatManager.getChatManager().add(cs);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
