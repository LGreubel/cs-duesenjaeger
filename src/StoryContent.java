public class StoryContent {
    private String location;
    private String content;
    private String contentGO;
    private String contentUSE;
    private String contentTALK;
    private String contentTAKE;
    private String view;
    private int[] id;

    public StoryContent() {

    }

    //setter methods
    public void setLocation(String location) {this.location = location;}
    public void setContent(String content) {this.content = content;}
    public void setContentGO(String contentGO) {this.contentGO = contentGO;}
    public void setContentUSE(String contentUSE) {this.contentUSE = contentUSE;}
    public void setContentTALK(String contentTALK) {this.contentTALK = contentTALK;}
    public void setContentTAKE(String contentTAKE) {this.contentTAKE = contentTAKE;}
    public void setView(String view) {this.view = view;}
    public void setId(int[] id) {this.id = id;}
    //getter methods
    public String getLocation() {return this.location;}
    public String getContent() {return this.content;}
    public String getContentGO() {return this.contentGO;}
    public String getContentUSE() {return this.contentUSE;}
    public String getContentTALK() {return this.contentTALK;}
    public String getContentTAKE() {return this.contentTAKE;}
    public String getView() {return this.view;}
    public int getId(int id) {return this.id[id];}
}