package jdbc_10_24.book_11_04;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class BookNaverSearch_11_07 extends JDialog implements ActionListener, ItemListener {
    BookApp_11_04 ba = null;
    JPanel jp_north = new JPanel();
    String[] starts = {"시작위치", "1", "2", "3", "4", "5"};
    String[] displays = {"검색결과", "10", "20", "30", "40", "50"};
    String[] cols = {"도서번호", "도서명", "저자", "출판사"};

    JTextField jtf_keyword = new JTextField(40);
    JComboBox jcb_starts = new JComboBox(starts);
    JComboBox jcb_displays = new JComboBox(displays);
    int start = 0;
    int display = 0;

    String[][] data = new String[0][4];
    DefaultTableModel dtm_book = new DefaultTableModel(data, cols);
    JTable jtb_book = new JTable(dtm_book);
    JScrollPane jsp_book = new JScrollPane(jtb_book, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

    String clientId = "xsEQ9EfmRwjEwaFdNOxj"; //애플리케이션 클라이언트 아이디
    String clientSecret = "xwfk5kymj0"; //애플리케이션 클라이언트 시크릿
    String apiURL = "https://openapi.naver.com/v1/search/book.json";
    public BookNaverSearch_11_07() {

    }

    public BookNaverSearch_11_07(BookApp_11_04 ba) {
        this.ba = ba;
        initDisplay();
    }

    public void refreshData(List<Map<String, Object>> list) {
        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> rMap = list.get(i);
            Vector<Object> v = new Vector<>();
            v.add(rMap.get("isbn"));
            v.add(rMap.get("title"));
            v.add(rMap.get("author"));
            v.add(rMap.get("publisher"));
            dtm_book.addRow(v);
        }
    }

    public List<Map<String, Object>> searchBooks(String query, int start, int display) {
        List<Map<String, Object>> list = null;
        if (start == 0 || display == 0) {
            start = 1;
            display = 10;
        }

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(apiURL + "?query=" + query + "&start=" + start + "&display=" + display)
                .addHeader("X-Naver-Client-Id", clientId)
                .addHeader("X-Naver-Client-Secret", clientSecret)
                .build();
        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                String json = response.body().string();
                Gson gson = new Gson();
                //JSON응답에서 items 배열만 추출하여 List<Map<String,Object>>형태로 변환
                java.lang.reflect.Type listType = new TypeToken<List<HashMap<String, Object>>>() {
                }.getType();
                Map<String, Object> resultMap = gson.fromJson(json, Map.class);
                list = gson.fromJson(gson.toJson(resultMap.get("items")), listType);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public void initDisplay() {
        //System.out.println("initDisplay");
        //System.out.println(this.ba); //null
        jtf_keyword.addActionListener(this);
        jcb_starts.addItemListener(this);
        jcb_displays.addItemListener(this);
        jp_north.add(jtf_keyword);
        jp_north.add(jcb_starts);
        jp_north.add(jcb_displays);
        this.add("North", jp_north);
        this.add("Center", jsp_book);
        this.add(jsp_book);
        this.setSize(700, 500);
        this.setVisible(false);
    }

    public static void main(String[] args) {
        new BookNaverSearch_11_07(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        String query = jtf_keyword.getText();
        if (obj == jtf_keyword) {
            List<Map<String, Object>> list = searchBooks(query,start,display);
            //dtm의 로우 수가 0q보다 크ㅡ다는건 조회결과가 있다.
            //이전에 처리된 내용은 삭제 처리하기
            while (dtm_book.getRowCount() > 0) {
                dtm_book.removeRow(0);
            }
            refreshData(list);
            jtf_keyword.setText("");
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        Object obj = e.getSource();
        if (obj == jcb_starts) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                if (!"시작위치".equals(starts[jcb_starts.getSelectedIndex()])) {
                    start = Integer.parseInt(starts[jcb_starts.getSelectedIndex()]);
                }
                System.out.println("선택한 컬럼명은 " + start);
            }
        } else if (obj == jcb_displays) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                if (!"검색결과".equals(displays[jcb_displays.getSelectedIndex()])) {
                    display = Integer.parseInt(displays[jcb_displays.getSelectedIndex()]);
                }
                System.out.println("선택한 컬럼명은 " + display);

            }
        }
    }
}
