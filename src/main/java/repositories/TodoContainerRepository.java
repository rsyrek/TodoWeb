package repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entities.Todo;

@Repository
@Transactional
public class TodoContainerRepository {
	private List<Todo> todoList = new ArrayList<Todo>();
	
	public List<Todo> findAll(){
		return todoList;
	}
	
	public Todo findTaskById(long id){
		System.err.println("in contener js");
		int index = 0;
		Todo task = new Todo();
		task.setId(1);
		task.setText("tekstauto");
		task.setDone(true);
		todoList.add(task);
		for(Todo t : todoList){
			if(t.getId() == id) break;
			index++;
		}
		return todoList.get(index);
	}
	
	public boolean addTask(long id, String text, boolean done){
		System.out.println("In ccontainer add");
		Todo task = new Todo();
		task.setId(id);
		task.setText(text);
		task.setDone(done);
		return todoList.add(task);
	}
}
