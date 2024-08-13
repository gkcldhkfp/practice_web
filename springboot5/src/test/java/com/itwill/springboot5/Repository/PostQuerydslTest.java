package com.itwill.springboot5.Repository;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.itwill.springboot5.domain.Post;
import com.itwill.springboot5.dto.PostSearchRequestDto;
import com.itwill.springboot5.repository.PostRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class PostQuerydslTest {

	@Autowired
	private PostRepository postRepo;
	
//	@Test
	public void testSearchById() {
		Post entity = postRepo.searchById(2L);
		log.info("entity = {}",entity);
		
	}
	
	@Test
	public void test() {
		List<Post> result = null;
//		result = postRepo.searchByTitle("DUM");
//		result = postRepo.searchByContent("테");
//		result = postRepo.searchByTitleOrContent("테");
//		result = postRepo.searchBymodifiedTime(LocalDateTime.of(2024, 7, 29, 0, 0), LocalDateTime.of(2024, 7, 30, 23, 59));
//		result = postRepo.searchByAuthorAndTitle("admin", "test");
		
//		PostSearchRequestDto dto = new PostSearchRequestDto();
//		dto.setCategory("tc");
//		dto.setKeyword("dum title");
//		result = postRepo.searchByCategory(dto);
		
		String[] keywords = "te dum".split(" "); //{"dum", "title"};
//		result = postRepo.searchByKeywords(keywords);
//		result.forEach(System.out::println);
		
		Pageable pageable = PageRequest.of(1, 5, Sort.by("id").descending());
		Page<Post> page = postRepo.searchBykeywords(keywords, pageable);
		page.forEach(System.out :: println);
		
	}
	
}
