package mapper;

import model.Classes;

public interface ClassesMapper {

    /*
     * ���� id ��ѯ�༶ Classes
     * @param id
     * @return
     * @throws Exception
     */
    public Classes selectClassById(Integer id) throws Exception;

}
