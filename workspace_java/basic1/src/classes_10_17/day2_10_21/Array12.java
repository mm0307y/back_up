package classes_10_17.day2_10_21;

import javax.xml.crypto.dsig.spec.HMACParameterSpec;

public class Array12 {
    public static void main(String[] args) {
        String[][] datas = new String[2][3];
        String msg = null;
        System.out.println(datas[1][2]);
        System.out.println(datas[0][1]);
        System.out.println(datas[1][0]);
        String[][] names ={ //선언 및 초기화를 한 번에 할 수 있다.
                {"John", "Doe","King"},
                {"Ward", "Tiger","Scott"},
        };
        System.out.println(names[1][2]); // Scott
        System.out.println(names[0][1]); // Doe
        System.out.println(names[1][0]); // Ward
        String[][] msgs = new String[][]{
                {"안녕", "내일봐","점심 뭐 먹을까"},
                {"무슨영화 좋아해", "커피마실까","스터디해요."},
        };
        System.out.println(msgs[1][2]);
        System.out.println(msgs.length); //2 - 로우(행)수 원소의 갯수를 나타낸다.
        System.out.println(msgs[0].length); //3 - 열의 수
        //배열의 단점은 같은 타입만 담을 수 있다.
        //대입연사자 오른쪽에 더 작은 타입이 오는 건 늘 합업이다.
        //그러나 더 큰 타입이 오는건 문법 에러이다.
        //이럴 경우 그 숫자가 계산식에 사용된다면 모두 형전화을 해야합니다. - 100억건이라고 하면 어후..
        Object[][] msgs2 = new Object[][]{
                {1,"안녕","내일봐","점심 뭐 먹을까"},
                {2, "무슨영화 좋아해", "커피마실까", "스터디해요"}
        };
    }
}
