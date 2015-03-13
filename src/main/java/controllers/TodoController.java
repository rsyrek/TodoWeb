package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import entities.Todo;
import services.TaskService;

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
    
    @RequestMapping(value = "/taskdone/{name}")
    @ResponseBody
    public String showTaskDone(@PathVariable String name) {
    	task.setDone(true);
    	task.setText(name);
        return task.toString();
    }
    
    @RequestMapping(value = "/taskundone/{name}")
    @ResponseBody
    public String showTaskUndone(@PathVariable String name) {
    	task.setDone(false);
    	task.setText(name);
        return task.toString();
    }
    
}