package cn.bugstack.springframework.test.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserService {
    private  String uId;

    private UserDao userDao;

    public String queryUserInfo(){
        return userDao.queryUserName(uId);
    }
}
