package com.notebook.dao;

import com.notebook.entity.Contacts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by root on 1/27/18.
 */
@Repository
public interface ContactsDao extends JpaRepository<Contacts, Long> {

     List<Contacts> findContactsByPhone(String phone);

     List<Contacts> findContactsByName(String name);

    List<Contacts> findContactsByLastName(String lastName);

    @Transactional
    @Modifying
    @Query("UPDATE Contacts c set c.status= :status WHERE c.id= :id")
    void updateStatus(@Param("status") int status, @Param("id") long id);
}
