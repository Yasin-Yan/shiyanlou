package mapper;

import model.Classes;

public interface ClassesMapper {

    /*
     * ���� id ��ѯ�༶ Classes ������ѧ��
     * @param id
     * @return
     * @throws Exception
     */
    public Classes selectClassAndStudentsById(Integer id) throws Exception;

}