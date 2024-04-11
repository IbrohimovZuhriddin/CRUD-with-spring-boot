package zuhriddinscode.email;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.scheduling.annotation.Async;

@Service
//@Component
public class EmailService implements EmailSender {
    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender javaMailSender) {
        this.mailSender = javaMailSender;
    }

    private final static Logger LOGGER = LoggerFactory
            .getLogger(EmailService.class);


//    @Override
//    @Async
//    public void send(String to, String email) {
//        try {
//            MimeMessage mimeMessage = mailSender.createMimeMessage();
//            MimeMessageHelper helper =
//                    new MimeMessageHelper(mimeMessage, "utf-8");
//            helper.setText(email, true);
//            helper.setTo(to);
//            helper.setSubject("ibrohimovzuhriddin310@gmail.com");
//            helper.setFrom("helloibrohimovzuhriddin310@gmail.com");
//            mailSender.send(mimeMessage);
//        } catch (MessagingException e) {
//            LOGGER.error("failed to send email", e);
//            throw new IllegalStateException("failed to send email");
//        }
//    }

    @Override
    public void send(String to, String subject,String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);
    }
}