package athread_10_21.setp1_11_08;

public class Protocol_11_08 {
    public static final int WAIT = 100;//대기자방
    public static final int ROOM_CREATE = 110;//단톡방파기
    public static final int ROOM_LIST = 120;//단톡방목록
    public static final int ROOM_IN = 130;//방입장하기
    public static final int ROOM_INLIST = 140;//단톡방에 있는 사람목록
    public static final int ROOM_OUT= 190;//방나가기
    public static final int MESSAGE= 200;//다자간대화
    public static final int WHISPER= 201;//1:1대화
    public static final int NICK_CHANGE= 300;//대화명변경
    public static final int COLOR_CHANGE= 400;//글자색 변경
    public static final String seperator= "#";//메시지의 토큰값

}
