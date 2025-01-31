package basic_11_07.collection_11_07;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapTest1_11_07 {
    public static void main(String[] args) {
        Map<String, String> map1 = new HashMap<>();
        map1.put("name", "나신입");
        map1.put("school", "가산대학교");
        map1.put("address", "서울시 마포구 공덕동");
        map1.put("age", String.valueOf(30));
        Map<String, Object> map2 = new HashMap<>();
        map2.put("name", "나신입");
        map2.put("school", "가산대학교");
        map2.put("address", "서울시 마포구 공덕동");
        map2.put("age", 30);
        Set<String> set = map1.keySet();
        //String 으로 다운시켜서 처리하려고 했는데 ClassCastException발하였다.
        //그래서 맞춰주었다.
//        String[] keys = set.toArray(new String[set.size()]);
        Object[] keys = set.toArray();
        for (int i = 0; i < keys.length; i++) {
            System.out.println(keys[i]); //name, school, address,age
        }
        //값을 출력해 보세요.
        for (int i = 0; i < keys.length; i++) {
            System.out.println(map1.get(keys[i])); //나신입, 가산대학교, 서울시 마포구 공덕동, 30
        }

    }

}
