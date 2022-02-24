/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.natsystem.service;

import fr.natsystem.entity.Todo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author formation10
 */
public class TodoService {
    
    @PersistenceContext
    EntityManager entityManager;
    
    public Todo createTodo(Todo todo){
        entityManager.persist(todo);
 
        return todo;
    }
    
     public Todo updateTodo(Todo todo){
        entityManager.merge(todo);
 
        return todo;
    }
     
    public Todo findTodoById(Long id){
       return entityManager.find(Todo.class, id);
    }
    
     public List<Todo> getTodos(Long id){
       return entityManager.createQuery("SELECT t from Todo t", Todo.class).getResultList();
    }
    
}
