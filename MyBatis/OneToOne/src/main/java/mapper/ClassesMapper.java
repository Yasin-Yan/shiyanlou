package mapper;

import model.Classes;

public interface ClassesMapper {

    /*
     * 根据 id 查询班级 Classes
     * @param id
     * @return
     * @throws Exception
     */
    public Classes selectClassById(Integer id) throws Exception;

}
