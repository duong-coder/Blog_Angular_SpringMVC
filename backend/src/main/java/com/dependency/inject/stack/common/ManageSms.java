package com.dependency.inject.stack.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * The type Manage sms.
 */
public class ManageSms {

    /**
     * Send sms.
     *
     * @param phone the phone
     * @param body  the body
     */
    public static void sendSms(String phone, String body) {
//            http://world.msg91.com/api/sendhttp.php?authkey=4952ALaeZXWzUiD5dd0ff75&mobiles=84389185187&message=hello&sender=ABCDEF&route=4&country=0
//            https://world.msg91.com/apidoc/samplecode/java-sample-code-send-sms.php
        //Your authentication key
        String authkey = "4952ALaeZXWzUiD5dd0ff75";
        //Multiple mobiles numbers separated by comma
        String mobiles = "84" + phone;
        //Sender ID,While using route4 sender id should be 6 characters long.
        String senderId = "HDHT";
        //Your message to send, Add URL encoding here.
        String message = body;
        //define route
        String route = "4";

        try {
            String encodedUrl = URLEncoder.encode(body, "UTF-8");
            message = encodedUrl;
        } catch (UnsupportedEncodingException e) {
            message = body;
        }

        //Prepare Url
        URLConnection myURLConnection = null;
        URL myURL = null;
        BufferedReader reader = null;

        //encoding message
        @SuppressWarnings("deprecation")
        String encoded_message = URLEncoder.encode(message);

        //Send SMS API
        String mainUrl = "http://world.msg91.com/api/sendhttp.php?";

        //Prepare parameter string
        StringBuilder sbPostData = new StringBuilder(mainUrl);
        sbPostData.append("authkey=" + authkey);
        sbPostData.append("&mobiles=" + mobiles);
        sbPostData.append("&message=" + encoded_message);
        sbPostData.append("&route=" + route);
        sbPostData.append("&sender=" + senderId);
        sbPostData.append("&country=0");

        //final string
        mainUrl = sbPostData.toString();
        try {
            //prepare connection
            myURL = new URL(mainUrl);
            myURLConnection = myURL.openConnection();
            myURLConnection.connect();
            reader = new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));
            //reading response
            String response;
            while ((response = reader.readLine()) != null)
                //print response
                System.out.println(response);

            //finally close connection
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
