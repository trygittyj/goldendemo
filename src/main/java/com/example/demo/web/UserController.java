package com.example.demo.web;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.User;

@RestController 
@RequestMapping(value="/users")     // 通过这里配置使下面的映射都在/users下 
public class UserController { 
 
    // 创建线程安全的Map 
    static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long, User>()); 
 
    @RequestMapping(value="/", method=RequestMethod.GET) 
    public List<User> getUserList() { 
        // 处理"/users/"的GET请求，用来获取用户列表 
        // 还可以通过@RequestParam从页面中传递参数来进行查询条件或者翻页信息的传递 
        List<User> r = new ArrayList<User>(users.values()); 
        return r; 
    } 
 
    @RequestMapping(value="/", method=RequestMethod.POST) 
    public String postUser(@ModelAttribute User user) { 
        // 处理"/users/"的POST请求，用来创建User 
        // 除了@ModelAttribute绑定参数之外，还可以通过@RequestParam从页面中传递参数 
        users.put(user.getId(), user); 
        return "success"; 
    } 
 
    @RequestMapping(value="/{id}", method=RequestMethod.GET) 
    public User getUser(@PathVariable Long id) { 
        // 处理"/users/{id}"的GET请求，用来获取url中id值的User信息 
        // url中的id可通过@PathVariable绑定到函数的参数中 
        return users.get(id); 
    } 
 
    @RequestMapping(value="/{id}", method=RequestMethod.PUT) 
    public String putUser(@PathVariable Long id, @ModelAttribute User user) { 
        // 处理"/users/{id}"的PUT请求，用来更新User信息 
        User u = users.get(id); 
        u.setName(user.getName()); 
        u.setAge(user.getAge()); 
        users.put(id, u); 
        return "success"; 
    } 
 
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE) 
    public String deleteUser(@PathVariable Long id) { 
        // 处理"/users/{id}"的DELETE请求，用来删除User 
        users.remove(id); 
        return "success"; 
    } 
 
    public static void main(String args[]) {
		//getKeySet();
		getEntrySet();
	}
	
	//根据Map 中的 keySet()方法获取
	public static void getKeySet(){
		System.out.println("--------keySet()方法获取-------------");
		Map map = new HashMap<String,String>();
	    map.put(1, "a");
	    map.put(2, "b");
	    System.out.println(map.keySet());
	    Collection s = map.keySet();
	    System.out.println(s);
	    Iterator iter2 = (Iterator)map.keySet().iterator();
	    while(iter2.hasNext()){
	    	System.out.print(iter2.next() + ", ");
	    }
	    System.out.println("========得到value的方法========");
	    Collection c = map.values();
	    System.out.println(c);
	    Iterator iter1 = (Iterator)map.values().iterator();
	    while(iter1.hasNext()){
	     System.out.print(iter1.next() + ", ");//一个一个获取value值
	    }
	}
	
	
	//根据Map 中的 entrySet()方法获取
	public static void getEntrySet(){
		System.out.println("--------entrySet()方法获取-------------");
		Map map = new HashMap();
	    map.put(1, "a");
	    map.put(2, "b");
	    System.out.println(map.entrySet());
	    Collection s = map.entrySet();
	    System.out.println(s);
	    Iterator iter2 = (Iterator)map.entrySet().iterator();
	    while(iter2.hasNext()){
	    	System.out.print(iter2.next() + ", ");
	    }
	}
}


