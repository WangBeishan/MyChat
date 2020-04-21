package Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame {

    JTextField ipField;
    JButton connectButton;
    JTextArea messageArea;
    JTextField sendField;
    JButton sendButton;

    public void registerWin() {
        JFrame frame = new JFrame("FChat");
        frame.setBounds(100,100,300,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel pane = new JPanel();
        JTextField userName = new JTextField(15);
        JTextField userPassword = new JTextField(15);
        JTable forgetPw = new JTable();
        JButton loginBut = new JButton("Login");
        JButton registerBut = new JButton("Register");

        forgetPw.setName("forget password?");

        pane.add(userName);
        pane.add(userPassword);
        pane.add(forgetPw);
        pane.add(loginBut);

        frame.getContentPane().add(BorderLayout.CENTER,pane);
        frame.setVisible(true);
    }

    public Window() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel NPane = new JPanel();
        ipField = new JTextField(15);
        ipField.setText("127.0.0.1");
        connectButton = new JButton("Connect");
        connectButton.addActionListener(new ConnectButton());
        NPane.add(ipField);
        NPane.add(connectButton);

        JPanel CPane = new JPanel();
        CPane.setBounds(10,10,500,400);
        messageArea = new JTextArea(40,30);
        messageArea.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(messageArea);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        CPane.add(scrollPane);

        JPanel SPane = new JPanel();
        sendField = new JTextField(15);
        sendButton = new JButton("Send");
        sendButton.addActionListener(new SendButton());
        SPane.add(sendField);
        SPane.add(sendButton);

        this.setBounds(100,100,600,500);
        this.getContentPane().add(BorderLayout.NORTH,NPane);
        this.getContentPane().add(BorderLayout.CENTER,CPane);
        this.getContentPane().add(BorderLayout.SOUTH,SPane);
    }

    public void appendText(String message) {
        messageArea.append("\n" + message);
    }

    class ConnectButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            ChatManage.getChatManage().connect(ipField.getText());
        }
    }

    class SendButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            ChatManage.getChatManage().sendMessage(sendField.getText());
            appendText("You : " + sendField.getText());
            sendField.setText("");
        }
    }
 }
