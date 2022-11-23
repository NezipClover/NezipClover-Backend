package com.ssafy.Whereismyhouse.qna.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ssafy.Whereismyhouse.qna.model.dto.PageBean;
import com.ssafy.Whereismyhouse.qna.model.dto.Question;
import com.ssafy.Whereismyhouse.qna.model.dto.QuestionRegister;
import com.ssafy.Whereismyhouse.qna.model.service.QuestionService;




@CrossOrigin("*")
@RestController
@RequestMapping("/question")
public class QuestionController {
	private static final long serialVersionUID = 1L;
	private Logger logger = LoggerFactory.getLogger(QuestionController.class);
	@Autowired
	private QuestionService questionService;
//	@Autowired
//	private AnswerService answerService;
	private static final String SUCCESS="success";

	@GetMapping("/list")
	public ResponseEntity<?> questionList() {
		logger.debug("questionList............................{}");

		List<Question> questions = questionService.searchAll();	


		logger.debug("questionList............................{}",questions);
		if (!questions.isEmpty()) {
		return new ResponseEntity<List<Question>>(questions, HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}	
		
	}
	@GetMapping("/listByWord/{searchKey}/{word}")
	public ResponseEntity<?> questionListByWord(@PathVariable String searchKey, @PathVariable String word) {
		logger.debug("questionList............................{}");
		System.out.println(searchKey + " " +  word);
		List<Question> questions;
		if ((word.isEmpty() || word == "") || searchKey == "all" || searchKey == "") {
			questions = questionService.searchAll();	
		} else {
			questions = questionService.searchAllByWord(searchKey, word);
			
		}
		logger.debug("questionList............................{}",questions);
		if(questions!=null && !questions.isEmpty()) {
			return new ResponseEntity<List<Question>>(questions, HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}	
		
	}
	
	@GetMapping("/search/{id}")
	public ResponseEntity<?> search(@PathVariable int id) {
		logger.debug("questionController.search....................id:{}", id);
		Question question = questionService.search(id);
		logger.debug("questionController.search....................question:{}", question);
		if(question != null) {
			return new ResponseEntity<Question>(question, HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
	}
	@GetMapping("/regist")
	public void registForm() {}
	
	
	@PostMapping("/regist")
	public ResponseEntity<String> regist (@RequestBody QuestionRegister questionRegister) {
		logger.debug("Question regist..............................{}",questionRegister);
		questionService.insert(questionRegister);
		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody Question question) {
		logger.debug("questionController.udpate....................questionId:{}", question.getId());
		questionService.update(question);
		logger.debug("questionController.udpate....................question:{}", question);
		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
	}
	
	

	@DeleteMapping("/delete/{id}")
	public  ResponseEntity<String>  remove(@PathVariable int id) {
		logger.debug("QuestionController.remove....................id:{}", id);
		questionService.delete(id);
		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
	}
	
	
	
//	@GetMapping("/search")
//	public void search(String isbn,PageBean bean, Model model) {
//		logger.debug("BookController.search....................isbn:{}", isbn);
//		Book book = bookService.search(isbn);
//		logger.debug("BookController.search....................book:{}", book);
//		model.addAttribute("book", book);
//	}
//	@GetMapping("/update")
//	public void udpateForm(String isbn,PageBean bean, Model model) {
//		logger.debug("BookController.udpateForm....................isbn:{}", isbn);
//		Book book = bookService.search(isbn);
//		logger.debug("BookController.udpateForm....................book:{}", book);
//		model.addAttribute("book", book);
//	}
	
	
//	@PostMapping("/update")
//	public String udpate(Book book,PageBean bean, Model model, RedirectAttributes redirectAttributes) {
//		logger.debug("BookController.udpate....................isbn:{}", book);
//		bookService.update(book);
//		logger.debug("BookController.udpate....................book:{}", book);
//		redirectAttributes.addAttribute("pageNo", bean.getPageNo());
//		redirectAttributes.addAttribute("key", bean.getKey());
//		redirectAttributes.addAttribute("word", bean.getWord());
//		return "redirect:/book/list";
//	}
//	
//	
//	@GetMapping("/remove")
//	public String remove(String isbn,PageBean bean, RedirectAttributes redirectAttributes) {
//		logger.debug("BookController.remove....................isbn:{}", isbn);
//		bookService.delete(isbn);
//		redirectAttributes.addAttribute("pageNo", bean.getPageNo());
//		redirectAttributes.addAttribute("key", bean.getKey());
//		redirectAttributes.addAttribute("word", bean.getWord());
//		return "redirect:/book/list";
//	}
}















