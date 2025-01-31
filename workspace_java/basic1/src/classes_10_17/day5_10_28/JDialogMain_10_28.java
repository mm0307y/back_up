package classes_10_17.day5_10_28;

import javax.swing.*;
import java.awt.*;

public class JDialogMain_10_28 extends JDialog {
    JFrameMain_10_28 jfm = null;
    JPanel jp_center = new JPanel();
    JPanel jp_south = new JPanel();
    JLabel jlb_name = new JLabel("이 름 : ");
    JTextField jtf_name = new JTextField(20);
    JLabel jlb_gender = new JLabel("성 별 : ");
    ButtonGroup bg = new ButtonGroup();
    JRadioButton jrb_male = new JRadioButton("남자",true);
    JRadioButton jrb_female = new JRadioButton("여자", false);
    JButton jb_save = new JButton("저장");
    JButton jb_close = new JButton("닫기");

    JDialogMain_10_28(JFrameMain_10_28 jfm2){
        this.jfm = jfm2;
        initDisplay(); //화면그리기 메서드 호출
    } ////디폴트 생성자

    public String getSelectedGender(){
        if(jrb_male.isSelected()){
            return "남자";
        }
        else if(jrb_female.isSelected()){
            return "여자";
        }
        else {
            return null;
        }
    }

    public String getName(){
        return jtf_name.getText();
    }
    public void setName(String gender){
        jtf_name.setText(gender);
    }

    /*부모창에서 사용자의 요청에 따라 화면이 켜지고 타이틀도 바뀌고 setVisible 바뀌고
    또 setSize도 바뀌고 JTextField도 상세보기 일때는 일기만 (비활성화)
    입력과 수정일 때는 활성화 시켜주어야 한다.
    아래 메서드는 JFrameMain_10_28에서 호출한다.*/
    public void set(String title, boolean isView, boolean editable){
        setEditable(editable);
        this.setTitle(title);
        this.setVisible(isView);
    }
    public void setEditable(boolean editable){
        jtf_name.setEditable(editable); //true 입력, 수정, false 비활성화 - only read
    }

    void initDisplay(){
        jp_center.setLayout(null); //FlowLayout이 디폴트인데 좌표값으로 배치한다.
        jlb_name.setBounds(20,20,100,20);
        jtf_name.setBounds(120,20,100,20);
        jlb_gender.setBounds(20,45,100,20);
        jrb_male.setBounds(120,45,100,20);
        jrb_female.setBounds(220,45,100,20);
        bg.add(jrb_male);
        bg.add(jrb_female);
        jp_center.add(jlb_name);
        jp_center.add(jtf_name);
        jp_center.add(jlb_gender);
        jp_center.add(jrb_male);
        jp_center.add(jrb_female);
        jp_center.setBackground(new Color(158,217,203));
        jp_center.setBorder(BorderFactory.createEtchedBorder());
        jp_south.setLayout(new FlowLayout(FlowLayout.CENTER));
        jb_save.setBackground(new Color(19,99,57));
        jb_save.setForeground(new Color(212,212,212));
        jb_close.setBackground(new Color(54,54,54));
        jb_close.setForeground(new Color(212,212,212));
        jp_south.add(jb_save);
        jp_south.add(jb_close);
        jp_south.setBackground(new Color(142,186,195));
        jp_south.setBorder(BorderFactory.createEtchedBorder());
        this.add("Center", jp_center);
        this.add("South", jp_south);
        this.setTitle("입력 | 수정 | 상세보기");
        this.setSize(500,400);
        this.setVisible(false);

    }//// dne do initDisplay
    public static void main(String[] args) {
        new JDialogMain_10_28(null);
    }////end of main
}
