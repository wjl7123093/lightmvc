package light.mvc.utils;

import java.util.Date;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

public class SendEmailUtil {

	public void sendmail() throws MessagingException {

		// 创建邮件发送类 JavaMailSender
		// 用于发送基本的文本邮件信息（不能包括附件，及图片）
		JavaMailSender sender = new JavaMailSenderImpl();

		// 设置邮件服务主机
		((JavaMailSenderImpl) sender).setHost("smtp.qq.com");
		// 发送者邮箱的用户名
		((JavaMailSenderImpl) sender).setUsername("service@wmkj.cc");
		// 发送者邮箱的密码
		((JavaMailSenderImpl) sender).setPassword("ccwmkj.1");

		// 配置文件，用于实例化java.mail.session
		Properties pro = System.getProperties();

		// 登录SMTP服务器,需要获得授权，网易163邮箱新近注册的邮箱均不能授权。
		// 测试 sohu 的邮箱可以获得授权
		pro.put("mail.smtp.auth", "true");
		pro.put("mail.smtp.socketFactory.port", "25");
		pro.put("mail.smtp.socketFactory.fallback", "false");

		// 通过文件获取信息
		((JavaMailSenderImpl) sender).setJavaMailProperties(pro);

		// 创建基本邮件信息
		// 创建多元化邮件
		MimeMessage mimeMessage = ((JavaMailSenderImpl) sender).createMimeMessage();

		// 创建 mimeMessage 帮助类，用于封装信息至 mimeMessage
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "GBK");

		// 发送者地址，必须填写正确的邮件格式，否者会发送失败
		helper.setFrom("service@wmkj.cc");
		// 邮件主题
		helper.setSubject("今日未关call信息");
		// 邮件内容，简单的邮件信息只能添加文本信息
		helper.setText("");

		String[] to = new String[] { "flyemu@qq.com" };
		// 邮件接收者的邮箱地址
		helper.setTo(to);

		String str = "";
		String repairusername = "鸵鸟";

		str += "<tr><td>" + "20150112" + "</td><td>" + repairusername + "</td><td>" + new Date() + "</td><td>" + "百度"
				+ "</td><td>" + "李彦宏" + "</td><td>" + "12345678" + "</td><td>" + "洽谈收购百度事宜" + "</td><td>" + "100亿"
				+ "</td></tr>";

		// 如果是html代码，boolean 的参数用该为true
		helper.setText(
				"<html><head><meta http-equiv="
						+ "Content-Type"
						+ " content="
						+ "text/html; charset=gb2312"
						+ "><style type=\"text/css\">table.gridtable {font-family: verdana,arial,sans-serif;font-size:11px;color:#333333;border-width: 1px;border-color: #666666;border-collapse: collapse;}table.gridtable th {border-width: 1px;padding: 8px;border-style: solid;border-color: #666666;background-color: #dedede;}table.gridtable td {border-width: 1px;padding: 8px;border-style: solid;border-color: #666666;background-color: #ffffff;}</style></head><body><h1>以下是今日未关call信息,请相关工程师及时跟进处理.</h1>"
						+ "<table class=\"gridtable\"><tr><th>工单号</th><th>工程师</th><th>报修时间</th><th>客户名称</th><th>联系人</th><th>联系电话</th><th>报修内容</th><th>服务费</th></tr>"
						+ str + "</table></body></html>", true);

		sender.send(mimeMessage);
		System.out.println("发送成功");
	}
}
