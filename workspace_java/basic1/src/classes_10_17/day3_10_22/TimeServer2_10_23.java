package classes_10_17.day3_10_22;

import java.net.ServerSocket;
import java.net.Socket;

public class TimeServer2_10_23 extends Thread {
    //선언부
    //생성자
    public void init(){
        int port = 5000;
        try {
            //예외가 발생할 가능성이 있는 코드를 쓴다.
            ServerSocket ss = new ServerSocket(port); //네트워크 관련 애들은 외적으로 오류가 생길수 있으니 예외처리를 해야한다.
            System.out.println("Server Ready... \n");
            //insert here
            while (true){
                //아래 코드는 진행이 안된다. - waiting
                //다음코드가 실행되지 않고 있다면 nwe Socket(ip, port); 을 실행하지 않았다.
                Socket s = ss.accept(); // client측 소켓을 받아온다.
                //소켓을 이용ㅇ해서 inputstream, outputstream 생성한다.
                System.out.println("Accepted connection from " + s.getInetAddress());
                System.out.println("dk?");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    //메인메서드
    public static void main(String[] args) {
        TimeServer2_10_23 ts2 = new TimeServer2_10_23();
        ts2.init(); //준비
        ts2.start(); //스레드가 동작한다 - run()호출된다.
    }
}
