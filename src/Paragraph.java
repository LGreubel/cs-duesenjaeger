import com.google.gson.Gson;

public class Paragraph {
    private String paragraph;
    private String lookaround;
    private boolean isDone;
    private int id;

    public Paragraph(String paragraph, String lookaround, boolean isDone, int id) {
        setParagraph(paragraph);
        setLookaround(lookaround);
        setIsDone(isDone);
        setId(id);
    }

    //setter methods
    public void setParagraph(String paragraph) {this.paragraph = paragraph;}
    public void setLookaround(String lookaround) {this.lookaround = lookaround;}
    public void setIsDone(Boolean isDone) {this.isDone = isDone;}
    public void setId(int id) {this.id = id;}
    //getter methods
    public String getParagraph() {return this.paragraph;}
    public String getLookaround() {return this.lookaround;}
    public boolean getIsDone() {return this.isDone;}
    public int getId() {return this.id;}
}
