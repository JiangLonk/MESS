package lc;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Joshua
 * @name：绿信通发送信息DEMO
 * @version：1.0
 * @date：2016-03-21
 * @description：
 * 以下代码只是为了方便客户测试而提供的样例代码，客户可以根据自己网站的需要，按照技术文档自行编写,并非一定要使用该代码。
 * 该代码仅供学习和研究绿信通接口使用，只是提供一个参考。
 * @required: J2SE 1.7 httplient-4.3.5
 */
public class HttpSenderTest {
	
	private static final SimpleDateFormat dateFormat1 = new SimpleDateFormat("HHmmss");
	
	public static void main(String[] args) {
		String url = "http://api.china95059.net:8080/sms/send";// 应用地址
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "用户名！！！");
		map.put("pswd", "密码！！！");
		map.put("mobile", "手机号！！！");
		map.put("msg", "您的验证码是"+dateFormat1.format(new Date())+",感谢您的支持,请勿泄露给他人!");//用自己的内容白名单做测试
		map.put("needstatus", String.valueOf(true));
		map.put("sender", null);
		map.put("type", "json");
		
		try {
			String returnString = HttpSender.send(url, map);
			System.out.println(returnString);
			// TODO 处理返回值,参见绿信通协议文档
		} catch (Exception e) {
			// TODO 处理异常
			e.printStackTrace();
		}
	}
}
