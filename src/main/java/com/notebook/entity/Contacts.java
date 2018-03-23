package com.notebook.entity;

import javax.persistence.*;

/**
 * Created by root on 1/27/18.
 */
@Entity
@Table(name = "contacts")
public class Contacts {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="SEQ_CONTACTS")
    @SequenceGenerator(name = "SEQ_CONTACTS", sequenceName = "SEQ_CONTACTS")
    private long id;
    private String name;
    private String lastName;
    private String phone;
    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Contacts() { }

    public Contacts(long id) {
        this.id = id;
    }

    public Contacts(String name, String lastName, String phone, int status) {
        this.name = name;
        this.lastName = lastName;
        this.phone=phone;
        this.status=status;
    }
}
