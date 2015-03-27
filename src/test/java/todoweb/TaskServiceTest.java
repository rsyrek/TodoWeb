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
    public void shouldShowTaskWithId2() throws Exception {
//    	Mockito.mock(TodoRepository.class);
    	String text = "tekst";
		boolean done = true;
		
		service.addElement(text, done);
		Mockito.verify(repository).addTodo(new Todo(text, done));
    }
}
