package monster.com.gdcpformonster.bean;

import java.util.List;

/**
 * Created by ASUS on 2017/5/10.
 */

public class NewsBean {

    /**
     * reason : 成功的返回
     * result : {"stat":"1","data":[{"uniquekey":"bb61c44011b32faac0af6a51ccdf73a6","title":"五月底有横财飞入,大喜临门的四大生肖","date":"2017-05-10 14:04","category":"头条","author_name":"星座占卜","url":"http://mini.eastday.com/mobile/170510140432313.html","thumbnail_pic_s":"http://04.imgmini.eastday.com/mobile/20170510/20170510_29277cd523ad94dfbda2ffb47f897ae9_mwpm_03200403.jpg","thumbnail_pic_s02":"http://04.imgmini.eastday.com/mobile/20170510/20170510_27d564756fc30a8e7c7455c359a912ac_mwpm_03200403.jpg","thumbnail_pic_s03":"http://04.imgmini.eastday.com/mobile/20170510/20170510_ed70c8a81aff5ee6fc7f430fa49f1b0f_mwpm_03200403.jpg"}]}
     * error_code : 0
     */

    private String reason;
    /**
     * stat : 1
     * data : [{"uniquekey":"bb61c44011b32faac0af6a51ccdf73a6","title":"五月底有横财飞入,大喜临门的四大生肖","date":"2017-05-10 14:04","category":"头条","author_name":"星座占卜","url":"http://mini.eastday.com/mobile/170510140432313.html","thumbnail_pic_s":"http://04.imgmini.eastday.com/mobile/20170510/20170510_29277cd523ad94dfbda2ffb47f897ae9_mwpm_03200403.jpg","thumbnail_pic_s02":"http://04.imgmini.eastday.com/mobile/20170510/20170510_27d564756fc30a8e7c7455c359a912ac_mwpm_03200403.jpg","thumbnail_pic_s03":"http://04.imgmini.eastday.com/mobile/20170510/20170510_ed70c8a81aff5ee6fc7f430fa49f1b0f_mwpm_03200403.jpg"}]
     */

    private ResultBean result;
    private int error_code;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public static class ResultBean {
        private String stat;
        /**
         * uniquekey : bb61c44011b32faac0af6a51ccdf73a6
         * title : 五月底有横财飞入,大喜临门的四大生肖
         * date : 2017-05-10 14:04
         * category : 头条
         * author_name : 星座占卜
         * url : http://mini.eastday.com/mobile/170510140432313.html
         * thumbnail_pic_s : http://04.imgmini.eastday.com/mobile/20170510/20170510_29277cd523ad94dfbda2ffb47f897ae9_mwpm_03200403.jpg
         * thumbnail_pic_s02 : http://04.imgmini.eastday.com/mobile/20170510/20170510_27d564756fc30a8e7c7455c359a912ac_mwpm_03200403.jpg
         * thumbnail_pic_s03 : http://04.imgmini.eastday.com/mobile/20170510/20170510_ed70c8a81aff5ee6fc7f430fa49f1b0f_mwpm_03200403.jpg
         */

        private static List<DataBean> data;

        public String getStat() {
            return stat;
        }

        public void setStat(String stat) {
            this.stat = stat;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            private String uniquekey;
            private String title;
            private String date;
            private String category;
            private String author_name;
            private String url;
            private String thumbnail_pic_s;
            private String thumbnail_pic_s02;
            private String thumbnail_pic_s03;

            public String getUniquekey() {
                return uniquekey;
            }

            public void setUniquekey(String uniquekey) {
                this.uniquekey = uniquekey;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getCategory() {
                return category;
            }

            public void setCategory(String category) {
                this.category = category;
            }

            public String getAuthor_name() {
                return author_name;
            }

            public void setAuthor_name(String author_name) {
                this.author_name = author_name;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getThumbnail_pic_s() {
                return thumbnail_pic_s;
            }

            public void setThumbnail_pic_s(String thumbnail_pic_s) {
                this.thumbnail_pic_s = thumbnail_pic_s;
            }

            public String getThumbnail_pic_s02() {
                return thumbnail_pic_s02;
            }

            public void setThumbnail_pic_s02(String thumbnail_pic_s02) {
                this.thumbnail_pic_s02 = thumbnail_pic_s02;
            }

            public String getThumbnail_pic_s03() {
                return thumbnail_pic_s03;
            }

            public void setThumbnail_pic_s03(String thumbnail_pic_s03) {
                this.thumbnail_pic_s03 = thumbnail_pic_s03;
            }
        }
    }
}