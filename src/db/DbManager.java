/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Course;
import model.Student;
import model.Teacher;
import model.TeacherCourse;

/**
 *
 * @author asaad
 */
public class DbManager {
    
    public static List<Student> getAllStudents(){
        List<Student> studentList =  new ArrayList<>();
        try{
            PreparedStatement pst =DbConnection.getInstance().prepareStatement("SELECT * FROM student");
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Student student = new Student();
                student.setId(rs.getLong(1));
                student.setCity(rs.getString("city"));
                student.setCountry(rs.getString("country"));
                student.setName(rs.getString("name"));
                student.setGender(rs.getString("gender"));
                student.setDob(rs.getString("date_of_birth"));
                student.setPhoneNumber(rs.getString("phone_number"));
                student.setCategory(rs.getString("category"));
                studentList.add(student);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return studentList;
    }
    
    
    public static Boolean saveStudent(Student student){
                    Boolean flag = false;
        try{
            if(student!=null){
                PreparedStatement ps = DbConnection.getInstance().prepareStatement("Insert Into `student`(city,country,date_of_birth,gender,name,category,phone_number) "
                        + "values(?,?,?,?,?,?,?)");
                ps.setString(1, student.getCity());
                ps.setString(2, student.getCountry());
                ps.setString(3, student.getDob());
                ps.setString(4, student.getGender());
                ps.setString(5, student.getName());
                ps.setString(6, student.getCategory());
                ps.setString(7,student.getPhoneNumber());
                ps.executeUpdate();
                flag = true;
            }
       }
        catch(Exception e){
            e.printStackTrace();
           
        }
        
        return flag;
    }
    public static Integer getTotalStudents(){
        Integer count = 0;
        try{
                PreparedStatement ps = DbConnection.getInstance().prepareStatement("select COUNT(*) as count from student");
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    count = rs.getInt("count");
                }
          
       }
        catch(Exception e){
            e.printStackTrace();
           
        }
        return count;
    }
    public static Integer getTotalCourses(){
        Integer count = 0;
        try{
                PreparedStatement ps = DbConnection.getInstance().prepareStatement("select COUNT(*) as count from course");
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    count = rs.getInt("count");
                }
          
       }
        catch(Exception e){
            e.printStackTrace();
           
        }
        return count;
    }
    
    public static Integer getTotalTeachers(){
        Integer count = 0;
        try{
                PreparedStatement ps = DbConnection.getInstance().prepareStatement("select COUNT(*) as count from teacher");
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    count = rs.getInt("count");
                }
          
       }
        catch(Exception e){
            e.printStackTrace();
           
        }
        return count;
    }

    public static Boolean saveCourse(Course course) {
       Boolean flag = false;
        try{
            if(course!=null){
                PreparedStatement ps = DbConnection.getInstance().prepareStatement("Insert Into `course`(course_name,total_lectures,course_category) "
                        + "values(?,?,?)");
                ps.setString(1, course.getCourseName());
                ps.setInt(2, course.getTotalLectures());
                ps.setString(3, course.getCourseCategory());
                ps.executeUpdate();
                flag = true;
            }
       }
        catch(Exception e){
            e.printStackTrace();
           
        }
        
        return flag;
    }
    public static List<Course> getAllCourse(){
        List<Course> courseList =  new ArrayList<>();
        try{
            PreparedStatement pst =DbConnection.getInstance().prepareStatement("SELECT * FROM course");
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Course course = new Course();
                course.setId(rs.getLong(1));
                course.setCourseName(rs.getString("course_name"));
                course.setCourseCategory(rs.getString("course_category"));
                course.setTotalLectures(rs.getInt("total_lectures"));

                courseList.add(course);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return courseList;
    }

    public static Boolean saveTeacher(Teacher teacher) {
        Boolean flag = false;
        try{
            if(teacher!=null){
                PreparedStatement ps = DbConnection.getInstance().prepareStatement("Insert Into `teacher`(qualification,address,name,salary) "
                        + "values(?,?,?,?)");
                ps.setString(1, teacher.getQualification());
                ps.setString(2, teacher.getAddress());
                ps.setString(3, teacher.getName());
                ps.setLong(4, teacher.getSalary());
                ps.executeUpdate();
                flag = true;
            }
       }
        catch(Exception e){
            e.printStackTrace();
           
        }
        
        return flag;
    }
    public static List<Teacher> getAllTeachers(){
        List<Teacher> teacherList =  new ArrayList<>();
        try{
            PreparedStatement pst =DbConnection.getInstance().prepareStatement("SELECT * FROM teacher");
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Teacher teacher = new Teacher();
                teacher.setId(rs.getLong(1));
                teacher.setName(rs.getString("name"));
                teacher.setQualification(rs.getString("qualification"));
                teacher.setAddress(rs.getString("address"));
                teacher.setSalary(rs.getLong("salary"));

                teacherList.add(teacher);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return teacherList;
    }
    
    public static Teacher getTeacherByNameOrId(String name, String id){
        Teacher teacher = new Teacher();
        try{
            PreparedStatement pst = null;
            if(id!=null && !id.equals("")){
                                                pst =DbConnection.getInstance().prepareStatement("SELECT * FROM teacher where id = ?");
                                           pst.setLong(1, Long.parseLong(id));
            }
            else
            {
                pst =DbConnection.getInstance().prepareStatement("SELECT * FROM teacher where name = ?");
                           pst.setString(1, name);

            }
            
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                teacher.setId(rs.getLong(1));
                teacher.setName(rs.getString("name"));
                teacher.setQualification(rs.getString("qualification"));
                teacher.setAddress(rs.getString("address"));
                teacher.setSalary(rs.getLong("salary"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    return teacher;
    }
    
    public static Course getCourseByNameOrId(String name,String id){
       Course course = new Course();
    
        try{
            PreparedStatement pst = null;
            if(id!=null && !id.equals("")){
                                pst =DbConnection.getInstance().prepareStatement("SELECT * FROM course where id = ?");
                           pst.setLong(1,Long.parseLong(id));
                
            }
            else
            {

                pst =DbConnection.getInstance().prepareStatement("SELECT * FROM course where course_name = ?");
                pst.setString(1, name);
            }

            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                course.setId(rs.getLong(1));
                course.setCourseName(rs.getString("course_name"));
                course.setCourseCategory(rs.getString("course_category"));
                course.setTotalLectures(rs.getInt("total_lectures"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    return course;
    }

    public static Boolean saveTeacherCourse(TeacherCourse tc) {
        Boolean flag = false;
        try{
            if(tc!=null){
                PreparedStatement ps = DbConnection.getInstance().prepareStatement("Insert Into `teacher_course`(teacher_id,course_id) "
                        + "values(?,?)");
                ps.setLong(1, tc.getTeacher().getId());
                ps.setLong(2, tc.getCourse().getId());
                ps.executeUpdate();
                flag = true;
            }
       }
        catch(Exception e){
            e.printStackTrace();
           
        }
        
        return flag;
    }
     public static List<TeacherCourse> getAllTeacherCourse(){
        List<TeacherCourse> teacherCourses =  new ArrayList<>();
        try{
            PreparedStatement pst =DbConnection.getInstance().prepareStatement("SELECT * FROM teacher_course");
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                TeacherCourse teacherCourse = new TeacherCourse();
                teacherCourse.setId(rs.getLong(1));
                teacherCourse.setCourse(getCourseByNameOrId(null, rs.getString("course_id")));
                teacherCourse.setTeacher(getTeacherByNameOrId(null, rs.getString("teacher_id")));
                

                teacherCourses.add(teacherCourse);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return teacherCourses;
    }

}
