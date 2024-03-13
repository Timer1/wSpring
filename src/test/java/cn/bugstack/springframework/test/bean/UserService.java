package cn.bugstack.springframework.test.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserService {
    private String uId;

    private UserDao userDao;

    public void queryUserInfo(){
        System.out.println("userInfo:" + userDao.queryUserName(uId));
    }

    public String queryUserName(){
        return userDao.queryUserName(uId);
    }
}
