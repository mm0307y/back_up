package quiz_10_17.setp1_10_17;

import java.util.ArrayList;
import java.util.List;

public class DeptMain2_10_25 {
    public static void main(String[] args) {
        List<DeptDTO> list = new ArrayList<>();
        DeptDTO dto2 = new DeptDTO();
        System.out.println(list.size()); //0
        list.add(dto2);
        System.out.println(list.size()); //1

        dto2 = new DeptDTO();
        list.add(dto2);

        dto2 = new DeptDTO();
        list.add(dto2);
        for(DeptDTO dto:list) {
            System.out.println(dto);
        }
    }

}
