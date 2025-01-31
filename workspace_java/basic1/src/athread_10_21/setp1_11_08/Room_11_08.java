package athread_10_21.setp1_11_08;

import java.util.List;
import java.util.Vector;

public class Room_11_08 {
    List<KiwiServerThread> userList = new Vector<>();
    List<String> nameList = new Vector<>();
    String title; //단톡방이름
    String state; //방상태
    int max = 0; //최대 정원수
    int current = 0; //현재 인원 수
    public Room_11_08(){}
    public Room_11_08(String title, String state, int max) {
        this.title = title;
        this.state = state;
        this.max = max;
    }
}
