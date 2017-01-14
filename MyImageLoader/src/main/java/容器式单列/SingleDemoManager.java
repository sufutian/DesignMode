package 容器式单列;

import java.util.HashMap;

/**
 * Created by sufutian on 2016/11/10/11:24.
 */


/**
 * 管理类 来管理单列
 */

public class SingleDemoManager {

    private static HashMap<String,Object> hashMap=new HashMap<>();

    private SingleDemoManager(){};

    /**
     * 注册一次
     * @param key
     * @param object
     */
    public static void registerService(String key,Object object){
        if(!hashMap.containsKey(key)){
            hashMap.put(key,object);
        }
    }

    /**
     * 获取
     * @param key
     * @return
     */
    public static Object getSystemServcie(String key){
        return hashMap.get(key);
    }
}
