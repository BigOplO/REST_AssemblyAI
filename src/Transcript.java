public class Transcript {
    private String audio_url;
    private String id;
    private String status;
    private String text;

    public String getAudio_url(){
        return audio_url;
    }

    public void setAudio_url(String audio_url){
        this.audio_url = audio_url;
    }

     public String getid(){
        return id;
    }

    public void setid(String id){
        this.id = id;
    }
     public String getstatus(){
        return status;
    }

    public void setstatus(String status){
        this.status = status;
    }
     public String gettext(){
        return text;
    }

    public void settext(String text){
        this.text = text;
    }
}
