package classes_10_17.ui_10_18.table_10_30;

import model_10_28.vo_10_28.Notice1030_10_30;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultTextUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Table1_10_30 extends JFrame implements ActionListener, MouseListener {
    JButton jbtn_sel = new JButton("조회");
    String[] headers = {"번호", "제목", "작성자"};
    DefaultTableModel dtm = new DefaultTableModel(headers, 0);
    JTable table = new JTable(dtm);
    JScrollPane jsp = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

    public Table1_10_30() {
        initDisplay();
    }

    public void initDisplay() {
        jbtn_sel.addActionListener(this);
        table.addMouseListener(this);
        this.add("South", jbtn_sel);
        this.add("Center", jsp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,400);
        this.setVisible(true);

    }

    public static void main(String[] args) {
        new Table1_10_30();
    }

    public List<Notice1030_10_30> getnoticeList(){
        List<Notice1030_10_30> nList = new ArrayList<>();
        Notice1030_10_30 no = new Notice1030_10_30();
        no.setN_no(1);
        no.setN_title("제목1");
        no.setN_writer("난신입");
        nList.add(no);
        no = new Notice1030_10_30();
        no.setN_no(2);
        no.setN_title("제목2");
        no.setN_writer("난초보");
        nList.add(no);
        no = new Notice1030_10_30();
        no.setN_no(3);
        no.setN_title("제목3");
        no.setN_writer("난일등");
        nList.add(no);
        return nList;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == jbtn_sel) {
            List<Notice1030_10_30> nList = getnoticeList();
            for (int i = 0; i < nList.size(); i++) {
                Notice1030_10_30 nvo = nList.get(i);
                Vector<Object> oneRow = new Vector<>();
                oneRow.add(nvo.getN_no());
                oneRow.add(nvo.getN_title());
                oneRow.add(nvo.getN_writer());
                dtm.addRow(oneRow);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getClickCount() == 1){
            System.out.println("더블 클릭한 거다.");
            int[] index = table.getSelectedRows();
            if(index.length == 0){
                JOptionPane.showMessageDialog(this,"조회할 데이터를 선택하시오.");
                return;
            }
            else if (index.length > 1){
                JOptionPane.showMessageDialog(this,"데이터를 한건만 선택하시오.");
                return;
            }
            else {
                int no = (Integer)dtm.getValueAt(index[0], 0);
                String title = (String)dtm.getValueAt(index[0], 1);
                String writer = (String)dtm.getValueAt(index[0], 1);
                System.out.println(no + ", " + title + ", " + writer);
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
