package athread_10_21.setp1_11_08;

import javax.swing.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Vector;

class KiwiServerThread extends Thread {
    KiwiServer_11_08 ks = null;
    ObjectOutputStream oos = null;
    ObjectInputStream ois = null;
    String nickName = null;
    KiwiServerThread(){}
    //아래 생성자는 언제 호출 되는가? - 사용자가 서버에 접속하면 (실행했을때)
    KiwiServerThread(KiwiServer_11_08 ks){
        this.ks = ks;
        try {
            oos = new ObjectOutputStream(ks.client.getOutputStream());
            ois = new ObjectInputStream(ks.client.getInputStream());
            String msg = (String)ois.readObject();
            System.out.println(msg);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

public class KiwiServer_11_08 extends JFrame implements Runnable {
    ServerSocket ss = null; //3000번 포트를 열어놓고 사용자가 접속하기를 기달린다.
    Socket client = null; //클라이언트 측에서 3000번으로 들어오면 클라이언트 소켓정보를 client 변수에 담는다.
    List<KiwiClientThread> globalList = null;
    List<Room_11_08> roomList = null;

    public KiwiServer_11_08() {
        roomList = new Vector<>();
        globalList = new Vector<>();
    }

    @Override
    public void run() {
        System.out.println("run호출 성공");
        try{
            ss = new ServerSocket(3000);
            System.out.println("Server Ready...");
            ////waiting 구간
            while (true){
                client = ss.accept();
                System.out.println(client.getInetAddress().getHostAddress());
                KiwiClientThread t = new KiwiClientThread();
                t.start();
            }
        }
        catch (Exception e){

        }
    }

    public static void main(String[] args) {
        KiwiServer_11_08 ks = new KiwiServer_11_08();
        Thread t = new Thread(ks);
        t.start();
    }
}
