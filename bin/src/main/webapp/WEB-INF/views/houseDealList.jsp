<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="include/head.jsp"%>
<style>
#mainContent {
	width: 100%;
	height: 100%;
	text-align: center;
	position: relative;
	z-index: 0;
}

#mainContent::after {
	width: 100%;
	height: 100%;
	content: "";
	background: url(./img/부동산.jpg);
	position: absolute;
	top: 0;
	left: 0;
	z-index: -1;
	opacity: 0.1;
}
</style>
<%@ include file="include/mapStyle.jsp"%>



<!-- Custom fonts for this template-->


<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=f7a2faaabcf3fe0fe487a55bc0b9cfb0&libraries=services"></script>
<!--  <script src="js/addressSearch.js"></script>-->
<script type="text/javascript" src="js/sojaeji.js"></script>
<script type="text/javascript">
	
<%--
	  window.onload = function(){
		 
	    var container = document.getElementById('map');
	    var options = {
	        center: new kakao.maps.LatLng(33.450701, 126.570667),
	        level: 3
	    };

	    var map = new kakao.maps.Map(container, options);
	    var geocoder = new kakao.maps.services.Geocoder();
	    // 주소로 좌표를 검색합니다

	          // 정상적으로 검색이 완료됐으면 
	
	              var coords = new kakao.maps.LatLng(${param.lat}, ${param.lng});
	      
	              // 결과값으로 받은 위치를 마커로 표시합니다
	              var marker = new kakao.maps.Marker({
	                  map: map,
	                  position: coords
	              });
	              var infowindow = new kakao.maps.InfoWindow({
		                content: `<div style="background-color: white ;width:150px;text-align:center;padding:6px 0;">
	            
		                ${param.aptName}
		             
		                </div>`,
		                
		              });
		           
		                // 마커 위에 인포윈도우를 표시합니다
		                infowindow.open(map, marker);  
		
	              // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
	              map.setCenter(coords);

	}
--%>



</script>
</head>

<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Sidebar -->
		<%@ include file="include/sidebar.jsp"%>
		<!-- End of Sidebar -->

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">

				<!-- Topbar -->
				<%@ include file="include/header.jsp"%>
				<!-- End of Topbar -->

				<!-- Begin Page Content -->




				<!-- 목록 영역 -->

				<div class="container-fluid py-4" style="height: 1100px"
					id="mainContent">
					<div class="row h-100">
						<!-- 지도 영역 -->
						<div class="col-xl-4 col-lg-5">
							<div class="card shadow mb-4 h-100" style="height: 600px;">
								<!-- Card Header - Dropdown -->
								<div
									class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
									<h6 class="m-0 font-weight-bold text-primary">위치</h6>
									<div class="dropdown no-arrow">
										<a class="dropdown-toggle" href="#" role="button"
											id="dropdownMenuLink" data-toggle="dropdown"
											aria-haspopup="true" aria-expanded="false"> <i
											class="fas fa-ellipsis-v fa-sm fa-fw text-gray-400"></i>
										</a>
										<div
											class="dropdown-menu dropdown-menu-right shadow animated--fade-in"
											aria-labelledby="dropdownMenuLink">
											<div class="dropdown-header">Dropdown Header:</div>
											<a class="dropdown-item" href="#">Action</a> <a
												class="dropdown-item" href="#">Another action</a>
											<div class="dropdown-divider"></div>
											<a class="dropdown-item" href="#">Something else here</a>
										</div>
									</div>
								</div>
								<!-- Card Body -->
								<%@ include file="include/mapElem.jsp"%>
							</div>
						</div>
						<!-- Pie Chart -->
						<div class="col-xl-8 col-lg-7">
							<div class="card shadow mb-4 h-100">
								<!-- Card Header - Dropdown -->
								<div
									class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
									<h6 class="m-0 font-weight-bold text-primary">${param.aptName}</h6>
									<div class="dropdown no-arrow">
										<a class="dropdown-toggle" href="#" role="button"
											id="dropdownMenuLink" data-toggle="dropdown"
											aria-haspopup="true" aria-expanded="false"> <i
											class="fas fa-ellipsis-v fa-sm fa-fw text-gray-400"></i>
										</a>
										<div
											class="dropdown-menu dropdown-menu-right shadow animated--fade-in"
											aria-labelledby="dropdownMenuLink">
											<div class="dropdown-header">상세정보 메뉴:</div>
											<a class="dropdown-item" href="#">선택 삭제</a> <a
												class="dropdown-item" href="#">선택 관심등록</a>
											<div class="dropdown-divider"></div>
											<a class="dropdown-item text-danger" href="#">전체 삭제</a>
										</div>
									</div>
								</div>
								<!-- Card Body -->
								<div id="ma" class="card-body"
									style="width: 100%; height: 600px; overflow: auto">
									<table width="100%" class='table'>
										<tr>
											<td>거래 금액</td>
											<td>거래 일자</td>
											<td>평</td>
											<td>층</td>
											<%-- <td>거래 유형</td>--%>
										</tr>
										<c:forEach items='${houseDeals}' var='houseDeal'>
											<tr>
												<td>${houseDeal.dealAmount }</td>
												<td>${houseDeal.dealYear }.${houseDeal.dealMonth }.
													${houseDeal.dealDay }</td>
												<td><fmt:formatNumber type="number"
														maxFractionDigits="2" value="${houseDeal.area }" /></td>
												<td>${houseDeal.floor }</td>
												<%-- <td>거래 유형</td>--%>
											</tr>
										</c:forEach>
									</table>
								</div>
							</div>
						</div>
					</div>




				</div>


			</div>
			<!-- End of Main Content -->
			<script type="text/javascript"
				src="//dapi.kakao.com/v2/maps/sdk.js?appkey=f7a2faaabcf3fe0fe487a55bc0b9cfb0&libraries=services"></script>
			<script type="text/javascript">
			 var container = document.getElementById('map');
			    var options = {
			        center: new kakao.maps.LatLng(33.450701, 126.570667),
			        level: 3
			    };

			    var map = new kakao.maps.Map(container, options);
			    var geocoder = new kakao.maps.services.Geocoder();
			    // 주소로 좌표를 검색합니다

			          // 정상적으로 검색이 완료됐으면 
			
			              var coords = new kakao.maps.LatLng(${param.lat}, ${param.lng});
			      
			              // 결과값으로 받은 위치를 마커로 표시합니다
			              var marker = new kakao.maps.Marker({
			                  map: map,
			                  position: coords
			              });
			              var infowindow = new kakao.maps.InfoWindow({
				                content: `<div style="background-color: white ;width:150px;text-align:center;padding:6px 0;">
			            
				                ${param.aptName}
				             
				                </div>`,
				                
				              });
				           
				                // 마커 위에 인포윈도우를 표시합니다
				                infowindow.open(map, marker);  
				
			              // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
			              map.setCenter(coords);
			              
				// 마커를 클릭했을 때 해당 장소의 상세정보를 보여줄 커스텀오버레이입니다
				var placeOverlay = new kakao.maps.CustomOverlay({zIndex:1}), 
				    contentNode = document.createElement('div'), // 커스텀 오버레이의 컨텐츠 엘리먼트 입니다 
				    markersCate = [], // 마커를 담을 배열입니다
				    currCategory = ''; // 현재 선택된 카테고리를 가지고 있을 변수입니다
				 


				// 장소 검색 객체를 생성합니다
				var ps = new kakao.maps.services.Places(map); 

				// 지도에 idle 이벤트를 등록합니다
				kakao.maps.event.addListener(map, 'idle', searchPlaces);

				// 커스텀 오버레이의 컨텐츠 노드에 css class를 추가합니다 
				contentNode.className = 'placeinfo_wrap';

				// 커스텀 오버레이의 컨텐츠 노드에 mousedown, touchstart 이벤트가 발생했을때
				// 지도 객체에 이벤트가 전달되지 않도록 이벤트 핸들러로 kakao.maps.event.preventMap 메소드를 등록합니다 
				addEventHandle(contentNode, 'mousedown', kakao.maps.event.preventMap);
				addEventHandle(contentNode, 'touchstart', kakao.maps.event.preventMap);

				// 커스텀 오버레이 컨텐츠를 설정합니다
				placeOverlay.setContent(contentNode);  

				// 각 카테고리에 클릭 이벤트를 등록합니다
				addCategoryClickEvent();

				// 엘리먼트에 이벤트 핸들러를 등록하는 함수입니다
				function addEventHandle(target, type, callback) {
				    if (target.addEventListener) {
				        target.addEventListener(type, callback);
				    } else {
				        target.attachEvent('on' + type, callback);
				    }
				}

				// 카테고리 검색을 요청하는 함수입니다
				function searchPlaces() {
				    if (!currCategory) {
				        return;
				    }
				    
				    // 커스텀 오버레이를 숨깁니다 
				    placeOverlay.setMap(null);

				    // 지도에 표시되고 있는 마커를 제거합니다
				    removeMarkerCate();
				    
				    ps.categorySearch(currCategory, placesSearchCB, {useMapBounds:true}); 
				}

				// 장소검색이 완료됐을 때 호출되는 콜백함수 입니다
				function placesSearchCB(data, status, pagination) {
				    if (status === kakao.maps.services.Status.OK) {

				        // 정상적으로 검색이 완료됐으면 지도에 마커를 표출합니다
				        displayPlaces(data);
				    } else if (status === kakao.maps.services.Status.ZERO_RESULT) {
				        // 검색결과가 없는경우 해야할 처리가 있다면 이곳에 작성해 주세요

				    } else if (status === kakao.maps.services.Status.ERROR) {
				        // 에러로 인해 검색결과가 나오지 않은 경우 해야할 처리가 있다면 이곳에 작성해 주세요
				        
				    }
				}

				// 지도에 마커를 표출하는 함수입니다
				function displayPlaces(places) {

				    // 몇번째 카테고리가 선택되어 있는지 얻어옵니다
				    // 이 순서는 스프라이트 이미지에서의 위치를 계산하는데 사용됩니다
				    var order = document.getElementById(currCategory).getAttribute('data-order');

				    

				    for ( var i=0; i<places.length; i++ ) {

				            // 마커를 생성하고 지도에 표시합니다
				            var marker = addMarkerCate(new kakao.maps.LatLng(places[i].y, places[i].x), order);

				            // 마커와 검색결과 항목을 클릭 했을 때
				            // 장소정보를 표출하도록 클릭 이벤트를 등록합니다
				            (function(marker, place) {
				                kakao.maps.event.addListener(marker, 'click', function() {
				                    displayPlaceInfo(place);
				                });
				            })(marker, places[i]);
				    }
				}

				// 마커를 생성하고 지도 위에 마커를 표시하는 함수입니다
				function addMarkerCate(position, order) {
				    var imageSrc = 'https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/places_category.png', // 마커 이미지 url, 스프라이트 이미지를 씁니다
				        imageSize = new kakao.maps.Size(27, 28),  // 마커 이미지의 크기
				        imgOptions =  {
				            spriteSize : new kakao.maps.Size(72, 208), // 스프라이트 이미지의 크기
				            spriteOrigin : new kakao.maps.Point(46, (order*36)), // 스프라이트 이미지 중 사용할 영역의 좌상단 좌표
				            offset: new kakao.maps.Point(11, 28) // 마커 좌표에 일치시킬 이미지 내에서의 좌표
				        },
				        markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imgOptions),
				            marker = new kakao.maps.Marker({
				            position: position, // 마커의 위치
				            image: markerImage 
				        });

				    marker.setMap(map); // 지도 위에 마커를 표출합니다
				    markersCate.push(marker);  // 배열에 생성된 마커를 추가합니다

				    return marker;
				}

				// 지도 위에 표시되고 있는 마커를 모두 제거합니다
				function removeMarkerCate() {
				    for ( var i = 0; i < markersCate.length; i++ ) {
				        markersCate[i].setMap(null);
				    }   
				    markersCate = [];
				}

				// 클릭한 마커에 대한 장소 상세정보를 커스텀 오버레이로 표시하는 함수입니다
				function displayPlaceInfo (place) {
				    var content = '<div class="placeinfo">' +
				                    '   <a class="title" href="' + place.place_url + '" target="_blank" title="' + place.place_name + '">' + place.place_name + '</a>';   

				    if (place.road_address_name) {
				        content += '    <span title="' + place.road_address_name + '">' + place.road_address_name + '</span>' +
				                    '  <span class="jibun" title="' + place.address_name + '">(지번 : ' + place.address_name + ')</span>';
				    }  else {
				        content += '    <span title="' + place.address_name + '">' + place.address_name + '</span>';
				    }                
				   
				    content += '    <span class="tel">' + place.phone + '</span>' + 
				                '</div>' + 
				                '<div class="after"></div>';

				    contentNode.innerHTML = content;
				    placeOverlay.setPosition(new kakao.maps.LatLng(place.y, place.x));
				    placeOverlay.setMap(map);  
				}


				// 각 카테고리에 클릭 이벤트를 등록합니다
				function addCategoryClickEvent() {
				    var category = document.getElementById('category'),
				        children = category.children;

				    for (var i=0; i<children.length; i++) {
				        children[i].onclick = onClickCategory;
				    }
				}

				// 카테고리를 클릭했을 때 호출되는 함수입니다
				function onClickCategory() {
				    var id = this.id,
				        className = this.className;

				    placeOverlay.setMap(null);

				    if (className === 'on') {
				        currCategory = '';
				        changeCategoryClass();
				        removeMarkerCate();
				    } else {
				        currCategory = id;
				        changeCategoryClass(this);
				        searchPlaces();
				    }
				}

				// 클릭된 카테고리에만 클릭된 스타일을 적용하는 함수입니다
				function changeCategoryClass(el) {
				    var category = document.getElementById('category'),
				        children = category.children,
				        i;

				    for ( i=0; i<children.length; i++ ) {
				        children[i].className = '';
				    }

				    if (el) {
				        el.className = 'on';
				    } 
				} 
				
			</script>
			<!-- Footer -->
			<%@ include file="include/footer.jsp"%>