package web;
import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.methods.PostMethod;

public class SmsSubmitClientHttpImpl {

	final String SEND_URL = "http://www.topmis.cn/app/sms/cloud/submit.form";

	final String BATCH_SEND_URL = "http://www.topmis.cn/app/sms/cloud/batchSubmit.form";

	public static MultiThreadedHttpConnectionManager manager = new MultiThreadedHttpConnectionManager();

	private static HttpClient httpClient = new HttpClient(manager);

	@SuppressWarnings("deprecation")
	public String submit() {
		try {
			HttpMethod postMethod = new PostMethod(SEND_URL);
			postMethod.addRequestHeader("Accept", "application/xml");
			postMethod.addRequestHeader("Content-Type",
					"application/xml; charset=UTF-8");
			String requestBodyXml = "<sm><accountId>biozon</accountId><token>biozon@34507a15-b9f5-4a02-86d4-2dd3e160c3dd</token><content>用户与平台进行每一次交互,都需要带上token信息,token信息通过登录接口获取,token失效时间表15分钟,即15分种之内该token没有任何接口调用将失效.【签名】</content><targetPhoneNo>15757180515</targetPhoneNo><customId>1</customId><isUrgent>1</isUrgent></sm>";
			((PostMethod) postMethod).setRequestBody(requestBodyXml);
			int statusCode = 0;
			statusCode = httpClient.executeMethod(postMethod);
			if (statusCode == HttpStatus.SC_OK) {
				String resultStr = postMethod.getResponseBodyAsString();
				return resultStr;
			}
		} catch (IOException e) {

		}
		return null;
	}

	public static void main(String[] args) {
		SmsSubmitClientHttpImpl sms = new SmsSubmitClientHttpImpl();
		System.out.println(sms.submit());
	}

}
