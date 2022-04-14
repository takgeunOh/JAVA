package saram_Controller;
import java.util.HashMap;

import saram_Resource.resource;
import saram_View.DeleteView;
import saram_View.EndView;
import saram_View.InputView;
import saram_View.ListView;
import saram_View.MenuView;
import saram_View.ModifyView;
import saram_View.SearchView;
import saram_View.View;

// View ��ü�� ã�� ���� ����
public class viewResolver implements resource {
	
	static HashMap<String, View> viewMapper = new HashMap<String,View>();
	static {
		viewMapper.put("menu", new MenuView());
		viewMapper.put("input", new InputView());		
		viewMapper.put("list", new ListView());
		viewMapper.put("detail", new SearchView());
		viewMapper.put("update", new ModifyView());
		viewMapper.put("delete", new DeleteView());
		viewMapper.put("end", new EndView());
	}
	
	public static void dispatcher(String viewName) {
		// System.out.println("viewName : " + viewName);
		View view = viewMapper.get(viewName);
		// View view = new ListView();
		view.display(viewTitle[(Integer)intent.get("number")]);
		// "number" Ű������ �ְ� ��� ������ ���̴ϱ�
		// viewTitle ���ڸ� ���� �� �ֵ���
	}
}
