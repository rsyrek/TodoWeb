package todoweb;

import org.fest.assertions.Assertions;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import entities.Todo;
import repositories.TodoRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
@Transactional
public class TodoRepositoryTest {
   
	@Autowired
    private TodoRepository repository;

	@Test
    public void shouldFindOneElementAfterPersist() {
		Todo todo = new Todo();
		todo.setText("tekst");
		todo.setDone(true);
        repository.addTodo(todo);
        Assert.assertThat(repository.findAll(), Matchers.hasSize(1));
    }
	
	@Test
    public void shouldFindOneElementAfterMerge() {
		Todo todo = new Todo();
		todo.setText("tekst");
		todo.setDone(true);
        repository.saveTodo(todo);
        Assert.assertThat(repository.findAll(), Matchers.hasSize(1));
    }

	@Test
    public void shouldFindTodoWithId3() {
		long id = 0;
		int index = 0;
		while (index ++ < 3){
			Todo todo = new Todo();
			todo.setText("Zadanie " + index);
			todo.setDone(true);
	        id = repository.addTodo(todo);
		}
		Assertions.assertThat(repository.getById(id).getId()).isEqualTo(id);
    }
    
	@Test
	public void shouldClearTable(){
		Todo todo = new Todo();
		todo.setText("tekst");
		todo.setDone(true);
        repository.addTodo(todo);
        Assertions.assertThat(repository.findAll()).isNotEmpty();
        repository.clearTable();
        Assertions.assertThat(repository.findAll()).isEmpty();
	}
	
	@Test
	public void shouldDeleteOneTodo(){
		long id;
		int startSize;
		Todo todo = new Todo();
		todo.setText("tekst");
		todo.setDone(true);
		id = repository.addTodo(todo);
		startSize = repository.findAll().size();
		repository.deleteTodoId(id);
		Assertions.assertThat(repository.findAll().size() + 1).isEqualTo(startSize);
	}

	@Test
	public void shouldUpdateTask(){
		long id;
		Todo todo = new Todo();
		todo.setText("tekst");
		todo.setDone(true);
		id = repository.addTodo(todo);
		System.out.println(todo);
		repository.updateTodo(id, false);
		System.out.println(repository.getById(id));
		Assertions.assertThat(repository.getById(id).getDone()).isEqualTo(false);
	}
	
	@Test
	public void shouldDeleteDoneTodos(){
		Assertions.assertThat(repository.findAll()).isEmpty();
		repository.addTodo(new Todo("tekst", true));
		repository.addTodo(new Todo("tekst2", false));
		Assertions.assertThat(repository.findAll().size()).isEqualTo(2);
		repository.deleteDoneTodo();
		Assertions.assertThat(repository.findAll().size()).isEqualTo(1);
	}
}
