package com.notebook.dao;

import com.notebook.entity.Contacts;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by root on 1/27/18.
 */
public interface ContactsDao extends CrudRepository<Contacts, Long> {

     List<Contacts> findContactsByPhone(String phone);

     List<Contacts> findContactsByName(String name);

    List<Contacts> findContactsByLastName(String lastName);
}
