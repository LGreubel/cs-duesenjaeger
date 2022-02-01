import java.util.ArrayList;

public class Story {
    public static class Storycontent {
        private String location;
        private String content;
        private String contentGO;
        private String contentUSE;
        private String contentTALK;
        private String contentTAKE;
        private String view;
        private int id;

        public Storycontent() {

        }
        public Storycontent(String location, String content, String contentGO, String contentUSE,
                            String contentTALK, String contentTAKE, String view, int id) {
            setLocation(location);
            setContent(content);
            setContentGO(contentGO);
            setContentUSE(contentUSE);
            setContentTALK(contentTALK);
            setContentTAKE(contentTAKE);
            setView(view);
            setId(id);
        }

        //setter methods
        public void setLocation(String location) {this.location = location;}
        public void setContent(String content) {this.content = content;}
        public void setContentGO(String contentGO) {this.contentGO = contentGO;}
        public void setContentUSE(String contentUSE) {this.contentUSE = contentUSE;}
        public void setContentTALK(String contentTALK) {this.contentTALK = contentTALK;}
        public void setContentTAKE(String contentTAKE) {this.contentTAKE = contentTAKE;}
        public void setView(String view) {this.view = view;}
        public void setId(int id) {this.id = id;}
        //getter methods
        public String getLocation() {return this.location;}
        public String getContent() {return this.content;}
        public String getContentGO() {return this.contentGO;}
        public String getContentUSE() {return this.contentUSE;}
        public String getContentTALK() {return this.contentTALK;}
        public String getContentTAKE() {return this.contentTAKE;}
        public String getView() {return this.view;}
        public int getId() {return this.id;}
    }
    private String storyName;
    private String[] authors;
    private String[] developers;
    public ArrayList<Storycontent> storyContents = new ArrayList<Storycontent>();

    public Story() {

    }
    public Story(String storyName, String[] authors, String[] developers) {
        setStoryName(storyName);
        setAuthors(authors);
        setDevelopers(developers);
    }
    //setter methods
    public void setStoryName(String storyName) {this.storyName = storyName;}
    public void setAuthors(String authors[]) {this.authors = authors;}
    public void setDevelopers(String[] developers) {this.developers = developers;}
    //getter methods
    public String getStoryName() {return this.storyName;}
    public String[] getAuthors() {return this.authors;}
    public String[] getDevelopers() {return this.developers;}
}
