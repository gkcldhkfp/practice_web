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
		locations = { "file:src/main/webapp/WEB-INF/application-context.xml" }
)
public class CommentDaoTest {
	
	@Autowired // 스프링 컨테이너가 생성/관리하는 빈을 주입받음.  
	private CommentDao commentDao;
	
	//@Test
	public void testSelect() {
		Assertions.assertNotNull(commentDao);
		
		List<Comment> list = commentDao.selectByPostId(42);
		for (Comment c : list) {
			log.debug(c.toString());
		}
		
	}
	
	//@Test
	public void testInsert() {
		Comment comment = Comment.builder().postId(42).username("sss").ctext("댓글입력테스트").build();
		
		int result = commentDao.insert(comment);
		
		Assertions.assertEquals(1, result);
	}
	
	//@Test
	public void testUpdate() {
		Comment comment = Comment.builder().id(10).ctext("update test").build();
		
		int result = commentDao.update(comment);
		
		Assertions.assertEquals(1, result);
		
	}
	
	//@Test
	public void deleteByIdTest() {
		
		int result = commentDao.deleteById(3);
		
		Assertions.assertEquals(1, result);
		
	}
	
	//@Test
	public void deleteByPostIdTest() {
		
		int result = commentDao.deleteByPostId(42);
		// 포스트 번호 42번에 댓글이 3개 있는 경우:
		Assertions.assertEquals(3, result);
	}
	
	//@Test
	public void selectCommentCountTest() {
		
		int result = commentDao.selectCommentCount(42);
		Assertions.assertEquals(4, result);
		
	}
	
	@Test
	public void selectById() {
		// 테이블에 댓글 아이디(PK)가 있는 경우
		Comment result = commentDao.selectById(11);
		Assertions.assertNotNull(result);
		log.debug(result.toString());
		
		// 테이블에 댓글 아이디가 없는 경우
		Comment result2 = commentDao.selectById(1);
		Assertions.assertNull(result2);
		
	}
	
}
