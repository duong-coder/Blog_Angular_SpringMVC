//package com.dependency.inject.stack.service;
//
//import com.dependency.inject.stack.service.dto.DoctorDTO;
//import com.dependency.inject.stack.service.dto.UserDTO;
//import org.springframework.context.i18n.LocaleContextHolder;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.stereotype.Service;
//import org.thymeleaf.TemplateEngine;
//import org.thymeleaf.context.Context;
//
//import javax.mail.MessagingException;
//import javax.mail.internet.MimeMessage;
//import java.time.Instant;
//import java.util.Date;
//
//import static com.dependency.inject.stack.common.StringUtils.ENCODING_UTF_8;
//
///**
// * The type Email service.
// */
//@Service
//public class EmailService {
//
//    private final TemplateEngine templateEngine;
//
//    private final JavaMailSender mailSender;
//
//    /**
//     * Instantiates a new Email service.
//     *
//     * @param mailSender     the mail sender
//     * @param templateEngine the template engine
//     */
//    public EmailService(JavaMailSender mailSender, TemplateEngine templateEngine) {
//        this.mailSender = mailSender;
//        this.templateEngine = templateEngine;
//    }
//
//
//    /**
//     * Construct reset token email mime message.
//     *
//     * @param contextPath the context path
//     * @param token       the token
//     * @param password    the password
//     * @param email       the email
//     * @param firstName   the first name
//     * @param lastName    the last name
//     * @return the mime message
//     * @throws MessagingException the messaging exception
//     */
//    public MimeMessage constructResetTokenEmail(
//            String contextPath, String token, String password, String email, String firstName, String lastName) throws MessagingException {
//        StringBuilder urlBuilder = new StringBuilder();
//        urlBuilder.append(contextPath);
////        urlBuilder.append("/change-password?id=");
//        urlBuilder.append("/change-password?");
////        urlBuilder.append(user.getId());
////        urlBuilder.append("&token=");
//        urlBuilder.append("token=");
//        urlBuilder.append(token);
//
//        return constructEmail("Welcome to HDHT - Medical", urlBuilder.toString(), password, email, firstName, lastName);
//    }
//
//    private MimeMessage constructEmail(String subject, String body,
//                                       String password, String email
//            , String firstName, String lastName) throws MessagingException {
//        // Prepare the evaluation context
//        Context ctx = new Context(LocaleContextHolder.getLocale());
//        StringBuilder nameBuilder = new StringBuilder();
//        nameBuilder.append(firstName);
//        nameBuilder.append(" ");
//        nameBuilder.append(lastName);
//
//        ctx.setVariable("name", nameBuilder);
//        ctx.setVariable("subscriptionDate", new Date());
//        ctx.setVariable("url", body);
//        ctx.setVariable("password", password);
//
//        // Prepare message using a Spring helper
//        MimeMessage mimeMessage = this.mailSender.createMimeMessage();
//        MimeMessageHelper message =
//                new MimeMessageHelper(mimeMessage, false, ENCODING_UTF_8);
//
//        // Create the HTML body using Thymeleaf
//        String htmlContent = this.templateEngine.process("mail/emailTemplate.html", ctx);
//
//        // true = isHtml
//        message.setText(htmlContent, true);
//        message.setSubject(subject);
//        message.setTo(email);
//
//        return mimeMessage;
//    }
//
//    public MimeMessage constructApproveDoctorEmail(
//            String appointmentCode, Instant date, String time, String email, String firstName, String lastName) throws MessagingException {
//
//        Context ctx = new Context(LocaleContextHolder.getLocale());
//        StringBuilder nameBuilder = new StringBuilder();
//        nameBuilder.append(firstName);
//        nameBuilder.append(" ");
//        nameBuilder.append(lastName);
//
//        ctx.setVariable("name", nameBuilder);
//        ctx.setVariable("subscriptionDate", new Date());
//        ctx.setVariable("code", appointmentCode);
//        ctx.setVariable("date", date);
//        ctx.setVariable("time", time);
//
//        // Prepare message using a Spring helper
//        MimeMessage mimeMessage = this.mailSender.createMimeMessage();
//        MimeMessageHelper message =
//                new MimeMessageHelper(mimeMessage, false, ENCODING_UTF_8);
//
//        // Create the HTML body using Thymeleaf
//        String htmlContent = this.templateEngine.process("mail/emailApproveDoctor.html", ctx);
//
//        // true = isHtml
//        message.setText(htmlContent, true);
//        message.setSubject("[HDHT - Medical] Cuộc hẹn " + appointmentCode + " đã được duyệt");
//        message.setTo(email);
//
//        return mimeMessage;
//    }
//
//    public MimeMessage constructApprovePatientEmail(
//            String appointmentCode, DoctorDTO doctor, Instant date, String time, String email, String firstName, String lastName) throws MessagingException {
//
//        Context ctx = new Context(LocaleContextHolder.getLocale());
//        StringBuilder nameBuilder = new StringBuilder();
//        nameBuilder.append(firstName);
//        nameBuilder.append(" ");
//        nameBuilder.append(lastName);
//
//        ctx.setVariable("name", nameBuilder);
//        ctx.setVariable("subscriptionDate", new Date());
//        ctx.setVariable("code", appointmentCode);
//        ctx.setVariable("date", date);
//        ctx.setVariable("time", time);
//        ctx.setVariable("doctor", doctor.getFirstName().concat(" ").concat(doctor.getLastName()));
//
//        // Prepare message using a Spring helper
//        MimeMessage mimeMessage = this.mailSender.createMimeMessage();
//        MimeMessageHelper message =
//                new MimeMessageHelper(mimeMessage, false, ENCODING_UTF_8);
//
//        // Create the HTML body using Thymeleaf
//        String htmlContent = this.templateEngine.process("mail/emailApprovePatient.html", ctx);
//
//        // true = isHtml
//        message.setText(htmlContent, true);
//        message.setSubject("[HDHT - Medical] Cuộc hẹn " + appointmentCode + " đã được duyệt");
//        message.setTo(email);
//
//        return mimeMessage;
//    }
//
//    public MimeMessage constructAssignEmail(
//            String appointmentCode, UserDTO createBy, Instant date, String time, String email, String firstName, String lastName) throws MessagingException {
//
//        Context ctx = new Context(LocaleContextHolder.getLocale());
//        StringBuilder nameBuilder = new StringBuilder();
//        nameBuilder.append(firstName);
//        nameBuilder.append(" ");
//        nameBuilder.append(lastName);
//
//        ctx.setVariable("name", nameBuilder);
//        ctx.setVariable("subscriptionDate", new Date());
//        ctx.setVariable("code", appointmentCode);
//        ctx.setVariable("date", date);
//        ctx.setVariable("time", time);
//        ctx.setVariable("createBy", createBy.getFirstName().concat(" ").concat(createBy.getLastName()));
//
//        // Prepare message using a Spring helper
//        MimeMessage mimeMessage = this.mailSender.createMimeMessage();
//        MimeMessageHelper message =
//                new MimeMessageHelper(mimeMessage, false, ENCODING_UTF_8);
//
//        // Create the HTML body using Thymeleaf
//        String htmlContent = this.templateEngine.process("mail/emailAssign.html", ctx);
//
//        // true = isHtml
//        message.setText(htmlContent, true);
//        message.setSubject("[HDHT - Medical] Cuộc hẹn " + appointmentCode + " đã được giao cho bạn");
//        message.setTo(email);
//
//        return mimeMessage;
//    }
//
//    public MimeMessage constructSuccessDoctorEmail(
//            String appointmentCode, Instant date, String time, String email, String firstName, String lastName) throws MessagingException {
//        Context ctx = new Context(LocaleContextHolder.getLocale());
//        StringBuilder nameBuilder = new StringBuilder();
//        nameBuilder.append(firstName);
//        nameBuilder.append(" ");
//        nameBuilder.append(lastName);
//
//        ctx.setVariable("name", nameBuilder);
//        ctx.setVariable("subscriptionDate", new Date());
//        ctx.setVariable("code", appointmentCode);
//        ctx.setVariable("date", date);
//        ctx.setVariable("time", time);
//
//        // Prepare message using a Spring helper
//        MimeMessage mimeMessage = this.mailSender.createMimeMessage();
//        MimeMessageHelper message =
//                new MimeMessageHelper(mimeMessage, false, ENCODING_UTF_8);
//
//        // Create the HTML body using Thymeleaf
//        String htmlContent = this.templateEngine.process("mail/emailSuccessDoctor.html", ctx);
//
//        // true = isHtml
//        message.setText(htmlContent, true);
//        message.setSubject("[HDHT - Medical] Cuộc hẹn " + appointmentCode + " đã hoàn thành");
//        message.setTo(email);
//
//        return mimeMessage;
//    }
//
//    public MimeMessage constructSuccessPatientEmail(
//            String appointmentCode, Instant date, String time, String email, String firstName, String lastName) throws MessagingException {
//        Context ctx = new Context(LocaleContextHolder.getLocale());
//        StringBuilder nameBuilder = new StringBuilder();
//        nameBuilder.append(firstName);
//        nameBuilder.append(" ");
//        nameBuilder.append(lastName);
//
//        ctx.setVariable("name", nameBuilder);
//        ctx.setVariable("subscriptionDate", new Date());
//        ctx.setVariable("code", appointmentCode);
//        ctx.setVariable("date", date);
//        ctx.setVariable("time", time);
//
//        // Prepare message using a Spring helper
//        MimeMessage mimeMessage = this.mailSender.createMimeMessage();
//        MimeMessageHelper message =
//                new MimeMessageHelper(mimeMessage, false, ENCODING_UTF_8);
//
//        // Create the HTML body using Thymeleaf
//        String htmlContent = this.templateEngine.process("mail/emailSuccessPatient.html", ctx);
//
//        // true = isHtml
//        message.setText(htmlContent, true);
//        message.setSubject("[HDHT - Medical] Cuộc hẹn " + appointmentCode + " đã hoàn thành");
//        message.setTo(email);
//
//        return mimeMessage;
//    }
//
//    public MimeMessage constructCancelEmail(
//            String appointmentCode, Instant date, String time, String email, String firstName, String lastName, String reason) throws MessagingException {
//        Context ctx = new Context(LocaleContextHolder.getLocale());
//        StringBuilder nameBuilder = new StringBuilder();
//        nameBuilder.append(firstName);
//        nameBuilder.append(" ");
//        nameBuilder.append(lastName);
//
//        ctx.setVariable("name", nameBuilder);
//        ctx.setVariable("subscriptionDate", new Date());
//        ctx.setVariable("code", appointmentCode);
//        ctx.setVariable("date", date);
//        ctx.setVariable("time", time);
//        ctx.setVariable("reason", reason);
//
//        // Prepare message using a Spring helper
//        MimeMessage mimeMessage = this.mailSender.createMimeMessage();
//        MimeMessageHelper message =
//                new MimeMessageHelper(mimeMessage, false, ENCODING_UTF_8);
//
//        // Create the HTML body using Thymeleaf
//        String htmlContent = this.templateEngine.process("mail/emailCancel.html", ctx);
//
//        // true = isHtml
//        message.setText(htmlContent, true);
//        message.setSubject("[HDHT - Medical] Cuộc hẹn " + appointmentCode + " đã bị hủy");
//        message.setTo(email);
//
//        return mimeMessage;
//    }
//
// public MimeMessage constructResetTokenEmailForgot(
//            String contextPath, String token, String password, String email, String firstName, String lastName) throws MessagingException {
//        StringBuilder urlBuilder = new StringBuilder();
//        urlBuilder.append(contextPath);
//        urlBuilder.append("/change-password?");
//        urlBuilder.append("token=");
//        urlBuilder.append(token);
//
//        return constructEmailForgot("Welcome to HDHT - Medical", urlBuilder.toString(), password, email, firstName, lastName);
//    }
//
//    private MimeMessage constructEmailForgot(String subject, String body,
//                                       String password, String email
//            , String firstName, String lastName) throws MessagingException {
//        // Prepare the evaluation context
//        Context ctx = new Context(LocaleContextHolder.getLocale());
//        StringBuilder nameBuilder = new StringBuilder();
//        nameBuilder.append(firstName);
//        nameBuilder.append(" ");
//        nameBuilder.append(lastName);
//
//        ctx.setVariable("name", nameBuilder);
//        ctx.setVariable("subscriptionDate", new Date());
//        ctx.setVariable("url", body);
//        ctx.setVariable("password", password);
//
//        // Prepare message using a Spring helper
//        MimeMessage mimeMessage = this.mailSender.createMimeMessage();
//        MimeMessageHelper message =
//                new MimeMessageHelper(mimeMessage, false, ENCODING_UTF_8);
//
//        // Create the HTML body using Thymeleaf
//        String htmlContent = this.templateEngine.process("mail/emailForgot.html", ctx);
//
//        // true = isHtml
//        message.setText(htmlContent, true);
//        message.setSubject(subject);
//        message.setTo(email);
//
//        return mimeMessage;
//    }
//
//    public MimeMessage constructEmailWelcome(String subject, String email, String firstName, String lastName) throws MessagingException {
//        // Prepare the evaluation context
//        Context ctx = new Context(LocaleContextHolder.getLocale());
//        StringBuilder nameBuilder = new StringBuilder();
//        nameBuilder.append(firstName);
//        nameBuilder.append(" ");
//        nameBuilder.append(lastName);
//
//        ctx.setVariable("name", nameBuilder);
//        ctx.setVariable("subscriptionDate", new Date());
//
//        // Prepare message using a Spring helper
//        MimeMessage mimeMessage = this.mailSender.createMimeMessage();
//        MimeMessageHelper message =
//                new MimeMessageHelper(mimeMessage, false, ENCODING_UTF_8);
//
//        // Create the HTML body using Thymeleaf
//        String htmlContent = this.templateEngine.process("mail/emailWelcome.html", ctx);
//
//        // true = isHtml
//        message.setText(htmlContent, true);
//        message.setSubject(subject);
//        message.setTo(email);
//
//        return mimeMessage;
//    }
//
//    public MimeMessage constructHomeCreate(
//            String appointmentCode, Instant date, String time, String email, String firstName, String lastName) throws MessagingException {
//        Context ctx = new Context(LocaleContextHolder.getLocale());
//        StringBuilder nameBuilder = new StringBuilder();
//        nameBuilder.append(firstName);
//        nameBuilder.append(" ");
//        nameBuilder.append(lastName);
//
//        ctx.setVariable("name", nameBuilder);
//        ctx.setVariable("subscriptionDate", new Date());
//        ctx.setVariable("code", appointmentCode);
//        ctx.setVariable("date", date);
//        ctx.setVariable("time", time);
//
//        // Prepare message using a Spring helper
//        MimeMessage mimeMessage = this.mailSender.createMimeMessage();
//        MimeMessageHelper message =
//                new MimeMessageHelper(mimeMessage, false, ENCODING_UTF_8);
//
//        // Create the HTML body using Thymeleaf
//        String htmlContent = this.templateEngine.process("mail/emailHomeCreate.html", ctx);
//
//        // true = isHtml
//        message.setText(htmlContent, true);
//        message.setSubject("[HDHT - Medical] Cuộc hẹn " + appointmentCode + " vừa được tạo");
//        message.setTo(email);
//
//        return mimeMessage;
//    }
//
//}