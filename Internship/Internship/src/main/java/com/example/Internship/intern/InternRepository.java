package com.example.Internship.intern;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InternRepository extends CrudRepository<InternData,String> {
}
