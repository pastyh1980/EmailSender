package crunchify.com.tutorials;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by root on 12/16/15.
 */

@Controller
@RequestMapping("/sendEmail.do")
public class CrunchifyEmailAPI {
    @Autowired
    private JavaMailSender mailSender;

    @RequestMapping(method = RequestMethod.POST)
    public String doSendEmail(HttpServletRequest request) {
        String toAddr = request.getParameter("toAddress");
        String subj = request.getParameter("subject");
        String mes = request.getParameter("msgBody");

        System.out.println("To: " + toAddr);
        System.out.println("Subject: " + subj);
        System.out.println("Message: " + mes);

        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(toAddr);
        email.setSubject(subj);
        email.setText(mes);

        mailSender.send(email);

        return "Result";
    }
}
