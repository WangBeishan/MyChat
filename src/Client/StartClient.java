package Client;

import java.awt.*;

public class StartClient {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Window win = new Window();
                win.setVisible(true);
                ChatManage.getChatManage().setWindow(win);
            }
        });
    }
}
