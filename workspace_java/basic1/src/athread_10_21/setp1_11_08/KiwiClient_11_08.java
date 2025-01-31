package athread_10_21.setp1_11_08;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

//서버측에서 전송한 문자열을 청취하기
class KiwiClientThread extends Thread {
    public void run() {
        System.out.println("run 메서드 호출 성공");
    }
}
public class KiwiClient_11_08 extends JFrame {
    LoginApp_11_08 loginApp = null;
    JTabbedPane tp = new JTabbedPane();
    MessageRoom_11_08 mr = new MessageRoom_11_08(this);
    WaitRoom_11_08 wr = new WaitRoom_11_08(this);
    Socket mySocket = null;
    ObjectOutputStream oos = null;
    ObjectInputStream ois = null;
    String ip = "127.0.0.1";
    int port = 3000;

    public KiwiClient_11_08(LoginApp_11_08 loginApp) {
        this.loginApp = loginApp;
        initDisplay();
        //connect_process();
    }

    //이 메서드는 initDisplay()호출 한 뒤에 호출해야 합니다.
    //왜냐하면 지연이 발생하니까
    public void connect_process() { //지연해주는 코드
        this.setTitle(loginApp.nickName + " 님의 대화창");
        try{
            mySocket = new Socket(ip, port);
            oos = new ObjectOutputStream(mySocket.getOutputStream());
            ois = new ObjectInputStream(mySocket.getInputStream());
            Room_11_08 room = new Room_11_08();
            room.state = "대기";
            oos.writeObject(Protocol_11_08.WAIT + Protocol_11_08.seperator + loginApp.nickName + Protocol_11_08.seperator + room.state);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void initDisplay(){
        //tp.addTab("대기실", wr);
        //tp.addTab("단톡방", mr);
        this.setSize(650,580);
        this.setVisible(false);
    }

    public static void main(String[] args) {
        KiwiClientThread kct = new KiwiClientThread();
        kct.start();
    }
}
