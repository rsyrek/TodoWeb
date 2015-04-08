package todoweb;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import services.TaskContainerService;
import controllers.TodoContainerController;
@RunWith(MockitoJUnitRunner.class)
public class TodoControllerContainerTest {
	@Spy
    private TaskContainerService service;
    
	@InjectMocks
    private TodoContainerController todoController;
    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(todoController).build();
        
    }
    @Test
    public void shouldShowName() throws Exception {
        mockMvc.perform(get("/app/show/NAME")).andExpect(MockMvcResultMatchers.content().string("I have to do that: NAME"));
    }
   
//    @Test
//    public void shouldShowDoneTask() throws Exception{
//    	mockMvc.perform(get("/app/task/NAME/done")).andExpect(MockMvcResultMatchers.content().string("Task 0: NAME is done"));
//    }
//    
//    @Test
//    public void shouldShowUnDoneTask() throws Exception{
//    	mockMvc.perform(get("/app/task/NAME/undone")).andExpect(MockMvcResultMatchers.content().string("Task 0: NAME is undone"));
//    }
}