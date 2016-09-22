/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wordpress.kuylim.controllers;

import com.wordpress.kuylim.model.User;
import com.wordpress.kuylim.repository.UserRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author KUYLIM
 */
@Controller
public class UserControll {
    
    @Autowired
    private UserRepo userRepo;
    
    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") int id)
    {
        User user = new User(id);
        userRepo.delete(user);
        return "redirect:/";
    }
    
    @RequestMapping(value = "/update/{id}")
    public String update(@PathVariable("id") int id, ModelMap model)
    {
        User user;
        user = userRepo.getById(id);
        model.addAttribute("User", user);
        return "user-update";
    }
    
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(User user)
    {
        userRepo.update(user);
        return "redirect:/";
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(User user)
    {
        userRepo.add(user);
        System.out.println(user.getRole().get(0).getRole());
        return "redirect:/";
    }
    
    @RequestMapping(value = "/add-user")
    public String useradd()
    {
        return "user-add";
    }
    
    @RequestMapping("/")
    public String index(ModelMap model) {
        List<User> user = userRepo.getAll();   
        model.addAttribute("User", user);
        return "user";     
    }
}
