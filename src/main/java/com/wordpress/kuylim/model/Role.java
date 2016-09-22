/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wordpress.kuylim.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author KUYLIM
 */
@Entity
@Table(name = "role")
public class Role implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int roleid;

    @NotNull
    @Column(name = "role")
    private String role;

    /**
     * @return the roleid
     */
    public int getRoleid() {
        return roleid;
    }

    /**
     * @param roleid the roleid to set
     */
    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    /**
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(String role) {
        this.role = role;
    }

}
