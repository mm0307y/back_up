package basic_11_07.collection_11_07;
/*
변수 - 같으 타입만 담을 수 있다.
배열 - 같은 타입만 담을 수 있다. 크기가 고정이다.
객체배열 - 다른 타입도 담을 수 있다. 그러나 크기는 고정이다.
컬렉션 프레임워크 - 다른 타입도 담을 수 있다. 크기도 늘었다 줄었다 한다.
- Object타입이라면 모두 담는다.(원시형은 안된다.)
- int -> Integer, double -> Double, 원시형이더라도 wrapper 클래스가 있다.
*/

import javax.swing.*;
import java.util.HashMap;
import java.util.Set;

public class MapTest2_11_08 {
    public static void main(String[] args) {
        //key에는 String 타입만 가능하다. value에는 Object타입이면 모두 가능하다.
        HashMap<String, Object> map = new HashMap<>();
        map.put("key1", "value1"); //String
        map.put("key2", "value2"); //원시형의 경우 wrapper클래스로 자동전환 된다. - 오토박싱이다.
        map.put("key3", new JButton("전송"));
        Set<String> set = map.keySet();
        Object[] keys = set.toArray();
        for (int i = 0; i < keys.length; i++) {
            System.out.println(keys[i] + "=>" + map.get(keys[i]));
        }
    }
}
