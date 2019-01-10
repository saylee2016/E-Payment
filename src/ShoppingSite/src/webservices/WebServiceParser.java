package webservices;


import java.util.Map;
import org.json.JSONObject;





/*import com.java.android.carpooling.Pickup_PointBean;
import com.java.android.carpooling.UserBean;*/

public class WebServiceParser {
	@SuppressWarnings("unused")

	private WebServiceCommunictor wSCommunictor;

	public WebServiceParser(String webServiceURL) {
	
		wSCommunictor = new WebServiceCommunictor( webServiceURL);
	}

	public String payamentRequest(Map<String, String> params) {
		
	
		
		String response = wSCommunictor.invokeMethod("payamentRequest", params);
		String value = null;
		try {
			if (response != null) {

				JSONObject jsonObject = new JSONObject(response);
				value = jsonObject.getString("request");
				
			}
		} catch (Exception e) {
		}
		return value;
	}
	
	
public String otpRequest(Map<String, String> params) {
		
	
		
		String response = wSCommunictor.invokeMethod("otpRequest", params);
		String value = null;
		try {
			if (response != null) {

				JSONObject jsonObject = new JSONObject(response);
				value = jsonObject.getString("otpRequest");
				
			}
		} catch (Exception e) {
		}
		return value;
	}

public String validateLogin(Map<String, String> params) {
		
		String response = wSCommunictor.invokeMethod("validateLogin", params);
		String value = null;
		try {
			if (response != null) {

				JSONObject jsonObject = new JSONObject(response);
				value = jsonObject.getString("result");
				
			}
		} catch (Exception e) {
		}
		return value;
	}
	
}
