package com.educacionit.api.teachers.repositories;


import com.educacionit.api.teachers.entities.Teacher;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ITeacherRepository extends MongoRepository<Teacher, String> {
    Teacher findTeacherByEmailLike(String val);
}
