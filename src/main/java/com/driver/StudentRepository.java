package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {

    HashMap<String, Teacher> teacherHashMap = new HashMap<>();
    HashMap<String, Student> studentHashMap = new HashMap<>();
    HashMap<String, List<String>> teacherStudentPair = new HashMap<>();

    public void addStudent(Student student){

        studentHashMap.put(student.getName(),student);
    }

    public void addTeacher(Teacher teacher){

        teacherHashMap.put(teacher.getName(),teacher);
    }

    public void addStudentTeacherPair(String student, String teacher){

        if(studentHashMap.containsKey(student) && teacherHashMap.containsKey(teacher)){
            List<String> listOfStudents = teacherStudentPair.getOrDefault(teacher,new ArrayList<>());
            listOfStudents.add(student);
        }
    }

    public Student getStudentByName(String name){
        if (studentHashMap.containsKey(name))return studentHashMap.get(name);
        else return null;
    }

    public Teacher getTeacherByName(String name){
        if (teacherHashMap.containsKey(name))return teacherHashMap.get(name);
        else return null;
    }

    public List<String> getStudentsByTeacherName(String name){
        if(teacherStudentPair.containsKey(name))return teacherStudentPair.get(name);
        else return null;
    }

    public List<String> getAllStudents(){
        List<String> listOfStudents = new ArrayList<>(studentHashMap.keySet());
        return listOfStudents;
    }

    public void deleteTeacherByName(String teacher){
        if (teacherHashMap.containsKey(teacher)){
            teacherHashMap.remove(teacher);
        }
        if(teacherStudentPair.containsKey(teacher)){
            teacherStudentPair.remove(teacher);
        }
    }

    public void deleteAllTeachers(){
        teacherHashMap.clear();
        teacherStudentPair.clear();
    }
}
