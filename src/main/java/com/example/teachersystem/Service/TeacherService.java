package com.example.teachersystem.Service;

import com.example.teachersystem.Api.ApiException;
import com.example.teachersystem.Model.Teacher;
import com.example.teachersystem.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public List<Teacher> getAll() {
        return teacherRepository.findAll();
    }

    public void add(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    public void update(Teacher teacher) {
        Teacher oldTeacher = teacherRepository.findTeacherById(teacher.getId());
        if (oldTeacher == null)
            throw new ApiException("teacher not found");

        oldTeacher.setName(teacher.getName());
        oldTeacher.setAge(teacher.getAge());
        oldTeacher.setEmail(teacher.getEmail());
        oldTeacher.setSalary(teacher.getSalary());

        teacherRepository.save(oldTeacher);
    }

    public void delete(Integer id) {
        Teacher teacher = teacherRepository.findTeacherById(id);
        if (teacher == null)
            throw new ApiException("teacher not found");

        teacherRepository.delete(teacher);
    }


    public Teacher getTeacherById(Integer id){
        Teacher teacher = teacherRepository.findTeacherById(id);
        if (teacher == null)
            throw new ApiException("teacher not found");

        return teacher;
    }
}
