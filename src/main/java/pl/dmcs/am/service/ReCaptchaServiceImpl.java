package pl.dmcs.am.service;

import org.springframework.stereotype.Service;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;

@Service
public class ReCaptchaServiceImpl implements ReCaptchaService {
    private static final String URL = "https://www.google.com/recaptcha/api/siteverify";
    private static final String GOOGLE_KEY = "6Le5bqEUAAAAABj1bv1sFR1mPnMGL_vUkhb3xNnh";

    @Override
    public boolean verify(String captcha) {
        if (captcha == null || "".equals(captcha)) return false;
        try{
            java.net.URL obj = new URL(URL);
            HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
            con.setRequestMethod("POST");
            String postParams = "secret=" + GOOGLE_KEY + "&response=" + captcha;
            // Send post request
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(postParams);
            wr.flush();
            wr.close();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            //parse JSON response and return 'success' value
            JsonReader jsonReader = Json.createReader(new StringReader(response.toString()));
            JsonObject jsonObject = jsonReader.readObject();
            jsonReader.close();
            return jsonObject.getBoolean("success");
        } catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
}

