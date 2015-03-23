package repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entities.Todo;

@Repository
@Transactional
public class TodoRepository {
	@PersistenceContext
    private EntityManager em;

    public List<Todo> findAll() {
        return em.createQuery("select t from Todo t", Todo.class).getResultList();
    }
    
    public Todo getById(long id){
    	return em.find(Todo.class, id);
    }
    
    public void saveTodo(Todo todo){
    	em.merge(todo);
    }
    
    public void addTodo(Todo todo){
    	em.persist(todo);
    }
}
