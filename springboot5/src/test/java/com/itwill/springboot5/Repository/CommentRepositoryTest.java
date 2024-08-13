package com.itwill.springboot5.Repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.itwill.springboot5.domain.Comment;
import com.itwill.springboot5.domain.Post;
import com.itwill.springboot5.repository.CommentRepository;
import com.itwill.springboot5.repository.PostRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class CommentRepositoryTest {
	// COmmnetRepository의 CRUD 기능을 테스트
	@Autowired CommentRepository commRepo;
	@Autowired PostRepository postRepo;
	
//	@Test
	public void saveTest() {
		Post post = postRepo.findById(2L).orElseThrow();
		Comment comment = Comment.builder().post(post).ctext("comm save test").writer("admin").build();
		commRepo.save(comment);
	}
	
//	@Test 
	public void findByIdTest() {
		Comment comm = commRepo.findById(1L).orElseThrow();
		log.info("findByIdTest = {}", comm);
	}
	
//	@Test
	public void updateTest() {
		Comment entity = commRepo.findById(1L).orElseThrow();
		entity.update("update test");
		commRepo.save(entity);
	}
	
	@Test
	public void deleteTest() {
		commRepo.deleteById(1L);
	}
	
}
