package services;


import org.springframework.stereotype.Service;

@Service
public class TaskService {
	public String showTask(String name) {
        return "I have to do that: " + name;
    }

	public String doneTask(String name) {
		return "I have done that: " + name;
	}
}
