package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.Todo;
import repositories.TodoRepository;

@Service
public class TaskService {
	@Autowired
	private TodoRepository repository;
	
	public void addElement(String text, boolean done) {
		Todo todo = new Todo();
		todo.setText(text);
		todo.setDone(done);
		repository.addTodo(todo);
	}

	public Todo showById(long id) {
		return repository.getById(id);
	}

	public List<Todo> showAll() {
		return repository.findAll();
	}

	public void addMany(long howMany) {
		long index = 0;
		while(index++ < howMany){
			Todo todo = new Todo();
			todo.setText("Zadanie " + index);
			todo.setDone(index % 2 == 0);
			repository.addTodo(todo);
		}
	}
}
