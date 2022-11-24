package com.ssafy.Whereismyhouse.house.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.ssafy.Whereismyhouse.house.model.dto.DongCode;
import com.ssafy.Whereismyhouse.house.model.dto.EntireDealAmount;
import com.ssafy.Whereismyhouse.house.model.dto.House;
import com.ssafy.Whereismyhouse.house.model.dto.HouseDeal;
import com.ssafy.Whereismyhouse.house.model.dto.Pollution;
import com.ssafy.Whereismyhouse.house.model.service.DongCodeService;
import com.ssafy.Whereismyhouse.house.model.service.HouseDealService;
import com.ssafy.Whereismyhouse.house.model.service.HouseService;
import com.ssafy.Whereismyhouse.house.model.service.PollutionService;
import com.ssafy.Whereismyhouse.housedealonsale.controller.HouseDealOnSaleController;
import com.ssafy.Whereismyhouse.housedealonsale.model.dto.HouseDealOnSale;
import com.ssafy.Whereismyhouse.housedealonsale.model.service.HouseDealOnSaleService;
import com.ssafy.Whereismyhouse.qna.model.dto.PageBean;



/**
 * Servlet implementation class HouseController
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/house")
public class HouseController{
	private static final long serialVersionUID = 1L;
	private Logger logger = LoggerFactory.getLogger(HouseDealOnSaleController.class);
	@Autowired
	private HouseService houseService ;
	@Autowired
	private HouseDealService houseDealService ;
	@Autowired
	private DongCodeService dongCodeService ;
	@Autowired
	private PollutionService pollutionService ;
	@Autowired
	private HouseDealOnSaleService houseDealOnSaleService;
	
	private static final String SUCCESS="success";
	
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		process(request, response);
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
//		process(request, response);
//	}
//
//	private void process(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		String action = request.getServletPath();
//		System.out.println("action..........." + action);
//		String url = "index.jsp";
//		try {
//			switch (action) {
//			case "/getDong.house":
//				String jsonobject = getDong(request,response);
//				
//				response.setCharacterEncoding("utf-8");
//				PrintWriter out = response.getWriter();
//				out.write(jsonobject);
//				url="fetching";
//				break;
//			case "/searchAll.house":
//
//				url = searchAll(request, response);
//				break;
//			case "/searchApt.house":
//				url = searchApt(request, response);
//				break;
//
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			url = "error/error.jsp";
//		}
//		System.out.println("url......." + url);
//		if (url.startsWith("redirect:")) {
//			System.out.println("redirect.........");
//			response.sendRedirect(url.substring(9));
//		}else if(url.startsWith("fetching")) {
//			System.out.println("fetching.......");
//		}else {
//			request.getRequestDispatcher(url).forward(request, response);
//		}
//	}
	@GetMapping("/list")
	public ResponseEntity<?> houseList(PageBean bean) {
		logger.debug("houses............................{}",bean);
		List<House> houses = houseService.searchAll(bean);
		logger.debug("houseList............................{}",houses);
		if(houses!=null && !houses.isEmpty()) {
			return new ResponseEntity<List<House>>(houses, HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
	}
	@GetMapping("/getdongname")
	public ResponseEntity<?> dongName(@RequestParam String dongname) {
		logger.debug("dongName............................{}",dongname);
		DongCode dongCode = dongCodeService.getDongCode(dongname);
		logger.debug("dongCode............................{}",dongCode);
		if(dongCode!=null ) {
			return new ResponseEntity<DongCode>(dongCode, HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
	}
	@GetMapping("/getaptcode")
	public ResponseEntity<?> aptCode() {
		Integer aptCode = houseService.getAptCode()+1;
		System.out.println("aptCode.........................."+aptCode);
		logger.debug("newAptCode............................{}",aptCode);
		if(aptCode!=null ) {
			return new ResponseEntity<Integer>(aptCode, HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
	}
	@PostMapping("/regist")
	public ResponseEntity<String> regist(@RequestBody House house) {
		System.out.println("regist................................");
		System.out.println(house.toString());
		logger.debug("onSale regist..............................{}",house);
		houseService.insert(house);
		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
	}

	@GetMapping("/searchApt")
	private String searchApt(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		String aptCode = request.getParameter("aptCode");
		List<HouseDeal> houseDeals = houseDealService.search(aptCode);
		request.setAttribute("houseDeals", houseDeals);
		return "houseDealList";
	}
	@GetMapping("/entireDealAmount")
	public ResponseEntity<?> entireDealAmount() {
		List<EntireDealAmount>  result = houseDealService.entireDealAmount();
		return new ResponseEntity<List<EntireDealAmount> >(result, HttpStatus.OK);
	
	}
	

//	@GetMapping("/getDong")
//	private void getDong(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
//		String dong = request.getParameter("dong");
//		String gugun = request.getParameter("gugun");
//		String sido = request.getParameter("sido")+"%";
//		System.out.println("dong gugun sido...." + dong + " " + gugun + " " + sido);
//		String dongCode = dongCodeService.getDongCode(sido, gugun, dong);
//		System.out.println(dongCode);
//		System.out.println("getDongCode..............");
//		List<House> houses = houseService.searchByDong(dongCode);
//		dongCode=dongCode.substring(0,5);
//		int intDongCode=Integer.parseInt(dongCode);
//		System.out.println(intDongCode);
//		List<Pollution> pollutions = pollutionService.searchByDong(intDongCode,dong);
//		
//		Gson gson = new Gson();
//		String jsonObjectHouses = gson.toJson(houses);
//		String jsonObjectPollutions = gson.toJson(pollutions);
//		String jsonObject = "{ \"houses\" : "+jsonObjectHouses+",\"pollutions\" : "+jsonObjectPollutions+"}";	
//		
//		
//		response.setCharacterEncoding("utf-8");
//		PrintWriter out = response.getWriter();
//		out.write(jsonObject);
//		
//		;
//	}

//	private String mainPage(HttpServletRequest request, HttpServletResponse response) throws SQLException {
//		String dong = request.getParameter("dong");
//		System.out.println("dong ============= " + dong);
//		List<House> houses;
//		if (dong == null) {
//			houses = houseService.searchAll();
//		} else {
//			houses = houseService.searchByDong(dong);
//		}
//		request.setAttribute("houses", houses);
//
//		return "index.jsp";
//	}
}
