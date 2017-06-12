package web;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.methods.PostMethod;

public class SmsClientLoginHttpImpl  {
	
	final String LOGIN_URL = "http://www.topmis.cn/app/sms/cloud/auth.form";
	
	public static MultiThreadedHttpConnectionManager manager = new MultiThreadedHttpConnectionManager();

	private static HttpClient httpClient = new HttpClient(manager);

//　　**
//    * 登录获取token
//    **
	@SuppressWarnings("deprecation")
	public String login(){
		try {
			HttpMethod postMethod = new PostMethod(LOGIN_URL);
			postMethod.addRequestHeader("Accept", "application/xml");
			postMethod.addRequestHeader("Content-Type",
					"application/xml; charset=UTF-8");
			String requestBodyXml = "<loginKey><accountId>biozon</accountId><password>biozon1234</password></loginKey>";
			((PostMethod) postMethod).setRequestBody(requestBodyXml);
			int statusCode = 0;
			statusCode = httpClient.executeMethod(postMethod);
			if (statusCode == HttpStatus.SC_OK) {
				String resultStr = postMethod.getResponseBodyAsString();
				Pattern pattern = Pattern.compile("<token>(.*?)</token>");
				Matcher matcher = pattern.matcher(resultStr);
				if(matcher.find()){
					return matcher.group(1);
				}
				return null;
			}
		} catch (IOException e) {
		}
		return null;
	}

	public static void main(String[] args) {
		SmsClientLoginHttpImpl ssc = new SmsClientLoginHttpImpl();
		System.out.println(ssc.login());
	}
}