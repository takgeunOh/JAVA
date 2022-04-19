package siat.card.GUI;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import siat.card.model.CardDao;
import siat.card.model.CardDto;

// 디폴트 배치관리자 정리
// JFrame, JDialog : BorderLayout
// JPanel : FlowLayout

public class test_GUI_takgeun2 extends JFrame {

	private int rowCount = 0; // 조회할 때 rowCount 구하기

	public test_GUI_takgeun2() {

		setTitle("Bank");
		setSize(700, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// 컨텐트팬 찾기
		Container c = getContentPane();

		// 왼쪽 큰 패널 세팅
		JPanel p_west = new JPanel();
		p_west.setBorder(new TitledBorder(new LineBorder(Color.black, 1), "입력"));
		p_west.setPreferredSize(new Dimension(300, 480));

		// 오른쪽 큰 패널 세팅
		JPanel p_east = new JPanel();
		p_east.setBorder(new TitledBorder(new LineBorder(Color.black, 1), "출력"));
		p_east.setPreferredSize(new Dimension(1000, 480));

		// 카드명 객체 모음
		JPanel cardNameWrap = new JPanel();
		JPanel cardNameLabelWrap = new JPanel();
		JPanel cardNametfWrap = new JPanel();
		JLabel cardNameLabel = new JLabel("카드명");
		JTextField cardNametf = new JTextField("카드명 입력", 10);
		// JTextField
		// 텍스트 입력 도중 <ENTER> 키가 입력되면 Action 이벤트 발생
		// 입력 가능한 문자 개수와 입력 창의 크기는 서로 다름
		// 오른쪽 파라미터는 입력창의 열의 개수
		cardNameLabel.setPreferredSize(new Dimension(100, 50));

		// 카드구분
		JPanel cardTypeWrap = new JPanel();
		JPanel cardTypeLabelWrap = new JPanel();
		JPanel cardTypeBoxWrap = new JPanel();
		JPanel cardTypePanel1 = new JPanel();
		JPanel cardTypePanel2 = new JPanel();
		JLabel cardTypeLabel = new JLabel("카드구분");
		JCheckBox cardType1 = new JCheckBox("신용카드");
		JCheckBox cardType2 = new JCheckBox("체크카드");
		ButtonGroup cardTypeGr = new ButtonGroup();

		// 연회비
		JPanel annualFeeWrap = new JPanel();
		JPanel annualFeeLabelWrap = new JPanel();
		JPanel annualFeetfWrap = new JPanel();
		JLabel annualFeeLabel = new JLabel("연회비");
		JTextField annualFeetf = new JTextField("연회비 입력", 14);
		annualFeeWrap.setBorder(new TitledBorder(new LineBorder(Color.RED)));

		// 카드실적
		JPanel cardRecordWrap = new JPanel();
		JPanel cardRecordLabelWrap = new JPanel();
		JPanel cardRecordtfWrap = new JPanel();
		JLabel cardRecordLabel = new JLabel("카드실적");
		JTextField cardRecordtf = new JTextField("", 14);
		cardRecordWrap.setBorder(new TitledBorder(new LineBorder(Color.BLUE)));

		// 카드혜택
		JPanel cardBenefitWrap = new JPanel();
		JPanel cardBenefitLabelWrap = new JPanel();
		JPanel cardBenefitareaWrap = new JPanel();
		JLabel cardBenefitLabel = new JLabel("카드혜택");
		GridBagLayout gb = new GridBagLayout();
		setLayout(gb);
		JTextArea cardBenefitarea = new JTextArea(50, 20);
		// JTextArea의 파라미터는 row, column 이 있으니까 크기 조정할거면 이걸 써먹자.
		// 각각의 row, column은 각각의 개수로 생각하면 됨.
		JScrollPane cardBenefitpane = new JScrollPane(cardBenefitarea);

		// 테이블 세팅
		String[] colNames = new String[] { "번호", "카드명", "카드구분", "연회비", "카드실적", "카드혜택" };
		DefaultTableModel model = new DefaultTableModel(colNames, 0);
		JTable table = new JTable(model);
		JScrollPane tabscrollPane = new JScrollPane(table);

		// 하단 버튼 객체 모음
		JPanel btnWrap = new JPanel();
		JButton createBtn = new JButton("카드생성");
		JButton deleteBtn = new JButton("카드삭제");
		JButton statusBtn = new JButton("카드등록현황");
		JButton allDelBtn = new JButton("전체삭제");

		// 객체 세팅 모음
		cardNameLabel.setPreferredSize(new Dimension(100, 50));

		// 배치관리자 세팅 모음

		c.setLayout(new BorderLayout());
		p_west.setLayout(new GridLayout(6, 2)); // 단위테스트하면서 행수를 늘릴 것. (최종적으로 6행이 되어야함.)
		cardNameWrap.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 10));
		cardTypeWrap.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 10));
		cardTypeBoxWrap.setLayout(new FlowLayout(FlowLayout.CENTER, 1, 20));
		annualFeeWrap.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 20));
		cardRecordWrap.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 20));
		cardBenefitWrap.setLayout(new GridLayout(3, 1));

		btnWrap.setLayout(new GridLayout(1, 4));

		// 카드명 배치
		cardNameLabelWrap.add(cardNameLabel);
		cardNametfWrap.add(cardNametf);
		cardNameWrap.add(cardNameLabelWrap);
		cardNameWrap.add(cardNametfWrap);
		p_west.add(cardNameWrap);

		// 카드구분 배치
		cardTypeGr.add(cardType1);
		cardTypeGr.add(cardType2);
		cardTypePanel1.add(cardType1);
		cardTypePanel2.add(cardType2);
		cardTypeBoxWrap.add(cardTypePanel1);
		cardTypeBoxWrap.add(cardTypePanel2);
		cardTypeLabelWrap.add(cardTypeLabel);
		cardTypeWrap.add(cardTypeLabelWrap);
		cardTypeWrap.add(cardTypeBoxWrap);
		p_west.add(cardTypeWrap);

		// 연회비 배치
		annualFeeLabelWrap.add(annualFeeLabel);
		annualFeetfWrap.add(annualFeetf);
		annualFeeWrap.add(annualFeeLabelWrap);
		annualFeeWrap.add(annualFeetfWrap);
		p_west.add(annualFeeWrap);

		// 카드실적 배치
		cardRecordLabelWrap.add(cardRecordLabel);
		cardRecordtfWrap.add(cardRecordtf);
		cardRecordWrap.add(cardRecordLabelWrap);
		cardRecordWrap.add(cardRecordtfWrap);
		p_west.add(cardRecordWrap);

		// 카드혜택 배치
		cardBenefitLabelWrap.add(cardBenefitLabel);
		cardBenefitareaWrap.add(cardBenefitpane);
		cardBenefitarea.setBorder(new LineBorder(Color.GREEN));
		cardBenefitWrap.add(cardBenefitLabelWrap);
		cardBenefitWrap.add(cardBenefitareaWrap);
		cardBenefitWrap.setBorder(new LineBorder(Color.BLUE));
		p_west.add(cardBenefitWrap);

		// 테이블 배치
		p_east.add(tabscrollPane, BorderLayout.CENTER);

		// 하단 버튼 배치
		btnWrap.add(createBtn);
		btnWrap.add(deleteBtn);
		btnWrap.add(statusBtn);
		btnWrap.add(allDelBtn);
		btnWrap.setBorder(new TitledBorder(new LineBorder(Color.BLUE)));

		// 컨텐트팬 최종 부착물
		c.add(p_west, BorderLayout.WEST);
		c.add(p_east, BorderLayout.CENTER);
		c.add(btnWrap, BorderLayout.SOUTH);

		// 버튼 이벤트 구현 //
		// 카드 생성 버튼 구현
		createBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 입력된 값 테이블에 추가하기
				// 입력된 값들을 한줄 데이터 덩어리(배열)로 만들어줘야 함
				String[] rows = new String[6];
				rowCount++;

				rows[0] = String.valueOf(rowCount);
				// 임시로 0을 넣을 것. 나중에 전체 조회할 때 인덱스 수를 추출해서 rows[인덱스수] 에 대입하면 될 듯 --> 해결
				rows[1] = cardNametf.getText();
				if (cardType1.isSelected())
					rows[2] = "신용카드";
				else
					rows[2] = "체크카드";
				rows[3] = annualFeetf.getText();
				rows[4] = cardRecordtf.getText();
				rows[5] = cardBenefitarea.getText();

				model.addRow(rows);

				// 입력 후 텍스트 필드값 제거
				cardNametf.setText("");
				annualFeetf.setText("");
				cardRecordtf.setText("");
				cardBenefitarea.setText("");

				// 데이터타입 조율하면서 변수 만든 후 Dao insert 메소드 호출
				int no = Integer.parseInt(rows[0]);
				String cardName = rows[1];
				String cardType = rows[2];
				int annualFee = Integer.parseInt(rows[3]);
				int cardRecord = Integer.parseInt(rows[4]);
				String cardBenefit = rows[5];

				CardDto dto = new CardDto(no, cardName, cardType, annualFee, cardRecord, cardBenefit);
				try {
					CardDao.insert(dto);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		// 카드등록 전체조회 (카드등록현황 버튼)
		statusBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int no, annualFee, cardRecord;
				String cardName, cardType, cardBenefit;
				// ResultSet 객체의 Row 개수 계산
				// 커서의 위치를 제일 뒤로 이동한 뒤 row의 개수를 계산할 것.
				ResultSet rs = CardDao.selectAll();
				String rows[] = new String[6];

				try {
					rs.last(); // 커서의 위치를 맨 뒤로 이동
					rowCount = rs.getRow();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}

				try {
					rs.beforeFirst(); // 커서의 위치를 가장 처음으로 이동 first()보다 이전 공간
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				model.setNumRows(0);
				// 첫 조회 때는 문제가 없지만 계속 조회를 하다보면 행이 추가되면서 조회됨..
				// 뭔가 조회할 때마다 테이블을 리셋해주고 조회해줘야할 것 같다.
				// 솔루션 : setNumRows() 메소드 이용!
				try {
					while (rs.next()) {
						rows[0] = rs.getString("seq_no").toString();
						rows[1] = rs.getString("cardname").toString();
						rows[2] = rs.getString("cardtype").toString();
						rows[3] = rs.getString("annualfee").toString();
						rows[4] = rs.getString("cardrecord").toString();
						rows[5] = rs.getString("profit").toString();

						no = Integer.parseInt(rows[0]);
						cardName = rows[1];
						cardType = rows[2];
						annualFee = Integer.parseInt(rows[3]);
						cardRecord = Integer.parseInt(rows[4]);
						cardBenefit = rows[5];

						model.addRow(rows);
						// 이건 첫 조회 때는 문제가 없지만 계속 조회를 하다보면 행이 추가되면서 조회됨..
						// 뭔가 조회할 때마다 테이블을 리셋해주고 조회해줘야할 것 같다. --> 위에서 해결
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				try {
					rs.beforeFirst();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		// 카드삭제
		deleteBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int rowIndex = table.getSelectedRow();
				if (rowIndex == -1) // 선택 안하고 누르면
					return;
				String selectDel_cardName = (String) table.getValueAt(rowIndex, 1);
				// System.out.println(selectDel_cardName); // 정상출력
				// 카드명은 중복되지 않게 나중에 구현할 것.
				// 그러므로 삭제할 때 카드명을 기준으로 삭제해도 무방할 것 같다.

				CardDto dto = new CardDto();
				dto = CardDao.selectOne(selectDel_cardName);
				// System.out.println(dto.getNo());
				// System.out.println(dto.getCardName());
				CardDao.delete(dto.getNo());

				model.removeRow(rowIndex); // 이건 테이블만 삭제
				// del_no = String.valueOf(rowIndex+1);
			}
		});


		setVisible(true);
	}

	public static void main(String[] args) {

		new test_GUI_takgeun2();

	}

}
