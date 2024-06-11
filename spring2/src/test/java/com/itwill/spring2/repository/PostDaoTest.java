package com.itwill.spring2.repository;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ExtendWith(SpringExtension.class)
@ContextConfiguration(
		locations = { "file:src/main/webapp/WEB-INF/application-context.xml" })
public class PostDaoTest {
	
	@Autowired
	private PostDao postDao;

	//@Test
	public void testSelectAll() {
		Assertions.assertNotNull(postDao);
		
		List<Post> list = postDao.selectOrderByIdDesc();
		for (Post p : list) {
			System.out.println("\t"+p);
		}
	}
	
	//@Test
	public void testSelectById() {
		Post post1 = postDao.selectById(2); // DB 테이블에 id가 있는 경우
		Assertions.assertNotNull(post1);
		log.debug(post1.toString());
		
		Post post2 = postDao.selectById(5); // DB 테이블에 id가 없는 경우
		Assertions.assertNull(post2);
		
	}
	
	//@Test
	public void testInsert() {
		// insert할 데이터
		Post post = Post.builder().title("MyBatis 테스트").content("테스트").author("실험맨").build();
		
		int result = postDao.insertPost(post);
		Assertions.assertEquals(1, result);
		
	}
	
	//@Test
	public void testUpdate() {
		// 업데이트할 포스트 객체:
		Post post = Post.builder().title("MyBatis Update").content("MyBatis-Spring을 사용한 데이터베이스 업데이트").id(1).build();
		int result = postDao.updatePost(post);
		Assertions.assertEquals(1, result);
		
	}
	
	@Test
	public void testDelete() {
		int result = postDao.deletePost(3);
		Assertions.assertEquals(1, result);
	}
	
}
