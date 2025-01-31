package athread_10_21.talk3_10_28;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrom_10_28 extends JFrame implements ActionListener {
	//선언부
	String imgPath = "D:\\workspace_java\\basic1\\src\\image\\talk\\";
	//JPanel에 쓰일 이미지 아이콘
	ImageIcon img = new ImageIcon(imgPath + "main.png");
	JLabel jlb_id = new JLabel("아이디");
	JLabel jlb_pw = new JLabel("패스워드");
	Font font = new Font("휴먼매직체", Font.BOLD, 16);
	JTextField jtf_id = new JTextField("tomato");
	JPasswordField jpf_pw = new JPasswordField("123");
	JButton btn_login = new JButton(new ImageIcon(imgPath + "login.png"));
	JButton btn_join = new JButton(new ImageIcon(imgPath + "confirm.png"));
	TalkDao_10_31 tDao = new TalkDao_10_31();
	String nickName = null;
	//생성자
	public LoginFrom_10_28() {
		System.out.println("LoginForm 디폴트 생성자");
		initDisplay();
	}

	//JPanel은 다양한 컴포넌트(독릭적인 역학을 하는 클래스 : 버튼, 라디오버튼, 테스트에리어 등등)을 담을 수 있다.
	class Mypanel extends JPanel {
		//컴포넌트가 그려질 때 호출되는 메서드, 패널에 맞춤형 그래픽을 그릴 수 있다.
		public void paintComponent(Graphics g) {
			//이미지를 패널의 (0,0)위치에 그려준다.
			g.drawImage(img.getImage(), 0,0,null);
			setOpaque(false); //패널의 배경을 투명하게 설정한다.

			//super는 상위 클래스를 가리키는 수정자 입니다.
			super.paintComponent(g); //이미지처리는 개발자가 호출만 할 수 있고 내부적으로 처리가 된다.
		}
	}

	//화면처리부
	public void initDisplay(){
		System.out.println("initDisplay 호출");
		btn_login.addActionListener(this);
		btn_join.addActionListener(this);
		setContentPane(new Mypanel());
        /*여기서는 this가 JFrame인데 디폴트 레이아웃이 BorderLayout이라서
        동서남북중앙 이렇게 배치되므로 좌표값 으로 하나하나 배치하려면
        디폴트로 잡혀있는 레이아웃을 파괴해 주어야 합니다. 그래서 null을 줍니다.*/
		this.setLayout(null);
		//아이디 라인
		jlb_id.setBounds(45,200,80,40);
		jlb_id.setFont(font);
		jtf_id.setBounds(110,200,185,40);
		this.add(jlb_id);
		this.add(jtf_id);

		//비밀번호 라인
		jlb_pw.setBounds(45,240,80,40);
		jlb_pw.setFont(font);
		jpf_pw.setBounds(110,240,185,40);
		this.add(jlb_pw);
		this.add(jpf_pw);

		//로그인 버튼 라인 추가
		btn_login.setBounds(175,330,120,40);
		this.add(btn_login);

		//회원가입 버튼 라인 추가
		btn_join.setBounds(45,330,120,40);
		this.add(btn_join);
		this.setLocation(800,250);
		this.setSize(350,600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}


	//메인메서드
	public static void main(String[] args) {
		//오늘은 메인메서드 내에서 initDisplay를 호출하지 않고
		//생성자 안에서 호출합니다. 따라서 인스턴스 변수가 필요없다.
		new LoginFrom_10_28();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		//로그인
		if (obj == btn_login) {
			if ("".equals(jtf_id.getText()) || "".equals(jpf_pw.getText())) {
				JOptionPane.showMessageDialog(this, "아이디와 비밀번호를 확인하세요.","INFO",JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			try{
				String mem_id = jtf_id.getText();
				String mem_pw = jpf_pw.getText();
				String mem_nick = tDao.login(mem_id, mem_pw);
				if ("비밀번호가 맞지 않습니다.".equals(mem_nick)) {
					JOptionPane.showMessageDialog(this, "비밀번호가 맞지 않습니다.");
					jpf_pw.setText("");
					return;
				}
				if ("아이디가 존재하지 않습니다.".equals(mem_nick)) {
					JOptionPane.showMessageDialog(this, "아이디가 존재하지 않습니다.");
					jpf_pw.setText("");
					return;
				}
				else{
					nickName = mem_nick;
					System.out.println("오라클 서버에서 받아온 대화명 =====> " + nickName);
					this.setVisible(false);
					jtf_id.setText("");
					jpf_pw.setText("");
					/*로그인 성공시 파라미터로 LoginForm 주소번지를 넘겨서
					멤버변수들을 사용할 수 있도록 조치한다.
					@TO_DO this를 추가한 생성자 추가 할것.
					LoginForm을 통해서 아이디와 비밀번호를 입력 받고
					TalkDao의 login메서드 호출시 입력받은 아이디와 비번을 파라미터로 넘긴다.
					오라클 서버가 처리하고 응답으로 nickName을 넘겼다.
					이렇게 받은 대화명은 이 어플이 유지되는 동안에 계속 같은 값을 가져야 한다.
					DB연동을 LoginForm에서 요청하였고 그가 응답을 받았다. 그정보를 클라이언트에게 넘긴다.
					그러게 하려면 멤버변수이므로 주소번지를 넘겨야 한다.(얕은복사)
					원본이므로 LoginForem에서 nickName을 출력하거나 TalkCilent에서 출력하거나 같아야 한다. - 공유 - this - 생성자 파라미터*/
					TalkClient_10_28 tc = new TalkClient_10_28(this);
				}
			} catch (Exception ex) {
                throw new RuntimeException(ex);
            }

        }
		//회원가입
		else if (obj == btn_join) {
			JOptionPane.showMessageDialog(this, "회원가입 요청","ERROR",JOptionPane.ERROR_MESSAGE);

		}
	}
}