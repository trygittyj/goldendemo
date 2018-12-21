package com.example.demo;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
//import org.springframework.util.Assert;

import com.example.demo.service.UserService;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTests {

	@Test
	public void contextLoads() {
	}
	private MockMvc mvc; 
	 
	/*@Before 
	public void setUp() throws Exception { 
		mvc = MockMvcBuilders.standaloneSetup(new UserController()).build(); 
	}*/ 
	@Autowired
	private UserService userSerivce;

	@Before
	public void setUp() {
		// 准备，清空user表
		//userSerivce.deleteAllUsers();
	}

	@Test
	public void test() throws Exception {
		// 插入5个用户
//		userSerivce.create("a", 1);
//		userSerivce.create("b", 2);
//		userSerivce.create("c", 3);
//		userSerivce.create("d", 4);
//		userSerivce.create("e", 5);
//
//		// 查数据库，应该有5个用户
//		Assert.assertEquals(5, userSerivce.getAllUsers().intValue());

		// 删除两个用户
		userSerivce.deleteByName(64);

		// 查数据库，应该有5个用户
		/*Assert.assertEquals(3, userSerivce.getAllUsers().intValue());*/

	}
 
	/*@Test 
	public void testUserController() throws Exception { 
        // 测试UserController 
		RequestBuilder request = null; 
 
		// 1、get查一下user列表，应该为空 
		request = get("/users/"); 
		mvc.perform(request) 
				.andExpect(status().isOk()) 
				.andExpect(content().string(equalTo("[]"))); 
 
		// 2、post提交一个user 
		request = post("/users/") 
				.param("id", "1") 
				.param("name", "测试大师") 
				.param("age", "20"); 
		mvc.perform(request) 
		        .andExpect(content().string(equalTo("success"))); 
 
		// 3、get获取user列表，应该有刚才插入的数据 
		request = get("/users/"); 
		mvc.perform(request) 
				.andExpect(status().isOk()) 
				.andExpect(content().string(equalTo("[{\"id\":1,\"name\":\"测试大师\",\"age\":20}]"))); 
 
		// 4、put修改id为1的user 
		request = put("/users/1") 
				.param("name", "测试终极大师") 
				.param("age", "30"); 
		mvc.perform(request) 
				.andExpect(content().string(equalTo("success"))); 
 
		// 5、get一个id为1的user 
		request = get("/users/1"); 
		mvc.perform(request) 
				.andExpect(content().string(equalTo("{\"id\":1,\"name\":\"测试终极大师\",\"age\":30}"))); 
 
		// 6、del删除id为1的user 
		request = delete("/users/1"); 
		mvc.perform(request) 
				.andExpect(content().string(equalTo("success"))); 
 
		// 7、get查一下user列表，应该为空 
		request = get("/users/"); 
		mvc.perform(request) 
				.andExpect(status().isOk()) 
				.andExpect(content().string(equalTo("[]"))); 
 
	} */
}
