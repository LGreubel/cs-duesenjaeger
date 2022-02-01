import java.util.ArrayList;

public class Story {
    public class Storycontent {
        private String location;
        private String content;
        private String view;
        private int id;

        public Storycontent(String location, String content, String view, int id) {
            setLocation(location);
            setContent(content);
            setView(view);
            setId(id);
        }
        //setter methods
        public void setLocation(String location) {this.location = location;}
        public void setContent(String content) {this.content = content;}
        public void setView(String view) {this.view = view;}
        public void setId(int id) {this.id = id;}
        //getter methods
        public String getLocation() {return this.location;}
        public String getContent() {return this.content;}
        public String getView() {return this.view;}
        public int getId() {return this.id;}
    }
    private String storyName;
    private String[] authors;
    private String[] developers;
    public ArrayList<Storycontent> storyContents = new ArrayList<Storycontent>();

    public Story(String storyName, String[] authors, String[] developers) {
        setStoryName(storyName);
        setAuthors(authors);
        storyContents.add(new Story.Storycontent("","","",0));
        storyContents.add(new Story.Storycontent("","","",1));
        storyContents.add(new Story.Storycontent("","","",2));
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
