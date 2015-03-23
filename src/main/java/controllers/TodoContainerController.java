package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import services.TaskContainerService;
import entities.Todo;

@Controller
@RequestMapping(value = "/app")
public class TodoContainerController {
	
	@Autowired
    private TaskContainerService taskService;
	
    @RequestMapping(value = "/show/{name}")
    @ResponseBody
    public String showWhatToDo(@PathVariable String name) {
        return taskService.showTask(name);
    }
//    
//    @RequestMapping(value = "/done/{name}")
//    @ResponseBody
//    public String showWhatWasDone(@PathVariable String name) {
//        return taskService.doneTask(name);
//    }
//    
//    @RequestMapping(value = "/task/{name}/done")
//    @ResponseBody
//    public String showTaskDone(@PathVariable String name) {
//    	task.setDone(true);
//    	task.setText(name);
//        return task.toString();
//    }
//    
//    @RequestMapping(value = "/task/{name}/undone")
//    @ResponseBody
//    public String showTaskUndone(@PathVariable String name) {
//    	task.setDone(false);
//    	task.setText(name);
//        return task.toString();
//    }
    //On collection
    @RequestMapping(value = "/add/{id}/{text}/{done}")
    @ResponseBody
    public String addTask(@PathVariable("id") long id, @PathVariable("text") String text, @PathVariable("done") boolean done) {
        return taskService.addElement(id, text, done);
    }
    
    @RequestMapping(value = "/showall", method = RequestMethod.GET)
    @ResponseBody
    public List<Todo> showAll() {
        return taskService.showList();
    }
    
    @RequestMapping(value = "/showid/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Todo showById(@PathVariable long id) {
        return taskService.showById(id);
    }
    
    @RequestMapping(value = "/addmany/{howMany}", method = RequestMethod.GET)
    public void addTasks(@PathVariable long howMany) {
        taskService.addMany(howMany);
    }
}