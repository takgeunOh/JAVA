package resource;

// ���� �޴��̸�, ��Ÿ��Ʋ, ��������ó�� ����� �ؽø� intent ���
import java.util.HashMap;
import java.util.Scanner;

public interface Resource {
	Scanner scan = new Scanner(System.in);
	HashMap<String, Object> intent = new HashMap<String, Object>();
	
	String[] menuItem = {"menu", "input", "output", "search", "modify", "delete", "end"};
	String[] viewTitle = {"MENU", "INPUT", "OUTPUT", "SEARCH", "MODIFY", "DELETE", "END"};
}