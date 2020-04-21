package Client;

import java.io.*;
import java.net.Socket;

public class ChatManage {
    private ChatManage() {}
    private static final ChatManage instance = new ChatManage();

    public static ChatManage getChatManage() { return instance; }

    Window win;
    Socket sock;
    BufferedReader reader;
    BufferedWriter writer;

    public void setWindow(Window win) {
        this.win = win;
    }

    public void connect(String ip) {
        try {
            sock = new Socket(ip,5000);
            win.appendText("connected ip : " + ip);
            reader = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            Thread t = new Thread(new Remote());
            t.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String message) {
        try {
            writer = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
            writer.write(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class Remote implements Runnable {

        @Override
        public void run() {
            try {
                String line = null;
                while ((line = reader.readLine()) != null) {
                    win.appendText("\n" + sock.getInetAddress() + line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
