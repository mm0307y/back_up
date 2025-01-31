package classes_10_17.step1_10_21;

import classes_10_17.levelup_10_17.NoticeMain_10_17;

import javax.swing.*;

public class NoticeDialog_10_21 extends JDialog {
    NoticeMain_10_17 nm = null; //꼭 null로 한다.(다른 방법으로 접근하더라도 결국 문제가 발생한다.)

    public NoticeDialog_10_21() {
    }

    public NoticeDialog_10_21(NoticeMain_10_17 nm) {
        this.nm = nm; //이 코드를 적지 않으면 다른 메서드에서 nm사용시 NullPointerException발생한다.
    }

    public void initDisplay() {
        this.setSize(400, 400);
        this.setVisible(true);
    }

    /*
    public static void main(String[] args) {
        NoticeDialog_10_21 nd = new NoticeDialog_10_21();
        nd.initDisplay(); //main에서 화ㅏ면을 그리는 메서드를 호출하지 않는다.
    }
}
    그렇다면(main에서 initDisplay를 호출하지 않으면) 어디서 해야 하나?*
    답은 생성자 안에서 호출할것*/
}
