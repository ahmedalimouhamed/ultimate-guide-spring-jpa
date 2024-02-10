package com.example.jpa.reposipories;

import com.example.jpa.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

    List<Author> findByNamedQuery(@Param("age") int age);

    @Transactional
    @Modifying
    void updateByNamedQuery(@Param("age") int age, @Param("id") int id);
    @Transactional
    @Modifying
    @Query("update Author a set a.age = :age where a.id = :id")
    int updateAuthor(int age, int id);

    //select * from author where first_name = fn
    List<Author> findAllByFirstName(String fn);
    List<Author> findAllByFirstNameIgnoreCase(String fn);

    //select * from author where first_name like %fn%
    List<Author> findAllByFirstNameContainingIgnoreCase(String fn);
    List<Author> findAllByFirstNameStartsWithIgnoreCase(String fn);
    List<Author> findAllByFirstNameEndsWithIgnoreCase(String fn);
}
