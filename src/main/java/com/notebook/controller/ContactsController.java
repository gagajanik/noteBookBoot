package com.notebook.controller;

import com.notebook.dao.ContactsDao;
import com.notebook.entity.Contacts;
import com.notebook.entity.Users;
import com.notebook.model.CreateContactDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by root on 1/27/18.
 */
@RestController
@CrossOrigin
public class ContactsController {
    @Autowired
    private ContactsDao contactsDao;

    @RequestMapping(value = "/createContact", method = RequestMethod.POST)
    public void createContact(@RequestBody CreateContactDTO cont){
        String result="";
      try {
          Contacts contacts=new Contacts(cont.getName(), cont.getLastName(), cont.getPhone());
          contactsDao.save(contacts);
          result="DONE";
      }catch (Exception ex){
          System.err.println(ex);
          result="ERROR";
      }
      //return result;
    }

    @RequestMapping(value = "/deleteContact", method = RequestMethod.DELETE)
    public @ResponseBody String deleteContact(long id){
        String result="";
        try {
            Contacts contacts=new Contacts(id);
            contactsDao.delete(id);
            result="deleted";
        }catch (Exception ex){
            result="error";
            System.err.println(ex);
        }
        return result;
    }

    @RequestMapping(value = "/getByPhone", method = RequestMethod.GET)
    public @ResponseBody List<Contacts> getByPhone(String phone){
        List<Contacts> result=null;
        try {
         // Contacts contacts= (List<Contacts>) contactsDao.findContactsByPhone(phone);
          result= contactsDao.findContactsByPhone(phone);
        }catch (Exception ex){
            System.err.println(ex);
        }
        return  result;
    }

    @RequestMapping(value = "/getByName", method = RequestMethod.GET)
    public @ResponseBody List<Contacts> getByName(String name){
        List<Contacts> result=null;
        try {
            // Contacts contacts= (List<Contacts>) contactsDao.findContactsByPhone(phone);
            result= contactsDao.findContactsByName(name);
        }catch (Exception ex){
            System.err.println(ex);
        }
        return  result;
    }

    @RequestMapping(value = "/getByLastName", method = RequestMethod.GET)
    public @ResponseBody List<Contacts> getByLastName(String lastName){
        List<Contacts> result=null;
        try {
            // Contacts contacts= (List<Contacts>) contactsDao.findContactsByPhone(phone);
            result= contactsDao.findContactsByLastName(lastName);
        }catch (Exception ex){
            System.err.println(ex);
        }
        return  result;
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<Contacts> getAll(){
        List<Contacts> result=null;
        try {
             result= (List<Contacts>) contactsDao.findAll();
        }catch (Exception ex){
            System.err.println(ex);
        }
        return  result;
    }

    @RequestMapping(value = "/updateContact", method = RequestMethod.PUT)
    public @ResponseBody String updateContact(@RequestBody CreateContactDTO createContactDTO){
        String result="";
        try {
            Contacts contacts=contactsDao.findOne(createContactDTO.getId());
            contacts.setName(createContactDTO.getName());
            contacts.setLastName(createContactDTO.getLastName());
            contacts.setPhone(createContactDTO.getPhone());
            contactsDao.save(contacts);
            result="DONE";
        }catch (Exception ex){
            result="ERROR";
            System.out.println(ex.getMessage());
        }
        return result;
    }
    @RequestMapping("login")
    public String getPage(){
        return "index";
    }
}
