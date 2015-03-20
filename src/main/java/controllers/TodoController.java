package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import services.TaskService;
import entities.Todo;

@Controller
@RequestMapping(value = "/app")
public class TodoController {
	
	@Autowired
    private TaskService taskService;
	
	private Todo task = new Todo();

    @RequestMapping(value = "/show/{name}")
    @ResponseBody
    public String showWhatToDo(@PathVariable String name) {
        return taskService.showTask(name);
    }
    
    @RequestMapping(value = "/done/{name}")
    @ResponseBody
    public String showWhatWasDone(@PathVariable String name) {
        return taskService.doneTask(name);
    }
    
    @RequestMapping(value = "/task/{name}/done")
    @ResponseBody
    public String showTaskDone(@PathVariable String name) {
    	task.setDone(true);
    	task.setText(name);
        return task.toString();
    }
    
    @RequestMapping(value = "/task/{name}/undone")
    @ResponseBody
    public String showTaskUndone(@PathVariable String name) {
    	task.setDone(false);
    	task.setText(name);
        return task.toString();
    }
    
    @RequestMapping(value = "/add/{id}/{text}/{done}")
    @ResponseBody
    public String addTask(@PathVariable("id") long id, @PathVariable("text") String text, @PathVariable("done") boolean done) {
    	System.out.println("In controller add: " + text);
        return taskService.addElement(id, text, done);
    }
    
    @RequestMapping(value = "/show/all")
    @ResponseBody
    public List<Todo> showAll() {
        return taskService.showList();
    }
    
    @RequestMapping(value = "/showid/{id}")
    @ResponseBody
    public Todo showById(@PathVariable long id) {
        return taskService.showById(id);
    }
}