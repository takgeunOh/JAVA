package test;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.util.ArrayList;

import javax.swing.ButtonGroup;

import javax.swing.JButton;

import javax.swing.JFrame;

import javax.swing.JLabel;

import javax.swing.JPanel;

import javax.swing.JRadioButton;

import javax.swing.JScrollPane;

import javax.swing.JTable;

import javax.swing.JTextField;

import javax.swing.table.DefaultTableModel;

public class test_jihoon extends JFrame {

   ArrayList<MemberVO> members = new ArrayList<MemberVO>();

   public test_jihoon() {

      setTitle("회원 명단 추가삭제 프로그램");
      setDefaultCloseOperation(EXIT_ON_CLOSE);

      setAlwaysOnTop(true);

      setBounds(200, 100, 400, 200);

//      setBounds(1000, 100, 400, 200);

//      setBounds(가로위치, 세로위치, 가로길이, 세로길이);
//      위치를 결정하는건 해당 구성요소의 왼쪽위 꼭지점의 좌표인데요, 
//      왼쪽 버튼을 예로 들면 30, 170이 되겠죠. 그리고 버튼의 가로길이는 122고 세로길이는 30이니까 
//      아래처럼 코딩하면 되겠습니다.
//      btn1.setBounds(30, 170, 122, 30);
//      오른쪽 버튼의 경우에는 가로위치값만 다르겠네요. 30+122+30 해서 182가 되겠습니다.

      // 회원명단추가삭제 프로그램 자체를 보더레이아웃에서 센터와 south를 놓고

      // 표 제목줄
      String[] colNames = new String[] { "Name", "Age", "Gender" };

      // 표에 들어갈 데이터들.. /처음엔 빈 테이블 만들기 위해.. 데이터관리객체 생성
      DefaultTableModel model = new DefaultTableModel(colNames, 0);

      JTable table = new JTable(model);
      JScrollPane scrollPane = new JScrollPane(table);

      add(scrollPane, BorderLayout.CENTER);

      // 테이블 아래쪽에 데이터 입력 할수있는 패널
      JPanel bottomPanel = new JPanel();

      bottomPanel.setLayout(new GridLayout(2, 1));

      JPanel panel = new JPanel();

      JTextField tfName = new JTextField(6);

      JTextField tfAge = new JTextField(3);

      JRadioButton rb1 = new JRadioButton("Female");
      JRadioButton rb2 = new JRadioButton("male");

      JRadioButton rb3 = new JRadioButton();

      ButtonGroup rg = new ButtonGroup();

      rg.add(rb1);
      rg.add(rb2);
      rg.add(rb3);

      rb1.setSelected(true);

      panel.add(new JLabel("NAME"));
      panel.add(tfName);

      panel.add(new JLabel("AGE"));
      panel.add(tfAge);

      panel.add(rb1);
      panel.add(rb2);

      bottomPanel.add(panel);

      ///////////////////////////

      JPanel panel2 = new JPanel();

      JButton btnAdd = new JButton("추가");
      JButton btnDel = new JButton("삭제");

      panel2.add(btnAdd);
      panel2.add(btnDel);

      bottomPanel.add(panel2);

      btnAdd.addActionListener(new ActionListener() {

         @Override

         public void actionPerformed(ActionEvent e) {

            // 입력된 값 테이블에 추가하기

            // 입력된 값들을 한줄 데이터 덩어리(배열)로 만들어줘야 함 ←←←

            String[] rows = new String[3];

            rows[0] = tfName.getText();

            rows[1] = tfAge.getText();

            if (rb1.isSelected())
               rows[2] = "female";

            else
               rows[2] = "male";

            model.addRow(rows); // 한줄단위로만 대입 가능하므로↑↑

            // 입력후 텍스트 필드 값 제거

            tfName.setText("");

            tfAge.setText("");

            rb3.setSelected(true); // 라디오 초기화

            // 어레이 리스트에 멤버 객체 추가

            String name = rows[0];

            int age = Integer.parseInt(rows[1]);

            String gender = rows[2];

            members.add(new MemberVO(name, age, gender));

            System.out.println("회원 숫자:" + members.size());

         }

      });

      // 선택한 줄 지우기

      btnDel.addActionListener(new ActionListener() {

         @Override

         public void actionPerformed(ActionEvent e) {

            // 선택한 줄(row)의 번호 알아내기

            int rowIndex = table.getSelectedRow();

            // 선택 안하고 누를 경우 리턴값 -1

            if (rowIndex == -1)
               return;

            model.removeRow(rowIndex);

            members.remove(rowIndex); // 데이터 지우기

            System.out.println("회원 숫자:" + members.size());

         }

      });

      add(bottomPanel, BorderLayout.SOUTH);

      /////////////////////////////////

//      Container contentPane = getContentPane(); // 컨텐트 팬을 알아낸다.
      JPanel contentPane = new JPanel(); // 컨텐트 팬을 알아낸다.

      
//      contentPane.setBackground(Color.ORANGE); // 컨텐트팬의 배경색을 오렌지색으로 설정

      contentPane.setLayout(new FlowLayout(FlowLayout.RIGHT)); // 컨텐트팬에 FlowLayout 배치관리자 달기

//      contentPane.setAlignmentX(RIGHT_ALIGNMENT);
//      b.setLocation(i*15, i*15); // 버튼의 위치 설정
//      JButton b = new JButton(Integer.toString(i)); // 버튼 생성

//      JLabel la = new JLabel("Hello, Press Buttons!"); 
//      la.setLocation(130, 50); // la를 (130,50) 위치로 지정
//      la.setSize(200, 20); // la를 200x20 크기로 지정 
//      c.add(la); // la를 컨텐트팬에 부착

//      contentPane.add(new JButton("새로고침"));
      // OK 버튼 달기

//      JButton a = new JButton("새로고침");
//      a.setLocation(50,50);
//      contentPane.add(a);

//      contentPane.add(new JButton("검색")); // Cancel 버튼 달기

      JButton b = new JButton("검색");
      // 검색 버튼을 만드는 것

      // 검색 버튼을 누르면 다른 창으로 나오게끔 만들어주는 것
      b.addActionListener(new ActionListener() {

         public void actionPerformed(ActionEvent e) {
//            dispose();
            new init3();

         }

      });
      contentPane.add(b);
      // 검색 버튼을 추가하기

      contentPane.add(new JButton("수정")); // Ignore 버튼 달기
      
      
//      contentPane.add(new JButton("삭제")); // Ignore 버튼 달기
//      contentPane.add(new JButton("저장")); // Ignore 버튼 달기
      contentPane.add(btnAdd);
      contentPane.add(btnDel);

      add(contentPane, BorderLayout.NORTH);

      //////////////////////////////////

      setVisible(true);

   }

   class MemberVO { // 회원 1명 정보 저장하는 클래스 : 오로지 데이터 저장용

      private String name; // VO클래스

      private int age;

      private String gender;

      public MemberVO(String name, int age, String gender) {

         this.name = name;

         this.age = age;

         this.gender = gender;

      }

   }

   public static void main(String[] args) {

      new test_jihoon();

   }

}