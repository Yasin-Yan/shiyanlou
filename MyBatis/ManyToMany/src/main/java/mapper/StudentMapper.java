package mapper;

import model.Student;
import model.StudentCourseLink;

import java.util.List;

public interface StudentMapper {
    /*
     * ��ѯ����ѧ�������ǵ�ѡ��γ̵���Ϣ
     * @return
     * @throws Exception
     */
    public List<Student> selectStudentCourse() throws Exception;

    /*
     * ɾ��ָ��id�û���ĳ�ſΣ����ݿγ�id����ѡ�����
     * @param StudentCourseLink
     * @throws Exception
     */
    public void deleteStudentCourseById(StudentCourseLink scLink) throws Exception;
}