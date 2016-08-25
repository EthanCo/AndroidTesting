package com.ethanco.myprojecttest;

import com.ethanco.myprojecttest.concrete.StuController;
import com.ethanco.myprojecttest.concrete.Student;
import com.ethanco.myprojecttest.concrete.StudentDAO;

import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by EthanCo on 2016/8/24.
 */
public class ConcreteTest {
    private StuController mController;
    private StudentDAO mStuDao;

    @Before
    public void setUp() throws Exception {
        mController = new StuController();
        mStuDao = mock(StudentDAO.class);
        //注入对象
        mController.setmStudentDAO(mStuDao);
    }

    @Test
    public void testGetStudentInfo() {
        Student returnStudent = new Student();
        returnStudent.id = 123;
        returnStudent.name = "mock-user";

        //调用getStudentFromDB时返回returnStudent对象
        when(mStuDao.getStudentFromDB(anyInt())).thenReturn(returnStudent);

        //调用getStudentInfo
        Student student = mController.getStudentInfo(123);
        //验证数据
        assertEquals(student.id, 123);
        assertEquals(student.name, "mock-user");
    }

    @Test
    public void testGetStudentInfoFromServer() {
        //调用getStudentFromDB时返回null
        when(mStuDao.getStudentFromDB(anyInt())).thenReturn(null);
        //调用getStudentInfo
        Student student = mController.getStudentInfo(456);
        //验证数据
        assertEquals(student.id, 456);
        assertEquals(student.name, "server-user");
    }

    @Test
    public void testCaptureParam() {
        //注意:创建一个Mock对象
        StuController mockController = mock(StuController.class);

        doAnswer(new Answer<Void>() {

            @Override
            public Void answer(InvocationOnMock invocation) throws Throwable {
                int studentId = (Integer) invocation.getArguments()[0];
                System.out.println("学生id:" + studentId);
                assertEquals(666, studentId);
                return null;
            }
        }).when(mockController).getStudentInfo(anyInt());

        mockController.getStudentInfo(666);
    }
}
