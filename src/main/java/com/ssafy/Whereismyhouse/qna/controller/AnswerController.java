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

import com.ssafy.Whereismyhouse.qna.model.dto.Answer;
import com.ssafy.Whereismyhouse.qna.model.dto.AnswerRegister;
import com.ssafy.Whereismyhouse.qna.model.dto.PageBean;
import com.ssafy.Whereismyhouse.qna.model.service.AnswerService;
@CrossOrigin("*")
@RestController
@RequestMapping("/answer")
public class AnswerController {
	private static final long serialVersionUID = 1L;
	private Logger logger = LoggerFactory.getLogger(AnswerController.class);
	@Autowired
	private AnswerService answerService;
	
	private static final String SUCCESS="success";

	
	@GetMapping("/list/{questionId}")
	public ResponseEntity<?> answerList(@PathVariable int questionId, PageBean bean) {
		logger.debug("answer list questionID .................................{}", questionId);
		List<Answer> answers = answerService.searchAll(questionId, bean);
		logger.debug("questionList............................{}",answers);
		System.out.println("answers list...");
		System.out.println(answers);
		if(answers != null) {
			return new ResponseEntity<List<Answer>>(answers,HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
	}


	@GetMapping("/regist")
	public void registForm() {}
	
	
	@PostMapping("/regist")
	public ResponseEntity<String> regist(@RequestBody AnswerRegister answerRegister) {
		System.out.println("regist................................");
		System.out.println(answerRegister.toString());
		logger.debug("Answer regist..............................{}",answerRegister);
		answerService.insert(answerRegister);
		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		
	}
	
	@PutMapping("/update")
	public void update(Answer answer, RedirectAttributes redirectAttributes) {
		answerService.update(answer);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public  ResponseEntity<String>  remove(@PathVariable int id) {
		System.out.println("...2");
		System.out.println(id);
		logger.debug("QuestionController.remove....................id:{}", id);
		answerService.delete(id);
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















