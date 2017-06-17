package monster.com.gdcpformonster.bean;

/**
 * Created by ASUS on 2017/5/15.
 */

public class VideoBean {
    private String context;
    private String date;
    private int videoImage;
    public VideoBean(String context,String date,int videoImage){
        this.context = context;
        this.date = date;
        this.videoImage = videoImage;
    }
    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public int getVideoImage() {
        return videoImage;
    }

    public void setVideoImage(int videoImage) {
        this.videoImage = videoImage;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


}
