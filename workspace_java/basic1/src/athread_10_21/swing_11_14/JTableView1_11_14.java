package athread_10_21.swing_11_14;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class JTableView1_11_14 extends JFrame {
    String imgPath = "D:\\Java\\workspace_java\\basic1\\src\\image\\profile\\";
    DefaultTableModel dtm_friend = null;
    JTable jtb_friend = null;
    JScrollPane jsp_friend = null;

    public JTableView1_11_14() {
        initDisplay();
    }

    public void initDisplay() {
        // 테이블 모델 생성 및 이미지 추가
        dtm_friend = new DefaultTableModel(new Object[]{"Image", "Text"}, 0 );
        dtm_friend.addRow(new Object[]{resizeImage(new ImageIcon(imgPath + "profileicon1.jpg"), 80,80), new JLabel("Label1")});
        dtm_friend.addRow(new Object[]{resizeImage(new ImageIcon(imgPath + "profileicon2.jpg"),80,80), new JLabel("Label2")});
        dtm_friend.addRow(new Object[]{resizeImage(new ImageIcon(imgPath + "profileicon3.jpg"), 80,80), new JLabel("Label3")});
        dtm_friend.addRow(new Object[]{resizeImage(new ImageIcon(imgPath + "agu.png"), 80,80), new JLabel("Label4")});
        dtm_friend.addRow(new Object[]{resizeImage(new ImageIcon(imgPath + "agu1.png"), 80,80), new JLabel("Label5")});
        dtm_friend.addRow(new Object[]{resizeImage(new ImageIcon(imgPath + "btnicon.jpg"), 80,80), new JLabel("Label6")});

        jtb_friend = new JTable(dtm_friend);
        jtb_friend.getColumnModel().getColumn(0).setCellRenderer(new ImageLabelRenderer());
        jtb_friend.getColumnModel().getColumn(1).setCellRenderer(new ImageLabelRenderer());
        jtb_friend.setRowHeight(100);
        jsp_friend = new JScrollPane(jtb_friend);

        this.add("Center", jsp_friend);
        this.setSize(500, 500);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    //JTable  cell에 그려질 이미지 크기 변경하기
    public static ImageIcon resizeImage(ImageIcon image, int width, int height) {
        Image img = image.getImage();//new사용하지 않고 객체 생성하기
        Image resizedImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImg);
    }


    static class ImageLabelRenderer extends JLabel implements TableCellRenderer {
        ImageLabelRenderer() {
            setOpaque(true);
            setHorizontalAlignment(CENTER);
            setVerticalAlignment(CENTER);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (value instanceof ImageIcon) {
                setIcon((ImageIcon) value);
                setText("");
                setBackground(new Color(255, 237, 200));
            }
            else if (value instanceof JLabel) {
                JLabel label = (JLabel) value;
                setText(label.getText());
                setIcon(label.getIcon());
                setHorizontalAlignment(LEFT);
            }
            else {
                setText(value != null ? value.toString() : "");
                setIcon(null);
            }
            if (isSelected) {
                setBackground(new Color(255, 237, 200));
            }
            else {
                setBackground(Color.WHITE);
            }
            return this;
        }
    }

    public static void main(String[] args) {
        new JTableView1_11_14();
    }

}

