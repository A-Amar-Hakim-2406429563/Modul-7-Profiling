package com.advpro.profiling.tutorial.service;

import com.advpro.profiling.tutorial.model.Student;
import com.advpro.profiling.tutorial.model.StudentCourse;
import com.advpro.profiling.tutorial.repository.StudentCourseRepository;
import com.advpro.profiling.tutorial.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author muhammad.khadafi
 */
@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentCourseRepository studentCourseRepository;

    public List<StudentCourse> getAllStudentsWithCourses() {
        return studentCourseRepository.findAllWithStudentAndCourse();
    }

    public Optional<Student> findStudentWithHighestGpa() {
        return Optional.ofNullable(studentRepository.findTopByOrderByGpaDesc());
    }

    public String joinStudentNames() {
        List<Student> students = studentRepository.findAll();
        StringBuilder result = new StringBuilder();

        for (Student student : students) {
            result.append(student.getName()).append(", ");
        }

        if (result.length() > 0) {
            result.setLength(result.length() - 2); // hapus ", "
        }

        return result.toString();
    }
}

