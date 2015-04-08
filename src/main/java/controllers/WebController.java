package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import services.TaskService;
import entities.Todo;

@Controller
@RequestMapping(value = "/web")
public class WebController {

	@Autowired
    private TaskService taskService;
	
	@RequestMapping(value = "/add/{text}/{done}")
    public String addTask(@PathVariable("text") String text, @PathVariable("done") boolean done) {
    	taskService.addElement(text, done);
    	return "redirect:/web/page";
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
    
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteDone(){
    	taskService.deleteDoneData();
    	return "redirect:/web/page";
    }
    
    
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public String showOnPage(Model model) {
    	List<Todo> todoList = taskService.showAll();
    	model.addAttribute("todoList", todoList);
        return "page13";
    }
    
    @RequestMapping(value = "/page", method = RequestMethod.POST)
    public String addFromPage(String text) {
    	System.err.println("nie to");
    	taskService.addElement(text, false);
    	return "redirect:/web/page";
    }
    
    @RequestMapping(value = "/page/update", method = RequestMethod.GET)
    public String updateFromPage(@RequestParam(value="chckTodo", required=false) Long[] toChange) {
    	taskService.updateElements(toChange);
    	return "redirect:/web/page";
    }
}
