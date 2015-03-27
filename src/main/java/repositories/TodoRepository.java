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
    
    public long addTodo(Todo todo){
    	em.persist(todo);
    	return todo.getId();
    }
    
    public void clearTable(){
    	em.createQuery("delete from Todo where 1 = 1").executeUpdate();
    }

	public void deleteTodoId(long id) {
		em.createQuery("delete from Todo where id = " + id).executeUpdate();
	}

	public void updateTodo(long id, boolean done) {
		em.find(Todo.class, id).setDone(done);
//		em.createQuery("update Todo set done = " + done + " where id = " + id).executeUpdate();
	}
	
	public void deleteDoneTodo() {
		em.createQuery("delete from Todo where done = 'true'").executeUpdate();
	}
}