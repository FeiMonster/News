package monster.com.gdcpformonster.bean;

/**
 * Created by ASUS on 2017/5/12.
 */

public class News {
    private int image_path;
    private String title;
    private String date;
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImage_path() {
        return image_path;
    }

    public void setImage_path(int image_path) {
        this.image_path = image_path;
    }


    public News(int image_path,String title,String date){
        this.image_path = image_path;
        this.title = title;
        this.date = date;
    }
}
