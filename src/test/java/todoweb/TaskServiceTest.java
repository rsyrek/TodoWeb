package todoweb;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import javax.servlet.ServletContext;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import entities.Todo;
import repositories.TodoRepository;
import services.TaskService;

@RunWith(MockitoJUnitRunner.class)
public class TaskServiceTest {
	@Mock
    private TodoRepository repository;
    
	@InjectMocks
    private TaskService service;

    @Test
    public void shouldShowTaskWithId2() throws Exception {
    	String text = "tekst";
		boolean done = true;
		
		service.addElement(text, done);
		Mockito.verify(repository).addTodo(new Todo(text, done));
    }
}
