package todoweb;

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
public class TodoRepositoryTest {
    
	@Autowired
    private TodoRepository repository;

	@Test
    @Transactional
    public void shouldFindOneElementAfterPersist() {
		Todo todo = new Todo();
		todo.setText("tekst");
		todo.setDone(true);
        repository.addTodo(todo);
        Assert.assertThat(repository.findAll(), Matchers.hasSize(1));
    }
	
	@Test
    @Transactional
    public void shouldFindOneElementAfterMerge() {
		Todo todo = new Todo();
		todo.setText("tekst");
		todo.setDone(true);
        repository.saveTodo(todo);
        Assert.assertThat(repository.findAll(), Matchers.hasSize(1));
    }

	@Test
    @Transactional
    public void shouldFindTodoWithId3() {
		int index = 0;
		while (index ++ < 3){
			Todo todo = new Todo();
			todo.setText("Zadanie " + index);
			todo.setDone(true);
	        repository.addTodo(todo);
		}
        Assert.assertTrue(repository.getById(3).getId() == 3);
    }
    
	
//	@Before
//    public void setUp() {
//        mockMvc = MockMvcBuilders.standaloneSetup(repository).build();
//        
//    }
//    @Test
//    public void shouldAdd1TaskAndReturnListOf1() throws Exception {
//        mockMvc.perform(get("/db/add/tekst/true")).andExpect(status.isOK).andExpect(MockMvcResultMatchers.content().string("I have to do that: NAME"));
//    }
//    
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
