    package jdbc_10_24.book_11_04;
/*
BookApp과 BookDialog사이의 관계가 있다.
static이 아니라 생성자의 파라미터에 this를 넘겨서 그 클래스의 관계를 맺는다.
- 입력에서 저장 누르거나 수정에서 저장을 눌렀을때
insert into book152 values (1, '자바의정석', '도우출판사', '도서설명', '1.png')
- 반환값이 int 이다. 1이면 입력 성공, 0이면 입력 실패
- 입력 성공일 때 화면 흐롬도(Flow Chart) BookDialog 창은 닫히고
한 건이 추가 되었으므로 BookApp 화면을 열어서 추가되 건이 반영되도록
부모창의 새로고침 메서드를 호출한다.*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.Book;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BookDialog_11_04 extends JDialog implements ActionListener {
    BookApp_11_04 ba = null;
    //set메서드의 세번째 파라미터로 넘오는 주소번지를 받아 줄 변수 선언하기
    BookVO_11_04 bvo = null;
    BookDao_11_04 bdao = new BookDao_11_04();

    //인스턴스화를 하면 생성자 호출이 일어남.
    JLabel 		jlb_title = new JLabel("책제목");
    JTextField 	jtf_title = new JTextField(30);
    JLabel 		jlb_author = new JLabel("저자");
    JTextField 	jtf_author = new JTextField(40);
    JLabel 		jlb_publish = new JLabel("출판사");
    JTextField 	jtf_publish = new JTextField(50);
    JLabel 		jlb_info = new JLabel("도서소개");
    JTextArea 	jta_info = new JTextArea(8,25);
    JButton		jbtn_file = new JButton("파일찾기");
    JTextField 	jtf_file = new JTextField(35);
    JLabel		jlb_img	 = new JLabel("이미지");
    JPanel jp_center = new JPanel();
    JScrollPane jsp = new JScrollPane(jp_center);
    JScrollPane jsp_info = new JScrollPane(jta_info);
    String path = "D:\\workspace_java\\basic1\\src\\image\\book\\";
    //파일 열기와 관련된 객체 생성하기
    JFileChooser chooser = new JFileChooser();
    JPanel jp_south = new JPanel();
    //입력일 때와 수정일 때가 다르게 처리해야 합니다.
    JButton jb_save = new JButton("저장");
    JButton jb_close = new JButton("닫기");
    Container cont = getContentPane();

    BookDialog_11_04(BookApp_11_04 ba){
        System.out.println(ba); //null 출력되니깐 이러면 메서드를 호출이 불가하다.
        this.ba = ba;
        initDisplay();
    }

    public void set(String title, boolean isView, BookVO_11_04 bVO, boolean editable){
        this.bvo = bVO;
        this.setTitle(title); //입력 or 수정 or 상세보기
        this.setVisible(isView);
        //입력, 수정, 상세보기를 선택하는 건 BookApp에서 한다.
        //수정이나 상세보기는 select문을 요청하고 그 결과로 BookVO를 받는다.
        //이벤트가 발생하면 BookApp에서 BookDiglog의 set 메서드를 호출한다.
        //파라미터로 받은 BookVO의 주소번지를 setValue()을 호출할 때 파라미터로 넘긴다.
        //수정하기와 상세보기는 오라클 서버를 경유합니다. 어디서 BookApp에서 한다.
        //그 결과는 BookApp에서 생성(BookVO - 1건만 담김)한다.
        //set메서드를  호출할 때 파라미터로 주소번지 원본을 넘긴다.
        setValue(bVO); //입력 일때는 null, 상세보기, 수정일때는 new BookVO_11_04(...)
        setEditable(editable);
    }

    //입력과 수정시에는 컬럼값을 수정 가능하도록 하고
    //상세보기에는 불가능하게 하는 메서드를 구현하시오.
    public void setEditable(boolean editable){
        jtf_title.setEditable(editable);
        jtf_author.setEditable(editable);
        jtf_publish.setEditable(editable);
        jta_info.setEditable(editable);
    }

    public void setValue(BookVO_11_04 bookVO){
        //입력을 위한 화면 설정 - 모든 값을 빈문자열로 셋팅한다.
        if (bookVO == null){ //오라클 서버를 경유하지 않은 경우
            setB_title("");
            setAuthor("");
            setPublish("");
            setInfo("");
            setImg("");
        }
        //상세조회 혹은 수정시 파라미터로 받은 값으로 세팅하기
        else {
            setB_title(bookVO.getB_name());
            setAuthor(bookVO.getB_author());
            setPublish(bookVO.getB_publish());
            setInfo(bookVO.getB_info());
            setImg(bookVO.getB_img());
        }

    }

    public void initDisplay(){
        //JPanel은 디폴트가 FlowLayout 입니다. 여기서는 좌표값으로 배치한다.
        jp_south.setLayout(new FlowLayout(FlowLayout.RIGHT));
        jb_save.addActionListener(this);
        jb_close.addActionListener(this);
        jbtn_file.addActionListener(this); //파일 찾기 버튼 이벤트소스와 이벤트 처리 클래스 연결하기
        jp_center.setLayout(null);
        jp_south.add(jb_save);
        jp_south.add(jb_close);

        jlb_title.setBounds(20, 20, 100, 20);
        jtf_title.setBounds(120, 20, 300, 20);
        jlb_author.setBounds(20, 45, 100, 20);
        jtf_author.setBounds(120, 45, 150, 20);
        jlb_publish.setBounds(20, 70, 100, 20);
        jtf_publish.setBounds(120, 70, 200, 20);
        jlb_info.setBounds(20, 95, 100, 20);
        jsp_info.setBounds(120, 95, 300, 120);
        jbtn_file.setBounds(20, 220, 90, 20);
        jtf_file.setBounds(120, 220, 300, 20);
        jlb_img.setBorder(BorderFactory.createEtchedBorder());
        jlb_img.setBounds(120, 245, 300, 380);
        //jlb_img.setIcon(new ImageIcon(path+"1.jpg"));
        jp_center.add(jlb_title);
        jp_center.add(jtf_title);
        jp_center.add(jlb_author);
        jp_center.add(jtf_author);
        jp_center.add(jlb_publish);
        jp_center.add(jtf_publish);
        jp_center.add(jlb_info);
        jp_center.add(jsp_info);
        jp_center.add(jbtn_file);
        jp_center.add(jtf_file);
        jp_center.add(jlb_img);

        this.add("South", jp_south);
        this.add("Center", jsp);
        this.setSize(500,700);
        this.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == jbtn_file){ //파일 찾기 버튼 누른거야
            //[열기] 대화상자를 오픈한다.
            //경로를 줄 때 상대경로[그대로 재사용이 가능하다.]와 절대경로가 있다.[처음부터 끝까지 다주는 것 - 경로를 일일이 바꾼다.]
            chooser.setCurrentDirectory(new File("D:\\Java\\workspace_java\\basic1\\src"));
            int intRet = chooser.showOpenDialog(this);
            //yes나 ok버튼을 누른경우 처리하기
            if (intRet == JFileChooser.APPROVE_OPTION){
                //파일을 여는 처리를 한다.
                //파일과 관련된 처리도 경로가 안 맞는 경우이거나 파일에 문제가 있을 수 있어
                //반드시 예외처리를 하도록 강제하고 있습니다.
                try {
                    File file = chooser.getSelectedFile();
                    //선택한 파일의 절대경로를 통해서 BufferedReader 객체를 작성
                    BufferedReader myReader = new BufferedReader(new FileReader(file.getAbsoluteFile()));
                    //System.out.println(file.getAbsoluteFile());
                    String cpath = file.getAbsolutePath();
                    jtf_file.setText(cpath);
                    /////////////// 이미지 미리보기 시작 //////////////////////
                    ImageIcon icon = new ImageIcon(cpath);
                    Image originalImg = icon.getImage();
                    Image changeImg = originalImg.getScaledInstance(300,400,Image.SCALE_SMOOTH);
                    ImageIcon changeIcon = new ImageIcon(changeImg);
                    jlb_img.setIcon(changeIcon);
                    //revalidate()는 새 구성요소가 추가되거나 이전 구성요서가 제거되면
                    //컨테이너에서 호출됩니다.
                    //이 호출은 레이아웃 관리자에게 새 구성요소 목록을 기반으로 재설정하도록
                    //지시하는 명령입니다.
                    cont.revalidate();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
        else if (obj == jb_close) {
            this.dispose();
        }

        else if(obj == jb_save){
            //너 입력이야?
            if (bvo == null){//
                BookVO_11_04 pbvo = new BookVO_11_04();
                pbvo.setB_name(getB_title());
                pbvo.setB_author(getAuthor());
                pbvo.setB_publish(getPublish());
                pbvo.setB_info(getInfo());
                pbvo.setB_img(getImg());
                int result = bdao.bookInsert(pbvo);
                if (result == 1){
                    BookVO_11_04 bvo = new BookVO_11_04();
                    bvo.setB_no(0);
                    bvo.setGubun("전체");
                    bvo.setKeyword("");
                    ba.refreshData(bvo);
                }
            }

            //너 수정이니?
            else {
                System.out.println("수정하기 진행 사용자가 선택한 도서 번호 : " + bvo.getB_no());
                BookVO_11_04 pbvo = new BookVO_11_04();
                //화면으로 부터 입력받는 값이 아니라 set호출시 3번째 인자로 넘어온
                //그 번호가 사용자가 수정하려는 번호입니다.
                pbvo.setB_no(bvo.getB_no());
                pbvo.setB_name(getB_title());
                pbvo.setB_author(getAuthor());
                pbvo.setB_publish(getPublish());
                pbvo.setB_info(getInfo());
                int result = bdao.bookUpdate(pbvo);
                if (result == 1){ //수정이 성공했을 때
                    BookVO_11_04 bvo = new BookVO_11_04();
                    bvo.setB_no(0);
                    bvo.setGubun("전체");
                    bvo.setKeyword("");
                    ba.refreshData(bvo);
                }
            }
            BookVO_11_04 bvo = new BookVO_11_04();
            bvo.setB_no(0);
            bvo.setGubun("전체");
            bvo.setKeyword("");
            ba.refreshData(bvo);
            this.setVisible(false);
        }

    }

    //각 컬럼의 값들을 설정하거나 읽어오는 getter/setter메소드 입니다.
    public String getB_title() { //도서 이름
        return jtf_title.getText();
    }

    public void setB_title(String title) {
        jtf_title.setText(title);
    }

    public String getAuthor() { //저자
        return jtf_author.getText();
    }

    public void setAuthor(String author) {
        jtf_author.setText(author);
    }

    public String getPublish() { //출판사
        return jtf_publish.getText();
    }

    public void setPublish(String publish) {
        jtf_publish.setText(publish);
    }

    public String getInfo() { //도서 소개
        return jta_info.getText();
    }

    public void setInfo(String info) {
        jta_info.setText(info);
    }

    public String getImg(){
        //Path 객체 생성 - 메서드로 생성하기 가능하다(증상)
        Path path = Paths.get(jtf_file.getText());
        //파일명 추출
        String fileName = path.getFileName().toString();
        //팡일명 추출 - src/image/book/1.jpg, 2.jpg, 3.jpg
        System.out.println("파일명" + fileName);
        return fileName;
    }

    public void setImg(String img){
        ImageIcon icon = new ImageIcon(path + img);
        //이미지가 300 * 400보다 커서 스케일을 조정합니다.
        //원본 이미지 아이콘에 이미지 객체 추출
        Image originalImg = icon.getImage();
        //추출된 이미지의 크기를 조절하여 새로운 Image객체 생성하기
        Image changeImg = originalImg.getScaledInstance(300,400,Image.SCALE_SMOOTH);
        //새로운 이미지로 이미지 아이콘 객체를 생성하기
        ImageIcon scaleIcon = new ImageIcon(changeImg);
        jlb_img.setIcon(scaleIcon);
    }

    public static void main(String[] args) {
        new BookDialog_11_04(null);
    }
}
