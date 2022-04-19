package resource;

import java.util.HashMap;
import java.util.Scanner;

public interface R {
	
	Scanner scan = new Scanner(System.in);
	
	HashMap<String, Object> intent = new HashMap<String, Object>();
	
	String menu[] = {"menu", "input", "output", "search", "modify", "delete", "end"};
	String viewName[] = {"MENU", "RESISTRY", "LIST", "SEARCH", "MODIFY", "DELETE", "END"};
}
