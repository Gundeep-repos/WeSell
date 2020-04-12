package vmm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SmsSender {

    public static void main(String[] args) {

        String message = "OLX%20OTP%20verification:123";
        String number = "8847480788";
        sendMessage(message, number);
    }

    public static void sendMessage(String message, String number) {
        try {
            URL url = new URL("http://server1.vmm.education/VMMCloudMessaging/AWS_SMS_Sender"
                    + "?username=jasmeen1&password=PYI01ZHO&message=" + message.replace(" ", "%20")
                    + "&phone_numbers=" + number + "");
            HttpURLConnection uRLConnection = (HttpURLConnection) url.openConnection();

            BufferedReader br = new BufferedReader(new InputStreamReader(uRLConnection.getInputStream()));

            while (true) {
                String s = br.readLine();
                System.out.println(s);
                if (s == null) {
                    break;
                }
            }

            if (uRLConnection.getResponseCode() == 200) {
                System.out.println("if");
            } else {
                System.out.println("else ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
