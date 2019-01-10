package webservices;


import java.util.Map;


public class WebServiceCommunictor {

	static final String TAG = "com.android.client.webservice.WebServiceCommunicator";
	public String webrespjson;
	public WebService webService;
	

	public WebServiceCommunictor( String webServiceURL) {
	
		webService = new WebService(webServiceURL);
	}

	public String invokeMethod(String methodName, Map<String, String> params) {
		
		
		try {
			webrespjson = webService.webInvoke(methodName, params);
		}
		catch (Exception e) {
			
		}
		return webrespjson;
	}


}
