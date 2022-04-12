package resource;

// 여긴 메뉴이름, 뷰타이틀, 전역변수처럼 사용할 해시맵 intent 담기
import java.util.HashMap;
import java.util.Scanner;

public interface Resource {
	Scanner scan = new Scanner(System.in);
	HashMap<String, Object> intent = new HashMap<String, Object>();
	
	String[] menuItem = {"menu", "input", "output", "search", "modify", "delete", "end"};
	String[] viewTitle = {"MENU", "INPUT", "OUTPUT", "SEARCH", "MODIFY", "DELETE", "END"};
}