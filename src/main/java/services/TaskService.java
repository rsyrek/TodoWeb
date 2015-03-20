package services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.Todo;
import repositories.TodoContainerRepository;

@Service
public class TaskService {
	@Autowired
	private TodoContainerRepository todoContainer;
	
	public String showTask(String name) {
        return "I have to do that: " + name;
    }

	public String doneTask(String name) {
		return "I have done that: " + name;
	}
	
	public List<Todo> showList(){
		return todoContainer.findAll();
	}
	
	public String addElement(long id, String text, boolean done){
		System.err.println(" id: " + id + " tekst: " + text + " done: " + done);
		if(todoContainer.addTask(id, text, done)){
			System.err.println("In service IF");
			return "Added task with id: " + id;
		}
		else{
			System.err.println("In service ELSE");
			return "Adding fail";
		}
	}
	
	public Todo showById(long id){
		System.err.println("in service js");
		return todoContainer.findTaskById(id);
	}
}
