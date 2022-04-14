package saram_Controller;

import java.util.HashMap;

import saram_service.DeleteServiceImpl;
import saram_service.EndServiceImpl;
import saram_service.InsertServiceImpl;
import saram_service.SelectAllServiceImpl;
import saram_service.SelectOneServiceImpl;
import saram_service.Service;
import saram_service.UpdateServiceImpl;

public class saram_Service_Factory {
	
	static HashMap<String, Service> to_Service = new HashMap<String, Service>();
	static {
		to_Service.put("input", new InsertServiceImpl());
		to_Service.put("list", new SelectAllServiceImpl());
		to_Service.put("detail", new SelectOneServiceImpl());
		to_Service.put("update", new UpdateServiceImpl());
		to_Service.put("delete", new DeleteServiceImpl());
		to_Service.put("end", new EndServiceImpl());
	}
	
	public static Service get(String param) {
		// System.out.println(param);			// 정상 출력 확인
		return to_Service.get(param);
	}
}
