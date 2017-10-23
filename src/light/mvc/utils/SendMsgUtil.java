package light.mvc.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class SendMsgUtil {


	public static int send(String msg, String mobile) throws Exception {
		msg=java.net.URLEncoder.encode(msg);
		String addr ="http://api.sms.cn/mt/";
		int nRet = 0;
		String password = MD5Util.md5("ccwmkjccwmkj");
		String straddr = addr + "?uid=ccwmkj&pwd=" + password
				+ "&mobile=" + mobile + "&content=" + msg;
		StringBuffer sb = new StringBuffer(straddr);
		URL url = new URL(sb.toString());

//		URL url = new URL(URLEncoder.encode(sb.toString(),"UTF-8") );

		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		connection.setRequestMethod("POST");

		BufferedReader in = new BufferedReader(new InputStreamReader(
				url.openStream()));

		String inputline = in.readLine();

		if(! inputline.equals("100"))
			nRet = 1;

		return nRet;
	}

}
