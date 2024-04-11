package zuhriddinscode.dto;

public class IconDTO {

    private String text;
    private boolean done;

    public boolean isDone() {
        return done;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public IconDTO(String text, boolean done) {
        this.text = text;
        this.done = done;
    }

    public IconDTO() {
    }

}