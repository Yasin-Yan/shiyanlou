package mapper;

import java.util.List;

import model.User;

public interface UserMapper {

    /*
     * �����Ñ�
     * @param user
     * @return
     * @throws Exception
     */
    public int insertUser(User user) throws Exception;

    /*
     * �޸��Ñ�
     * @param user
     * @param id
     * @return
     * @throws Exception
     */
    public int updateUser(User user) throws Exception;

    /*
     * �h���Ñ�
     * @param id
     * @return
     * @throws Exception
     */
    public int deleteUser(Integer id) throws Exception;

    /*
     * ����id��ѯ�û���Ϣ
     * @param id
     * @return
     * @throws Exception
     */
    public User selectUserById(Integer id) throws Exception;

    /*
     * ��ѯ���е��û���Ϣ
     * @return
     * @throws Exception
     */
    public List<User> selectAllUser() throws Exception;
}