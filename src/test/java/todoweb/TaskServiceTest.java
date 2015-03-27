package todoweb;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import repositories.TodoRepository;
import services.TaskService;
import entities.Todo;

@RunWith(MockitoJUnitRunner.class)
public class TaskServiceTest {
	@Mock
    private TodoRepository repository;
    
	@InjectMocks
    private TaskService service;

    @Test
    public void shouldCallAddTodoOnRepositoryWithGivenTodo() throws Exception {
    	String text = "tekst";
		boolean done = true;
		service.addElement(text, done);
		Mockito.verify(repository).addTodo(new Todo(text, done));
    }
    
    @Test
    public void shouldCallGetByIdOnRepositoryWithGivenId(){
    	long id = 3;
    	service.showById(id);
    	Mockito.verify(repository).getById(id);
    }
    
    @Test
    public void shouldCallDeleteTodoIdOnRepositoryWithGivenId(){
    	long id = 3;
    	service.deleteDataId(id);
    	Mockito.verify(repository).deleteTodoId(id);
    }
    
    @Test
    public void shouldCallUpdateTodoWithGivenIdAndDone(){
    	long id = 3;
    	boolean done = true;
    	service.updateElement(id, done);
    	Mockito.verify(repository).updateTodo(id, done);
    }
}
