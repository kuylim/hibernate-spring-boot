/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wordpress.kuylim.repository;

import com.wordpress.kuylim.model.User;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author KUYLIM
 */
@Repository
@Transactional
public class UserRepo {
    
    @Autowired
    private SessionFactory sessionFactory;
    
    private Session getSession()
    {
        
        return sessionFactory.getCurrentSession();
    }
    
    public void add(User user)
    {
        getSession().save(user);
    }
    
    public void delete(User user)
    {
        getSession().delete(user);
    }
    
    @SuppressWarnings("unchecked")
	public List<User> getAll()
    {
        return (List<User>) getSession().createQuery("from User").list();
    }
    
    public void update (User user)
    {
        getSession().update(user);
    }
    
    public User getById(int id)
    {
        return (User) getSession().get(User.class, id);
    }
}
