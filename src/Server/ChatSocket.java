package Server;

import java.io.*;
import java.net.Socket;

public class ChatSocket extends Thread {
    Socket sock;

    public ChatSocket(Socket sock) {
        this.sock = sock;
    }

    public void out(String message) {
        try {
            sock.getOutputStream().write(message.getBytes("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(sock.getInputStream()));

            String line = null;
            while((line = br.readLine()) != null) {
                ChatManager.getChatManager().publish(this,line);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
