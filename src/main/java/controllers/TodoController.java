package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import services.TaskService;
import entities.Todo;

@Controller
@RequestMapping(value = "/db")
public class TodoController {

	@Autowired
    private TaskService taskService;
	
	@RequestMapping(value = "/add/{text}/{done}")
    public void addTask(@PathVariable("text") String text, @PathVariable("done") boolean done) {
    	taskService.addElement(text, done);
    }
   
    @RequestMapping(value = "/showid/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Todo showById(@PathVariable long id) {
        return taskService.showById(id);
    }
    
    @RequestMapping(value = "/show", method = RequestMethod.GET)
    @ResponseBody
    public List<Todo> showAll() {
        return taskService.showAll();
    }
    
    @RequestMapping(value = "/addmany/{howMany}", method = RequestMethod.GET)
    public void addTasks(@PathVariable long howMany) {
        taskService.addMany(howMany);
    }
    
    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseBody
    public void clear(){
    	taskService.clearData();
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteId(@PathVariable long id){
    	taskService.deleteDataId(id);
    }
    
    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public Todo postJson(@RequestBody Todo todo){
    	todo.setId(taskService.addElement(todo.getText(), todo.getDone()));
    	return todo;
    }
   
    @RequestMapping(value = "/{id}/{done}", method = RequestMethod.PUT)
    @ResponseBody
    public void updateTodo(@PathVariable("id") long id, @PathVariable("done") boolean done){
    	taskService.updateElement(id, done);
    }
    
    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteDone(){
    	System.err.println("DOBRZE");
    	taskService.deleteDoneData();
    }
}
