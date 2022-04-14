package saram_Resource;

import java.util.HashMap;
import java.util.Scanner;

public interface resource {
	Scanner scan = new Scanner(System.in);
	HashMap<String, Object> intent = new HashMap<String, Object>();
	
	String[] menuArr = {"menu", "input", "list", "detail", "update", "delete", "end"};
	String[] viewTitle = {"MENU", "INPUT", "OUTPUT", "SEARCH", "MODIFY", "DELETE", "END"};
}