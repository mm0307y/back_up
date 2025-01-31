package jdbc_10_24.Test_11_06;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
class BVO{
    private int age;
    private String name;
}

public class BVOMain_11_06 {
    public static void main(String[] args) {
        AVO avo = new AVO(30, "강감찬");
        avo.setAge(50);
        avo.setName("이성계");
        System.out.println(avo.getAge()); //30 -> 50
        //변수는 한 번에 하나만 기억할 수 있다.
        System.out.println(avo.getName()); //강감찬 -> 이성계
        BVO bvo = BVO.builder().name("김유신").age(20).build();
        System.out.println(bvo.getAge());
        System.out.println(bvo.getName());
        System.out.println(bvo);
    }
}


