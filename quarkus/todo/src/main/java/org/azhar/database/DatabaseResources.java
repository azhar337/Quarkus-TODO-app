package org.azhar.database;


import javax.inject.Singleton;
import java.util.List;

@Singleton
public class DatabaseResources {

    public boolean checkEmail(String email){
        return DatabaseRepository.find("email", email).list().isEmpty();
    }

    public List<DatabaseRepository> getTodoList (String email){
        return DatabaseRepository.find("email",email).list();
    }

    public boolean newTodoList ( DatabaseRepository todo){
        if(todo.email != null && todo.todo != null){
            DatabaseRepository.persist(todo);
            return todo.isPersistent();
        }
        return false;
    }


    public DatabaseRepository changeStatus(Long id, Boolean status){
        DatabaseRepository entity = DatabaseRepository.findById(id);
        entity.status = status;
        return entity;
    }

    public boolean deleteList(Long id){
        return DatabaseRepository.deleteById(id);
    }

}
