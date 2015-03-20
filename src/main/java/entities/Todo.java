package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;





@Entity
public class Todo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String text;
	private boolean done;
	
	
	public long getId(){
		return id;
	}
	public String getText() {
		return text;
	}
	public boolean getDone() {
		return done;
	}
	public void setId(long id){
		this.id = id;
	}
	public void setDone(boolean done) {
		this.done = done;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	@Override
	public String toString(){
		String done = this.done ? "done" : "undone";
		return "Task " + id + ": " + this.text + " is " + done;
	}
}