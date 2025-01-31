package classes_10_17.day3_10_22;

import java.net.Socket;

public class TimeClient2_10_23 {
    public void init(){
     try{
         Socket socket = new Socket("192.168.0.13",5000);
     }
     catch (Exception e){

     }
    }

    //main 스레드 이다.
    public static void main(String[] args) {
        TimeClient2_10_23 tc = new TimeClient2_10_23();
        tc.init();
    }
}
