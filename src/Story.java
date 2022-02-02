public class Story {
    private String storyName;
    private String[] authors;
    private String[] developers;
    private StoryContent[] storyContents;

    public Story() {

    }
    public Story(String storyName, String[] authors, String[] developers, StoryContent[] storyContents) {
        //für die looks
        setStoryName(storyName);
        setAuthors(authors);
        setDevelopers(developers);
        setStoryContents(storyContents);
    }
    public static void StoryShow() {

    }

    //setter methods
    public void setStoryName(String storyName) {this.storyName = storyName;}
    public void setAuthors(String[] authors) {this.authors = authors;}
    public void setDevelopers(String[] developers) {this.developers = developers;}
    public void setStoryContents(StoryContent[] storyContents) {this.storyContents = storyContents;}
    //getter methods
    public String getStoryName() {return this.storyName;}
    public String[] getAuthors() {return this.authors;}
    public String[] getDevelopers() {return this.developers;}
    public StoryContent[] getStoryContents() {return this.storyContents;}
    public StoryContent getStoryContent(int id) {return this.storyContents[id];}
}
