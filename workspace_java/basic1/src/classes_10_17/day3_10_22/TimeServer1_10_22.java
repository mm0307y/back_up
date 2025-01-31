package classes_10_17.day3_10_22;
//실행 순서는 반드시 TimeServer먼저 실행하고 그 다음에 TimeClient를 실행 해야 합니다.
// TimeServer.java: 1초간격으로 현재의 시간 문자열을 접속한 클라이언트에게 전송하는
//프로그램

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;

public class TimeServer1_10_22 extends Thread { //s -> main메서드의 client

    private Socket socket;

    public TimeServer1_10_22(Socket s) {
        //아래 코드에 대해 말할 수 있다.
        //전역변수와 초기화를 시킨다. - NullPointerExcePtion방어한다.
        //얕은복사 즉 원본을 다른 메서드에서 사용하기 위해 꼭 필요하다.
        //socket변수를 run메서드에서 사용할 때 NullPionerExecption 발동한다.
        this.socket = s;
    }

    // run() 시작
    public void run() { //start()호출되면 JVM이 알아서 호출해준다. - 콜백함수(actionPerfomed)
        //socket이 null이면 PrintWriter객체가 생성안된다.
        System.out.println("run call....");
        try { 
            //출력을 할 때 말하기 할 때 사용하는 클래스 - PrintWriter
            //PrintWriter와 socket 의존관계에 있다.
            //socket이 null이면 PrintWriter객체가 생성안된다.
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            /*듣기할 때 필요한 클래스 읍니다
            BufferedReader는 필터 스트림이다. 실제 듣기를 제공하는 클래스는
            InputStreamReader클래스 입니다. - 듣기 성능 향상을 위해 사용한 필터스트림*/
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));
            while(true) {
                out.println(getTimeStr()); //현재 시간을 읽어와서 출력을 내보낸다.
                try {
                    sleep(1000); //밀리세크단위 1000이 1초이다.
                } catch(InterruptedException i) {}
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("\nClient disconnected...\n");
            try {
                socket.close();
            } catch(IOException e) {}
        }
    }
    // run() 종료

    // getTimeStr() 시작
    private String getTimeStr() {
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int min = cal.get(Calendar.MINUTE);
        int sec = cal.get(Calendar.SECOND);

        //삼항연산자
        return (hour < 10 ? "0" + hour : "" + hour) + ":" +
                (min < 10 ? "0" + min : "" + min)  +	":" +
                (sec < 10 ? "0" + sec : "" + sec) ; 
    }
    // getTimeStr() 종료



    // main() 시작
    /*74(main)-75(포트번호)-77-78-83(서버소켓생성-생성자-파라미터로 포트번호주입)
    기다린다.



    */
    public static void main(String args[]) {
        int port = 2008; //클라이언트가 접속할 포트 번호 결정한다.
        //주의 : 서버소켓은 듣고 말하기에 전혀 관여하지 않는다.
        ServerSocket server = null; //동시에 여러  사용자를 받는 소켓이다.
        Socket client = null; //듣고 말하기에 관여하는 소켓
        //이 소켓이 있어야 InputSream과 OutputStream 생성할 수 있다.
        //즉 서로 의존관계에 있다. 없(null)으면 생성이 불가하다.
        //듣기와 말하기 모두 불가한다.
        try {
            server = new ServerSocket(port); //파라미터로 2008번을 넘긴다.
        } catch(IOException e) { //예외처리 - 안배웠다. - try.catch블록
            //69번에서 예외가 발생하지 않으면 catch아래 {}모든 코드는 실행되지 않는다.
            //프로그램의 임의 중단을 막고 예외가 발생하더라도 반드시 후처리가 있다.
            //후처리를위해 예외처리는 필수이다.
            System.out.println("Can't bind port: " + port);
            e.printStackTrace();
            try {
                //사용한 자원에 대해서는 반드시 명시적으로 반납 혹은 반환 처리를 해야한다.
                //open되어 있으면 해커 불수한 목적으로 위변조를 하루 싱ㅆ다
                server.close();
            } catch(IOException i) {}
            System.exit(1);
        }
        System.out.println("Time Server started successfully...");
        while(true) { //반복문, 파라미터에 true가 있다. - 무한반복 - 왜냐면 서버니까
            try {
                //이 지점에서 기다림 발생... 언제까지.. 사용자가  new Socket(ip, port)할 때까지
                //client소켓은 서버측에서 선언하였지만 TimeClient에서 Socket생성될 때
                //바로  그 때  객체가 주입된다.
                client = server.accept(); // 접속이 들어오 낚아챈다. - 홀직원 - 스레드
                System.out.println("New Client connected..."); // 누가 왔다.
                //this가 아니라 this는 쓸 수도 없다. 왜냐면 main메서드 안이라서 - scope,Static
                //client는 Socket타입이다. 0 이것이 있어야 말하고 듣고 할 수 있다.
                //왜 생성자 파라미터를 넘기나요? - 다른(main이 아닌) 사용자 정의 메서드에 쓰려고한다.
                TimeServer1_10_22 tServer = new TimeServer1_10_22(client);
                tServer.start(); //스레드가 동작하는 ru메서드를 호출해준다.
                //사용자가 직접 스레드를 컨트롤 하지 못한다. - 보호
                //결합도를 낮추기 위해서이다. 결합도가 높으면 재사용성이 떨어진다.
                //결합도가높으면 단위테스와 통합테스트가 어려워진다.
                //코드의 양은 늘어나더라도 복잡도가 증가하지 않도록 코딩하기
                //3달후에 코드를 보게된다면... 그런데 복잡하다면... 분석하는데 시간이 오래 걸린다.
                //시간 - 자동화, 반복되는 코드를 줄여서 일괄처리한다.
                System.out.println("New Time Server Thread started...");
            } catch(IOException e) {
                System.out.println("Can't start server thread!!");
                e.printStackTrace();
                try {
                    client.close();
                } catch(IOException i) {}
            }
        }
    }
    // main() 종료
}
/*
1. 서버는 2008번 포트에서 클라이언트 연결을 기다린다.
server = new ServerSocket(2008); // 1~65570사이의 숫자를 사용한다.
1~1023번까지는 윈도우 운영체제가 사용하므로 피한다.

2. 클라이언트가 연결(new Socket("172.16.90.45", 2008)되면
새로운 스레드가 생성되어 해당 클라이언트에게 1초마다 현재 시간을 전송합니다.
:객체를 생성할 때 서버소켓에 접속을 시도하게 됩니다. 다른 코드는 필요 없습니다.

3. 클라이언트가 연결을 좋료하면 해당 스레드는 종료됩니다.
스레드 클래스가 사용자에 대해서 라이프사이클을 관리를 한다.(생성 - 활용 - 죽음)

4. 서버는 새로운 클라이언트가 연결될 때까지 계속 대기하며
연결될 때 새로운 스레드를 생성합니다.(깊은복사)

*/
