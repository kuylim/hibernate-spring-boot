/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wordpress.kuylim.model;


import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


/**
 *
 * @author KUYLIM
 */
@Entity
@Table(name="users")
@SuppressWarnings({"PersistenceUnitPresent"})
public class User implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @NotNull
    private String name;
    
    @NotNull
    private String email;
    
    @Embedded
    private Address address = new Address();
    
    // Collection Mapping
//    @ElementCollection
//    @CollectionTable(name="role", joinColumns = @JoinColumn(name="usrid"))
//    @Column(name = "role")
//    private List<String> role = new ArrayList<>();
    //====================================================================
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "usrid")
    private List<Role> roles = new ArrayList<>();
    
    public User() {}
    
    public User(int id) { 
        this.id = id;
    }
    
//    public User(String email, String name) {
//        this.email = email;
//        this.name = name;
//      }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * @return the role
     */
    public List<Role> getRole() {
        return roles;
    }

    /**
     * @param role the role to set
     */
    public void setRole(List<Role> role) {
        this.roles = role;
    }
}
