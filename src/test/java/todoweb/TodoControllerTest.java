package todoweb;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import services.TaskService;
import controllers.TodoController;

@RunWith(MockitoJUnitRunner.class)
public class TodoControllerTest {
	@Mock
    private TaskService service;
    
	@InjectMocks
    private TodoController todoController;
    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(todoController).build();
        
    }
    @Test
    public void shouldCallShowByIdOnServiceWithGivenId() throws Exception {
//        mockMvc.perform(get("/app/showid/3")).andExpect(matcher);
//        Mockito.verify(service).showById(3);
    }
}
