package web;

public class HttpSenderTest {
	public static void main(String[] args) {
		String url = "http://222.73.117.158/msg/";// 应用地址
		String account = "cunyouqu";// 账号
		String pswd = "Tch483410";// 密码
		String mobile = "15158699926";// 手机号码，多个号码使用","分割
		String msg = "您好，您的资格认证已通过，现在马上开始发布活动吧！";// 短信内容
		System.out.println(msg);
		boolean needstatus = true;// 是否需要状态报告，需要true，不需要false
		String product = "349312826";// 产品ID
		String extno = null;// 扩展码

		try {
			String returnString = HttpSender.batchSend(url, account, pswd, mobile, msg, needstatus, product, extno);
			System.out.print(returnString);
			String respstatus;
			if(returnString.contains("\n")){
				respstatus = returnString.substring(returnString.indexOf(",") + 1, returnString.indexOf("\n"));
			}else{
				respstatus = returnString.substring(returnString.indexOf(",") + 1, returnString.length());
			}
			System.out.println(respstatus);
			// TODO 处理返回值,参见HTTP协议文档
		} catch (Exception e) {
			// TODO 处理异常
			e.printStackTrace();
		}
	}
}
