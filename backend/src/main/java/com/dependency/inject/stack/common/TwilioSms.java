//package com.dependency.inject.stack.common;
//
//import com.twilio.Twilio;
//import com.twilio.converter.Promoter;
//import com.twilio.rest.api.v2010.account.Message;
//import com.twilio.type.PhoneNumber;
//
//import java.net.URI;
//
///**
// * The type Twilio sms.
// */
//public class TwilioSms {
//
//    private static final String ACCOUNT_SID = "ACfbff61e1951e10b446949c79984401a1";
//
//    private static final String AUTH_TOKEN = "b19024c040ad33a24be98ea5cc28aae6";
//
//    private static final String TWILIO_NUMBER = "+12512107344";
//
//    private static final String VI = "+84";
//
//    /**
//     * Send message.
//     *
//     * @param phone the phone
//     * @param body  the body
//     */
//    public static void sendMessage(String phone, String body) {
//        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
//        Message.creator(
//            new PhoneNumber(VI.concat(phone)),
//            new PhoneNumber(TWILIO_NUMBER), body)
//            .create();
//    }
//
//    /**
//     * Send message has link.
//     *
//     * @param phone the phone
//     * @param body  the body
//     * @param link  the link
//     */
//    public static void sendMessageHasLink(String phone, String body, String link) {
//        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
//        Message message = Message.creator(
//                new PhoneNumber(VI.concat(phone)),
//                new PhoneNumber(TWILIO_NUMBER), body)
//                .setMediaUrl(
//                        Promoter.listOfOne(
//                                URI.create(link)))
//                .create();
//    }
//
//    /**
//     * Create account string.
//     *
//     * @param password the password
//     * @return the string
//     */
//    public static String createAccount(String password) {
//        return "Tài khoản của bạn vừa được tạo trên hệ thống HDHT - Medical, mật khẩu của bạn là " + password;
//    }
//}
