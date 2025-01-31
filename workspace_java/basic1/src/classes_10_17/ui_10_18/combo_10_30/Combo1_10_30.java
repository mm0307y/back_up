package classes_10_17.ui_10_18.combo_10_30;
//this는 combo1, < JFrame - this가 가리키는게 Combo1이지만
//내 안에는 add()없다. 그런데 JFrame에는 있다.
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Combo1_10_30 extends JFrame implements ItemListener {
    JPanel jp_north = new JPanel();
    JComboBox jcb1 = null;
    JComboBox jcb2 = new JComboBox();
    JComboBox jcb3 = null;
    JTextArea jta_log = new JTextArea();
    //생성자도 메서드 오버로딩의 규칙을 따른다. - 오버로딩(파라미터의 개수가 다르거나 타입이 달라야한다.)
    JScrollPane jsp_log = new JScrollPane(jta_log, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    public Combo1_10_30() { //생성자는 메인메서드에서 호출이되고 인스턴스화를 해야 실행된다.
        jcb1 = new JComboBox(); //파라미터가 없는 빈 생성자?
        jcb1.addItem("돈까스");
        jcb1.addItem("떡볶이");
        jcb1.addItem("김밥");
        initDisplay();
    }
    
    public void initDisplay(){
        jcb3 = new JComboBox(new String[]{"전체", "서울", "경기", "부산"}); //널포인트 익세션 보호
        jp_north.setLayout(new GridLayout(3,1));
        jcb3.addItemListener(this);
        jp_north.add(jcb1);
        jp_north.add(jcb2);
        jp_north.add(jcb3);
        this.add("North", jp_north);
        this.add("Center", jsp_log);
        //JVM과 App사이의 연결고리가 끊겨서 자원반납을 한다.
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(300,300);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Combo1_10_30();
    }

    //ItemListener가 정의하는 추상 메서드를 오버라이딩하고 있어서
    //Combo1은 ItemListener 구현체 클라스라고 한다.
    //jcb1.addItemListener(this)
    @Override
    public void itemStateChanged(ItemEvent e) {
        Object source = e.getSource();
        if (source == jcb3) {
            if (e.getStateChange() == ItemEvent.SELECTED){
                int index = jcb3.getSelectedIndex(); //0부터 시작되는지 1부터 시작이 되는지 확인해야 한다.
//                System.out.println(index + "선택 되었습니다.");
                //문자열 뒤에 \n을 붙으면 줄 바꿈이 실행된다.
                jta_log.append(index + "선택 되었습니다.\n");
                String item = (String) jcb3.getItemAt(index);
                //append는 기존 문자열 뒤에 새로운 문자열을 추가한다.
                //setText는 기존 문자열 지우고 새로운 문자열로 교체한다.
//                jta_log.append("선택한 아이템은 " + item + "입니다.\n");
                jta_log.setText("선택한 아이템은 " + item + "입니다.\n");
            }
        }
    }
}
