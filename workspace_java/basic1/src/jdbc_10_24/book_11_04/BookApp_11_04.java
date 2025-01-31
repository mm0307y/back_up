package jdbc_10_24.book_11_04;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.Vector;

/*
BookDialog에서 수정이나 입력일 때 insert가 1이거나 update도 1이면 성공
이 때 BookApp의 도서 목록 페이지를 새로고침 한다. - 이런 요구사항이 있다면..
BookApp의 메서드를 BookDialog에서 호출 해야 한다.
이 때 부모창의 주소원본을 가져야 한다. (얕은복사)
*/
public class BookApp_11_04 extends JFrame implements ActionListener, ItemListener {
    BookDialog_11_04 bd = new BookDialog_11_04(this);
    BookNaverSearch_11_07 bns = new BookNaverSearch_11_07(this);
    BookDao_11_04 bDao = new BookDao_11_04();
    JMenuBar mb = new JMenuBar();

    JMenu jm_file = new JMenu("File");
    JMenuItem jmi_dbcon = new JMenuItem("DB연결");
    JSeparator se_file = new JSeparator();
    JMenuItem jmi_exit = new JMenuItem("Exit");
    JMenu jm_edit = new JMenu("Edit");

    JMenuItem jmi_all = new JMenuItem("전체조회");
    JMenuItem jmi_ins = new JMenuItem("입력");
    JMenuItem jmi_det = new JMenuItem("상세보기");
    JMenuItem jmi_upd = new JMenuItem("수정");
    JMenuItem jmi_del = new JMenuItem("삭제");
    String imgPath = "D:\\Java\\workspace_java\\basic1\\src\\image\\book\\";
    JToolBar jtBar = new JToolBar();
    JPanel jp_center = new JPanel();
    JPanel jp_center_north = new JPanel();

    String[] gubuns = {"전체", "책제목", "저자", "출판사"};
    String[] cgubuns = {"all", "b_name", "b_author", "b_publish"};
    JComboBox jcb_gubuns = new JComboBox(gubuns); //West
    JTextField jtf_keyword = new JTextField(20);
    JButton jbtn_search = new JButton("검색");

    JButton btn_all = new JButton("전체조회");
    JButton btn_ins = new JButton("입력", new ImageIcon(imgPath + "new.gif"));
    JButton btn_det = new JButton("상세보기", new ImageIcon(imgPath + "detail.gif"));
    JButton btn_upd = new JButton("수정", new ImageIcon(imgPath + "update.gif"));
    JButton btn_del = new JButton("삭제", new ImageIcon(imgPath + "delete.gif"));
    JButton btn_naver = new JButton("네이버도서검색");

    String[] cols = {"도서번호", "도서명", "저자", "출판사"};
    String[][] data = new String[0][4];
    DefaultTableModel dtm_book = new DefaultTableModel(data, cols);
    JTable jtb_book = new JTable(dtm_book);
    JScrollPane jsp_book = new JScrollPane(jtb_book, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    String gubun = null; //b_name, b_author, b_publish

    public BookApp_11_04() {
        initDisplay();
    }

    public void refreshData(BookVO_11_04 pbvo){
        System.out.println("새로고침 호출 " + ", " + pbvo.getKeyword()+", "+pbvo.getGubun());
        List<BookVO_11_04> bList = bDao.getBookList(pbvo);
        //UI 초기화 작업이다 - 초기화
        //전체조회를 누르면 버튼이 비활성 되지 않아서 계속 반복적으로 누를수 있다.
        //그래서 기존에 출력된 정보를 가지고 뒤에 추가되고 있다.
        while (dtm_book.getRowCount() > 0) {
            //0번째를 계속해서 삭제하게 되는데 첫번째가 삭제되고 나면
            //dtm_book의 index 값이 1씩 줄어들게 된다.
            dtm_book.removeRow(0);
        }

        for (int i = 0; i < bList.size(); i++) {
            BookVO_11_04 bvo = bList.get(i); //0, 1, 2, 3, 4, 5 이면 탈출한다.
            Vector<Object> v = new Vector<>();
            v.add(bvo.getB_no());
            v.add(bvo.getB_name());
            v.add(bvo.getB_author());
            v.add(bvo.getB_publish());
            dtm_book.addRow(v);
        }
    }

    //입력일 때 호출 - 입력 버튼 | 입력 메뉴 아이템
    public void insertActionPerformed(){
        System.out.println("입력 버튼 | 입력 메뉴 아이템");
        bd.set("입력", true, null, true);
    }

    //상세보기 일때 호출 - 상세보기 버튼 | 상세보기 메뉴 아이템
    public void detailActionPerformed(){
        System.out.println("상세보기 버튼 | 상세보기 메뉴 아이템");
        int one = -1;
        one = jtb_book.getSelectedRow();
        int b_no = 0;
        b_no = Integer.parseInt(dtm_book.getValueAt(one, 0).toString()); //앞의 자리가 로우 뒤에가 컬럼
        if (one < 0){
            JOptionPane.showMessageDialog(this, "상제조회 할 로우를 선택하세요.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        BookVO_11_04 pbvo = new BookVO_11_04();
        //b_no = 0인 상태
        pbvo.setB_no(b_no); //0이었지만 여기서 값이 바뀐다. 0보다 큰 값으로 변한다.
        List<BookVO_11_04> bList = bDao.getBookList(pbvo);
        //bList = 1
        if (bList.size() == 1){
            BookVO_11_04 bvo = bList.get(0); //사용자가 선택한 로우의 값을 담았다. 난 null이 아니야
            bd.set("상세보기", true, bvo, false);
        }
        else {
            JOptionPane.showMessageDialog(this, "조회결과가 없습니다.","Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
    }

    //수정일 때 호출 - 수정 버튼 | 수정 메뉴 아이템 일 때
    public void updateActionPerformed(){
        System.out.println("수정 버튼 | 수정 메뉴 아이템 일 때");

        int one = -1;
        one = jtb_book.getSelectedRow();
        int b_no = 0; //select문에서 where b_no = ? ?에 들어갈 숫자
        b_no = Integer.parseInt(dtm_book.getValueAt(one, 0).toString()); //앞의 자리가 로우 뒤에가 컬럼
        if (one < 0){
            JOptionPane.showMessageDialog(this, "상제조회 할 로우를 선택하세요.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        BookVO_11_04 pbvo = new BookVO_11_04();
        //b_no = 0인 상태
        pbvo.setB_no(b_no); //0이었지만 여기서 값이 바뀐다. 0보다 큰 값으로 변한다.
        List<BookVO_11_04> bList = bDao.getBookList(pbvo);
        //bList = 1
        if (bList.size() == 1){
            BookVO_11_04 bvo = bList.get(0); //사용자가 선택한 로우의 값을 담았다. 난 null이 아니야
            //4번째 파라미터는 JTextField의 수정 여부를 결정한다.
//            bd.set("상세보기", true, bvo, false); //read only
            bd.set("수정", true, bvo, true);
        }
        else {
            JOptionPane.showMessageDialog(this, "조회결과가 없습니다.","Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

    }

    //삭제 일때 호출 - 삭제 버튼 | 삭제 메뉴 아이템 일 때
    public void deleteActionPerformed(){
        System.out.println("삭제 버튼 | 삭제 메뉴 아이템 일 때");
        //당신이 선택한 로우는 얼마인가요?
        int index[] = jtb_book.getSelectedRows();
        int one = jtb_book.getSelectedRow();
        if (index.length == 0){
            JOptionPane.showMessageDialog(this, "삭제할 로우를 선택하세요.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        else {
            //삭제할 로우를 선택했다면 여기로....
            //delete from book152 where b_no = 5;
            //파라미터가 필요하다. b_no가 필요하다.
            int b_no = 0;
            b_no = Integer.parseInt(dtm_book.getValueAt(one, 0).toString()); //앞의 자리가 로우 뒤에가 컬럼
//            System.out.println("당신이 선택한 로우의 도서 번호 : " + b_no);
            int result = bDao.bookDelete(b_no);
            if (result == 1){ //삭제가 성공하면 1을 반환받고 실패하면 0을 반환 받는다.
                BookVO_11_04 pbvo = new BookVO_11_04();
                pbvo.setB_no(0);
                pbvo.setGubun("전체");
                pbvo.setGubun("");
                refreshData(pbvo);
            }
        }
    }

    public void initDisplay(){
        //북쪽에는 jp_center_north속지, 중앙에는 jsp_book 붙인다.
        jp_center.setLayout(new BorderLayout());
        jp_center_north.setLayout(new BorderLayout());
        jp_center_north.add("West", jcb_gubuns);
        jp_center_north.add("Center", jtf_keyword);
        jp_center_north.add("East", jbtn_search);
        jp_center.add("North", jp_center_north);
        jp_center.add("Center", jsp_book);

        jm_file.add(jmi_dbcon);
        jm_file.add(se_file);
        jm_file.add(jmi_exit);

        jm_edit.add(jmi_all);
        jm_edit.add(jmi_ins);
        jm_edit.add(jmi_det);
        jm_edit.add(jmi_upd);
        jm_edit.add(jmi_del);

        mb.add(jm_file);
        mb.add(jm_edit);


        jcb_gubuns.addItemListener(this);
        jtf_keyword.addActionListener(this);
        jbtn_search.addActionListener(this);

        jmi_exit.addActionListener(this);
        btn_all.addActionListener(this);
        btn_ins.addActionListener(this);
        btn_det.addActionListener(this);
        btn_upd.addActionListener(this);
        btn_del.addActionListener(this);
        btn_naver.addActionListener(this);

        jmi_all.addActionListener(this);
        jmi_ins.addActionListener(this);
        jmi_det.addActionListener(this);
        jmi_upd.addActionListener(this);
        jmi_del.addActionListener(this);

        jtBar.add(btn_all);
        jtBar.add(btn_ins);
        jtBar.add(btn_det);
        jtBar.add(btn_upd);
        jtBar.add(btn_del);
        jtBar.add(btn_naver);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setJMenuBar(mb); //메뉴바는 배치하는 것이 아니고 this에 직접 붙인다.
        this.add("North", jtBar);
        this.add("Center", jp_center);
        this.setSize(700,500);
        this.setVisible(true);

    }

    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        //13번의 멤버는 언제 생성이 되는가? 나 자신데 대한 객체를 생성할 때 초기화 및 생성이 된다.
        BookApp_11_04 ba = new BookApp_11_04();
        //24번이 실행(new 포함한다.)되면
        //A a = null, a = null;
        //선언부에 a는 주소번지 할당이 되기 전이다. null.toString()랑 같다.
        //a = new A() 했을 때 주소번지가 생성된다. 선언과 생성의 차이가 있다.
        //13번에서 this는 24번에 ba 주소번지와 같은 값을 가진다.
        //디폴트 생성자는 없을 때 JVM이 자동으로 생성해 주지만
        //파라미터를 갖는 생성자는 파라미터를 예측할 수 없어서 대신 못해준다. 그래서 개발자가 선언해 줘야 한다.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        //서로 같은 역할을 하는 메뉴 아이템과 버튼에 대해서 하나의 메서드로 설계한다.
        if (obj == btn_naver){
            bns.setVisible(true);
        }

        else if (obj == jtf_keyword || obj == jbtn_search){
            BookVO_11_04 pbvo = new BookVO_11_04();
            pbvo.setGubun(gubun);
            pbvo.setKeyword(jtf_keyword.getText());
            jtf_keyword.setText("");
            refreshData(pbvo);
        }
        else if (obj == jmi_all || obj == btn_all){
            BookVO_11_04 pbvo = new BookVO_11_04();
            pbvo.setB_no(0);
            pbvo.setGubun("전체");
            pbvo.setKeyword("");
            refreshData(pbvo);
        }
        else if(obj == btn_ins || obj == jmi_ins) {
            insertActionPerformed();
        }

        else if (obj == jmi_upd || obj == btn_upd){
            updateActionPerformed();
        }

        else if (obj == jmi_del || obj == btn_del){
            deleteActionPerformed();
        }

        //상세보기 버튼이나 상세보기 아이템을 눌렀을때
        else if (obj == jmi_det || obj == btn_det){
            detailActionPerformed();
        }

        else if (obj == jmi_exit){
            System.exit(0);
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        Object obj = e.getSource();
        if (obj == jcb_gubuns){
            if (e.getStateChange() == ItemEvent.SELECTED){
                //gubun에서 가져오면 책이름, 저자, 출판ㄴ사로 한글 이름이어서 컬럼명이 아니다.
                //선택한 컬럼명에 대한 영문 컬럼명이 필요하다.
                gubun =cgubuns[jcb_gubuns.getSelectedIndex()];
                System.out.println("선택한 컬럼명은 " + gubun); //gubun은 멤버변수로 한다.
            }//콤보박스에서 선택한 갑시 변경되었을 때 인터셉트한다.
        }////end of if
    }////end of itemStateChanged
}
/*
메뉴바 추가하기
툴바 추가하기
같은 메뉴를 메뉴바와 툴바에 모두 추가하여서 메서드 재사용성 구현 실습
같은 메뉴
이벤트 처리를 담당하는 클래스로 설계하기 - ActionListener
삭제는 BookApp.java에서 처리한다.
상세조회 수정, 입력은 BookDialog.java에서 처리한다.
이 중에서 수정하기와 상세조회는 오라클 서버를 경유해야 한다.
왜냐하면 기존에 있는 정보를  수정하거나 상세조회하는 것이므로 조회결과를
화면에 출력해야 한다.
입력은 오라클 서버를 경유하지 않고 BookDialog화면에서  새로 입력받은
정보를 오라클 서버에 입력하는 것이다. (Insert 문을 사용하면된다.)
BookDialog.java와 BookDao.java 사이에서 처리가 진행된다.
BookDialog.java에서 BookDao의  메서드를 호출할 때 사용자가 입력한 값을
파라미터로 넘겨야 하는데 컬럼의 갯수만큼 넘기는 것보다 BookVO주소번지를
하나 넘겨서 그 안에 선언된 멤버변수 값을 insert문에 넣는 것이 더 나은 방법이다.
BookDialog 에서는 BookDao의 인스턴화를 해야 한다.
BookDialog에서 BookDao의 메서드를 호출한다.

*/