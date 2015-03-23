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
		int index = 0;
		for(Todo t : todoList){
			if(t.getId() == id) break;
			index++;
		}
		return todoList.get(index);
	}
	
	public boolean addTask(long id, String text, boolean done){
		Todo task = new Todo();
		task.setId(id);
		task.setText(text);
		task.setDone(done);
		return todoList.add(task);
	}
}
