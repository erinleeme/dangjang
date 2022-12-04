package com.dangjang.util;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Random;


public class naverSMS {

    public StringBuffer randomCode() {
        Random rnd =new Random();

        StringBuffer buf =new StringBuffer();

        for(int i=0;i<20;i++){
            if(rnd.nextBoolean()){
                buf.append((char)((int)(rnd.nextInt(26))+97));
            }else{
                buf.append((rnd.nextInt(10)));
            }
        }
        return buf;
    }

    public String randomNum(int len){
        Random rand = new Random();
        String rn = "";
        for(int i = 0; i < len; i++){
            String ran = Integer.toString(rand.nextInt(10));
            rn += ran;
        }
        return rn;
    }

    private String makeSignature(String url, String timestamp, String method, String accessKey, String secretKey)
                                throws NoSuchAlgorithmException, InvalidKeyException{
        String space = " "; // one space
        String newLine = "\n"; // new line

        String message = new StringBuilder()
                .append(method)
                .append(space)
                .append(url)
                .append(newLine)
                .append(timestamp)
                .append(newLine)
                .append(accessKey)
                .toString();

        SecretKeySpec signingKey;
        String encodeBase64String;

        try{
            signingKey = new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(signingKey);
            byte[] rawHmac = mac.doFinal(message.getBytes("UTF-8"));
            encodeBase64String = Base64.getEncoder().encodeToString(rawHmac);
        } catch(UnsupportedEncodingException e){
            encodeBase64String = e.toString();
        };
        return encodeBase64String;
    }

    public void sendSMS(String phoneNumber, String randomNum) {
        String hostNameUrl = "https://sens.apigw.ntruss.com"; // host URL
        String requestUrl = "/sms/v2/services/"; // 요청 URL
        String requestUrlType = "/messages"; // 요청 URL
        String accessKey = "69HDZovHoU0FIEbOMjAl"; // platform api
        String secretKey = "fWNvg0WlWeJ5eH6bWDmIC3kblpbZ4roOvYIU6xnP"; // seceret key
        String serviceId = "ncp:sms:kr:282245656509:dangjangshop"; // project service id
        String method = "POST"; // 요청 method
        String timestamp = Long.toString(System.currentTimeMillis()); // current timestamp
        requestUrl += serviceId + requestUrlType;
        String apiUrl = hostNameUrl + requestUrl; // url 전체 주소

        // create body data by JSON
        JSONObject bodyJson = new JSONObject();
        JSONObject toJson = new JSONObject();
        JSONArray toArr = new JSONArray();

        toJson.put("to", phoneNumber); // input 값 받아와서 넣어야 함
        toJson.put("content", "[당장가게] 인증번호 " + randomNum + " 를 입력해주세요."); // random number 4자리 만들어서 보내주고, 받으면 비교 필요
        toArr.add(toJson);

        bodyJson.put("type", "SMS"); // 소문자도 가능 sms
        bodyJson.put("contentType", "COMM");
        bodyJson.put("countryCode", "82");
        bodyJson.put("from", "01021232024");
        bodyJson.put("content", "[당장가게]");
        bodyJson.put("messages", toArr);


        String body = bodyJson.toString();
        System.out.println(body);

        try{
            URL url = new URL(apiUrl);

            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setUseCaches(false);
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestProperty("content-type", "application/json; charset=utf-8");
            con.setRequestProperty("x-ncp-apigw-timestamp", timestamp);
            con.setRequestProperty("x-ncp-iam-access-key", accessKey);
            con.setRequestProperty("x-ncp-apigw-signature-v2", makeSignature(requestUrl, timestamp, method, accessKey, secretKey));
            con.setRequestMethod(method);
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());

            wr.write(body.getBytes());
            wr.flush();
            wr.close();

            int responseCode = con.getResponseCode();
            BufferedReader br;
            System.out.println("responseCode" + " " + responseCode);
            if(responseCode == 202){
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }

            String inputLine;
            StringBuffer response = new StringBuffer();
            while((inputLine = br.readLine()) != null){
                response.append(inputLine);
            }
            br.close();

            System.out.println(response.toString());

        } catch (Exception e){
            System.out.println(e);
        }


    }

}
