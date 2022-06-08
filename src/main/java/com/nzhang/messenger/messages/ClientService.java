package com.nzhang.messenger.messages;

import com.nzhang.messenger.MessengerApplication;
import com.nzhang.messenger.messages.dialog.Dialog;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

@Component
public class ClientService {

    // этот метод работает так:
    // он принимает в себя Диалог с пользователем, и обновляет там его ник, имя и биографию
    public Dialog getPersonality(String address, Dialog dialog) {
        try {
            JSONObject response = this.sendJSONRequest(address, "getPersonalInformation");
            dialog.setName(response.getString("name"));
            dialog.setNickName(response.getString("nickname"));
            dialog.setBio(response.getString("bio"));
            dialog.setUID(response.getLong("UID"));
            return dialog;
        } catch (Exception e) {
            throw new RuntimeException("Не удалось подключиться к пользователю по адресу: " + address, e);
        }
    }

    public Dialog getPhoto(String address, Dialog dialog) {

        try {
            URL url = new URL("http://" + address + "/getPhoto");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            int responsecode = conn.getResponseCode();

            if (responsecode != 200) {
                throw new Exception("HttpResponseCode: " + responsecode);
            } else {

                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                InputStream is = null;
                try {
                    is = url.openStream();
                    byte[] byteChunk = new byte[4096]; // Or whatever size you want to read in at a time.
                    int n;

                    while ( (n = is.read(byteChunk)) > 0 ) {
                        baos.write(byteChunk, 0, n);
                    }
                }
                catch (IOException e) {
                    System.err.printf ("Failed while reading bytes from %s: %s", url.toExternalForm(), e.getMessage());
                    e.printStackTrace ();
                }
                finally {
                    if (is != null) { is.close(); }
                }

                dialog.setPhoto(baos.toByteArray());
                conn.disconnect();

            }

            return dialog;

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("No Photo provided");
            //
        }

    }


    public void sendMessage(String address, String text) {

        try {
            URL url = new URL("http://" + address + "/sendMessage");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("Content-Type", "application/json");

            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            OutputStream os = conn.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");

            JSONObject r = new JSONObject();
            r.put("uid", MessengerApplication.personalityService.getMe().getUID());
            r.put("text", text);
            osw.write(r.toString());

            osw.flush();
            osw.close();
            os.close();

            conn.connect();

            int responsecode = conn.getResponseCode();

            if (responsecode != 201) {
                throw new Exception("HttpResponseCode: " + responsecode);
            }

            conn.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Не удалось отправить сообщение к пользователю по адресу: " + address);
        }

    }

    private JSONObject sendJSONRequest(String address, String method) throws Exception {

        try {
            URL url = new URL("http://" + address + "/" + method);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("Accept", "application/json");

            int responsecode = conn.getResponseCode();

            if (responsecode != 200) {
                throw new Exception("HttpResponseCode: " + responsecode);
            } else {

                String inline = "";
                Scanner scanner = new Scanner(conn.getInputStream());
                while (scanner.hasNext()) {
                    inline += scanner.nextLine();
                }
                scanner.close();

                System.out.println(inline);

                JSONObject response = new JSONObject(inline);
                conn.disconnect();
                return response;

            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }




}
