package zuhriddinscode.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "to_do")
public class ToDoEntity {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "text")
    private String text;
    @Column(name = "done")
    private boolean done;

    public ToDoEntity() {
    }

    public ToDoEntity(Long id, String text, boolean done) {
        this.id = id;
        this.text = text;
        this.done = done;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
