package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping(value = "/add/{text}/{done}", method = RequestMethod.GET)
    public String addTask(@PathVariable("text") String text, @PathVariable("done") boolean done) {
    	taskService.addElement(text, done);
    	return "redirect:/db/show";
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
}
