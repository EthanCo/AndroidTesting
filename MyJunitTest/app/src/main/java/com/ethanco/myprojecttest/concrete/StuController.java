package com.ethanco.myprojecttest.concrete;

/**
 * @Description 业务逻辑控制类
 * Created by EthanCo on 2016/8/24.
 */
public class StuController {
    private StudentDAO mStudentDAO;

    public Student getStudentInfo(int sid) {
        Student student = null;
        if (mStudentDAO != null) {
            //从数据库中获取
            student = mStudentDAO.getStudentFromDB(sid);
        }
        if (student == null) {
            //从网络中获取
            student = fetchStudentInfo(sid);
        }
        return student;
    }

    private Student fetchStudentInfo(int sid) {
        System.out.println("从网络上获取学生信息");
        //模拟一个学生信息
        Student student = new Student();
        student.id = 456;
        student.name = "server-user";
        return student;
    }

    public void setmStudentDAO(StudentDAO mStudentDAO) {
        this.mStudentDAO = mStudentDAO;
    }
}
