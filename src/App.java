import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;

public class App {
    public static void main(String[] args) throws Exception {
        
        Transcript transcript = new Transcript();
        transcript.setAudio_url("https://github.com/BigOplO/REST_TEST/blob/main/Thirsty.mp4");
        Gson gson = new Gson();
        String jsonRequest = gson.toJson(transcript);

        HttpRequest postRequest = HttpRequest.newBuilder()
        .uri(new URI("https://api.assemblyai.com/v2/transcript"))
        .header("Authorization", "1bbb329fb5b8467fbe2eef577171dc2b")
        .POST(BodyPublishers.ofString(jsonRequest))
        .build();

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> postResopnse = httpClient.send(postRequest, BodyHandlers.ofString());
        System.out.println(postResopnse.body());

        transcript = gson.fromJson(postResopnse.body(), Transcript.class);

        System.out.println(transcript.getstatus());

         HttpRequest getRequest = HttpRequest.newBuilder()
        .uri(new URI("https://api.assemblyai.com/v2/transcript/" + transcript.getid()))
        .header("Authorization", "1bbb329fb5b8467fbe2eef577171dc2b")
        .build();

        


        while(true){
                HttpResponse<String> getResopnse = httpClient.send(getRequest, BodyHandlers.ofString());
             transcript = gson.fromJson(getResopnse.body(), Transcript.class);
            
             System.out.println(transcript.getstatus());

             if("completed".equals(transcript.getstatus())||"error".equals(transcript.getstatus()))
             break;

             Thread.sleep(1000);
        }

        System.out.println(transcript.gettext());

    }
}
