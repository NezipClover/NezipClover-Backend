package com.ssafy.Whereismyhouse.housedealonsale.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ssafy.Whereismyhouse.house.model.dto.House;
import com.ssafy.Whereismyhouse.house.model.service.HouseService;
import com.ssafy.Whereismyhouse.housedealonsale.model.dto.HouseDealOnSale;
import com.ssafy.Whereismyhouse.housedealonsale.model.service.HouseDealOnSaleService;
import com.ssafy.Whereismyhouse.qna.model.dto.Answer;
import com.ssafy.Whereismyhouse.qna.model.dto.AnswerRegister;
import com.ssafy.Whereismyhouse.qna.model.dto.PageBean;
import com.ssafy.Whereismyhouse.qna.model.service.AnswerService;
@CrossOrigin("*")
@RestController
@RequestMapping("/onsale")
public class HouseDealOnSaleController {
	private static final long serialVersionUID = 1L;
	private Logger logger = LoggerFactory.getLogger(HouseDealOnSaleController.class);
	@Autowired
	private HouseDealOnSaleService houseDealOnSaleService;
	
	private static final String SUCCESS="success";

	
	@PostMapping("/regist")
	public ResponseEntity<String> regist(@RequestBody HouseDealOnSale houseDealOnSale) {
		System.out.println("regist................................");
		System.out.println(houseDealOnSale.toString());
		logger.debug("onSale regist..............................{}",houseDealOnSale);
		houseDealOnSaleService.insert(houseDealOnSale);
		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<HouseDealOnSale>> list(@RequestParam("dong") String dong){
		logger.info("dongCode 기반 onsaleList");
		List<HouseDealOnSale> houseList = houseDealOnSaleService.searchBydong(dong);
		System.out.println(houseList.toString());
		return new ResponseEntity<List<HouseDealOnSale>>(houseList,HttpStatus.OK);
	}

//	@PostMapping("/regist")
//	public ResponseEntity<String> regist(@RequestBody HouseDealOnSale houseDealOnSale) {
//		System.out.println("regist................................");
//		System.out.println(answerRegister.toString());
//		logger.debug("Answer regist..............................{}",answerRegister);
//		answerService.insert(answerRegister);
//		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
//		
//	}
//	
//	@PutMapping("/update")
//	public void update(Answer answer, RedirectAttributes redirectAttributes) {
//		answerService.update(answer);
//	}
//	
//	
//	@DeleteMapping("/delete/{id}")
//	public  ResponseEntity<String>  remove(@PathVariable int id) {
//		System.out.println("...2");
//		System.out.println(id);
//		logger.debug("QuestionController.remove....................id:{}", id);
//		answerService.delete(id);
//		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
//	}
	
	
	
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






