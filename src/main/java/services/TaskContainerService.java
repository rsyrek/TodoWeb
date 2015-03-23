package services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.Todo;
import repositories.TodoContainerRepository;

@Service
public class TaskContainerService {
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
		if(todoContainer.addTask(id, text, done)){
			return "Added task with id: " + id;
		}
		else{
			return "Adding fail";
		}
	}
	
	public Todo showById(long id){
		return todoContainer.findTaskById(id);
	}

	public void addMany(long howMany) {
		long index = 0;
		while(index++ < howMany){
			todoContainer.addTask(index, "Zadanie " + index, index % 2 == 0);
		}
	}
}
