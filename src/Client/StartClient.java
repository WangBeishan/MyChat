package Client;

public class StartClient {
    public static void main(String[] args) {
        Window win = new Window();
        win.setVisible(true);
        ChatManage.getChatManage().setWindow(win);
    }
}
