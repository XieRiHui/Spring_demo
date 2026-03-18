package com.example.demo.service;

import com.example.demo.converter.StudentConverter;
import com.example.demo.dao.Student;
import com.example.demo.dao.StudentRepository;
import com.example.demo.dto.StudentDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

import static com.example.demo.converter.StudentConverter.convertStudent;

//Service层

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public StudentDTO getStudentById(long id){
        Student student = studentRepository.findById(id).orElseThrow(RuntimeException::new);
        return convertStudent(student);
    }

    @Override
    public Long addNewStudent(StudentDTO studentDTO){
        List<Student> studentList = studentRepository.findByEmail(studentDTO.getEmail());
        if(!studentList.isEmpty()){
            throw new IllegalStateException("email: "+studentDTO.getEmail()+" already exists");
        }
        Student student = studentRepository.save(StudentConverter.convertStudentDTO(studentDTO));
        return student.getId();

    }

    @Override
    public void deleteStudentById(long id){
        studentRepository.findById(id).orElseThrow(()->new IllegalArgumentException("id:"+ id +" not found"));
        studentRepository.deleteById(id);
    }

    @Override
    @Transactional
    public StudentDTO updateStudentById(long id, String name, String email){
        Student studentInDB = studentRepository.findById(id).orElseThrow(()->new IllegalArgumentException("id:"+ id +" not found"));
        //检查name 和email 是否为空
        if(StringUtils.hasLength(name) && !studentInDB.getName().equals(name)){
            studentInDB.setName(name);
        }

        if(StringUtils.hasLength(email) && !studentInDB.getEmail().equals(email)){
            studentInDB.setEmail(email);
        }
        studentRepository.save(studentInDB);
        return convertStudent(studentInDB);

    }



}
