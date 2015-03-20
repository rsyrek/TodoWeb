package todoweb;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import repositories.TodoContainerRepository;
import services.TaskService;
import controllers.TodoController;
@RunWith(MockitoJUnitRunner.class)
public class TodoControllerTest {
	@Spy
    private TaskService service;
    @InjectMocks
    private TodoController todoController;
    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(todoController).build();
        
    }
    @Test
    public void shouldFindById() throws Exception {
    	//mockMvc.perform(put("/app/add/1/teskt/true"));
        //mockMvc.perform(get("/app/add/2/drugi/false"));
        mockMvc.perform(get("/app/showid/1")).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().string("{\"id\":1,\"text\":\"tekstauto\",\"done\":true}"));
    }
}