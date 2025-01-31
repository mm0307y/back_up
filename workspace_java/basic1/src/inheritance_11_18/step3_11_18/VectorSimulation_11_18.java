package inheritance_11_18.step3_11_18;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

//힌트는 생성자
//setter 지원되자 않는 경우? 어떻게 해야 하나
public class VectorSimulation_11_18 {

    public static void main(String[] args) {
        Vector_11_19 vector = new Vector_11_19(2, 3);
        vector = new Vector_11_19(5, 3);
        System.out.println(vector.getX() );
        System.out.println(vector.getY() );
        Class cv = vector.getClass();
        System.out.println(cv.getPackageName());
        System.out.println(cv.getTypeName());
        //클래스 안에 선언된 메서드 이름을 알고 싶다.
        Method[] methods = cv.getMethods();
        for (Method m : methods) {
            System.out.println(m.getName());
        }
        System.out.println(methods.length);

        // 상속된 메서드를 제외한 나머지를 카운트를 한다.
        methods = cv.getDeclaredMethods();
        System.out.println(methods.length);
        Field[] fields = cv.getFields();
        fields = cv.getDeclaredFields();
        System.out.println(fields[0] + ", " + fields[1] );
        //
        Class objectClass = cv.getSuperclass();
        System.out.println(objectClass.getTypeName());
    }
}
