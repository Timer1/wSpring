package cn.bugstack.springframework.test.bean;

import java.util.HashMap;
import java.util.Map;

public class UserDao {
    private static Map<String,String> hashmap = new HashMap<>();

    static {
        hashmap.put("1","A");
        hashmap.put("2","B");
        hashmap.put("3","C");
    }

    public String queryUserName(String uId){
        return hashmap.get(uId);
    }
}
