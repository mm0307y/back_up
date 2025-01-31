package classes_10_17.day3_10_22;

// TimeClient.java: 서버에 접속해서 1초마다 시간 문자열을 받아서 출력하는 프로그램

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TimeClient1 extends Thread {
    //다른 클래스의 화면에 TimeClient1이 청취한 현재 시분초 문자열을
    //출력하는 문제 이므로 JLabel UI클래스를 선언하였다.(얕은복사)
    private JLabel label=null;
    public TimeClient1(){}
    //파라미터를 갖는 생성자 추가해야 합니다와 연결되어 있다.
    //파라미터에 자리에 필요한 타입도 결정할 수 있다면.... + 파라미터 갯수도 결정해보기
    // run() 시작
    public void run() {
        //일방적으로 무엇(현재시간 - 누가? - TimeServer1 - String) 듣기만 한다.
        Socket socket = null;
        PrintWriter out = null;
        BufferedReader in = null;
        String timeStr = null;

        try {
            socket = new Socket("localhost", 2008); //192.168.0.98 정해준 번호 2008
            //socket이 null이면 PrintWriter나 InputStreamReader 생성안된다.
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            while(true) {
                System.out.println("while(true)");
                while((timeStr = in.readLine()) != null) {
                    System.out.println(timeStr);
                }
                try {
                    Thread.sleep(1000);
                } catch(InterruptedException i) {}
            }

        } catch(IOException i) {
            label.setText("타임서버에 접속할 수 없습니다.");
        } finally {
            try {
                in.close();
                out.close();
                socket.close();
            } catch (IOException e) {}
        }
    }
    // run() 종료
    //57-16(생성자호출-빈깡통)-58(run()호출-콜백함수)-20-28(TimeServer1에서 낚아챈다)
    //28번에서 생성된 소켓객체로 inputStream과 outputstream생성함
    //
    public static void main(String args[]){
        TimeClient1 tc = new TimeClient1();
        tc.start();
    }

}