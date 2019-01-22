package chatserver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ChatClientUI extends Frame implements ChatClientMessageSenderThread{

    private Socket socket;
    private DataOutputStream streamOut;
    private ChatClientMessageReceiver messageReceiver;
    private TextArea chatArea;
    private Button disconnectButton;
    private TextField addressfield;
    private Button connectButton;
    private Panel sendPanel;

    public ChatClientUI(){
        setTitle("Chat Client");
        setLocation(100, 100);
        setSize(600, 800);

        Panel connectionPanel = new Panel();
        connectionPanel.setLayout(new GridLayout(1, 3));
        addressfield = new TextField("localhost");
        disconnectButton = new Button("Disconnect");
        disconnectButton.setEnabled(false);
        connectButton = new Button("Connect");
        connectionPanel.add(addressfield);
        connectionPanel.add(connectButton);
        connectionPanel.add(disconnectButton);
        add("North", connectionPanel);

        chatArea = new TextArea();
        chatArea.setEditable(false);
        chatArea.setFocusable(false);
        add("Center", chatArea);

        sendPanel = new Panel();
        sendPanel.setLayout(new BorderLayout());
        sendPanel.setPreferredSize(new Dimension(300, 30));
        TextField messageField = new TextField();
        Button sendButton = new Button("Send");
        sendPanel.add("East", sendButton);
        sendPanel.add("Center", messageField);
        add("South", sendPanel);

        sendPanel.setEnabled(false);


        sendButton.addActionListener(p -> {
            try {
                streamOut.writeUTF(messageField.getText());
                streamOut.flush();
            }catch (IOException e){
                e.printStackTrace();
            }
            messageField.setText("");
        });

        connectButton.addActionListener(p -> {
            try{
                socket = new Socket(addressfield.getText(), 8000);
                streamOut = new DataOutputStream(socket.getOutputStream());
                messageReceiver = new ChatClientMessageReceiver(this);
                new Thread(messageReceiver).start();

                disconnectButton.setEnabled(true);
                sendPanel.setEnabled(true);
                addressfield.setEnabled(false);
                connectButton.setEnabled(false);
            }catch (Exception e){
                e.printStackTrace();
            }
        });

        disconnectButton.addActionListener(p -> close());

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        setVisible(true);
    }

    public static void main(String[] args){
        new ChatClientUI();
    }

    @Override
    public void handleMessage(String msg) {
        if(msg.equals(".bye")){
            chatArea.append("Connection closed.");
            close();
        }else{
            chatArea.append(msg + "\n");
        }

    }

    @Override
    public void close() {
        try {
            if(streamOut != null)
                streamOut.close();
            if(socket != null)
                socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        messageReceiver.close();
        messageReceiver.setActive(false);

        disconnectButton.setEnabled(false);
        sendPanel.setEnabled(false);
        addressfield.setEnabled(true);
        connectButton.setEnabled(true);
    }

    @Override
    public Socket getSocket() {
        return socket;
    }
}
