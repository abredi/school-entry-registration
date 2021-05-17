package com.reziz.studentregistration.faculty.repository;


import com.reziz.studentregistration.faculty.domain.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty,Long> {
////@Query("select f from Faculty f where f.email=:email")
//
//    List<Faculty> findAllByEmail(String email);


}

