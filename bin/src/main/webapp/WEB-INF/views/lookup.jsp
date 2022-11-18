<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<style>
.map_wrap, .map_wrap * {margin:0; padding:0;font-family:'Malgun Gothic',dotum,'돋움',sans-serif;font-size:12px;}
.map_wrap {position:relative;width:100%;height:350px;}
#category {position:absolute;top:10px;left:10px;border-radius: 5px; border:1px solid #909090;box-shadow: 0 1px 1px rgba(0, 0, 0, 0.4);background: #fff;overflow: hidden;z-index: 2;}
#category li {float:left;list-style: none;width:50px;px;border-right:1px solid #acacac;padding:6px 0;text-align: center; cursor: pointer;}
#category li.on {background: #eee;}
#category li:hover {background: #ffe6e6;border-left:1px solid #acacac;margin-left: -1px;}
#category li:last-child{margin-right:0;border-right:0;}
#category li span {display: block;margin:0 auto 3px;width:27px;height: 28px;}
#category li .category_bg {background:url(https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/places_category.png) no-repeat;}
#category li .bank {background-position: -10px 0;}
#category li .mart {background-position: -10px -36px;}
#category li .pharmacy {background-position: -10px -72px;}
#category li .oil {background-position: -10px -108px;}
#category li .cafe {background-position: -10px -144px;}
#category li .store {background-position: -10px -180px;}
#category li.on .category_bg {background-position-x:-46px;}
.placeinfo_wrap {position:absolute;bottom:28px;left:-150px;width:300px;}
.placeinfo {position:relative;width:100%;border-radius:6px;border: 1px solid #ccc;border-bottom:2px solid #ddd;padding-bottom: 10px;background: #fff;}
.placeinfo:nth-of-type(n) {border:0; box-shadow:0px 1px 2px #888;}
.placeinfo_wrap .after {content:'';position:relative;margin-left:-12px;left:50%;width:22px;height:12px;background:url('https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/vertex_white.png')}
.placeinfo a, .placeinfo a:hover, .placeinfo a:active{color:#fff;text-decoration: none;}
.placeinfo a, .placeinfo span {display: block;text-overflow: ellipsis;overflow: hidden;white-space: nowrap;}
.placeinfo span {margin:5px 5px 0 5px;cursor: default;font-size:13px;}
.placeinfo .title {font-weight: bold; font-size:14px;border-radius: 6px 6px 0 0;margin: -1px -1px 0 -1px;padding:10px; color: #fff;background: #d95050;background: #d95050 url(https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/arrow_white.png) no-repeat right 14px center;}
.placeinfo .tel {color:#0f7833;}
.placeinfo .jibun {color:#999;font-size:11px;margin-top:0;}
</style>





<!-- Custom fonts for this template-->


<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=f7a2faaabcf3fe0fe487a55bc0b9cfb0&libraries=services"></script>
<!--   <script src="js/addressSearch.js"></script> -->
<script type="text/javascript" src="js/sojaeji.js"></script>

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
				<div class="container-fluid" id="mainContent">
					<!-- Page Heading -->
					<div class="d-sm-flex flex-column align-items-center justify-content-center my-4 py-4  bg-white">
						
						<!-- Begin Select Box(sido, gugun, dong) -->
						<div class="row">
							<div class="card mb-4">
								<div class="card-header py-3">
									<h6 class="m-0 font-weight-bold text-primary">조회할 지역을
										선택하세요.</h6>
								</div>
								<div class="card-body">
									<div
										class="dropdown no-arrow mb-1 d-flex justify-content-between ">
										<div class="mx-4">

											<select class="btn btn-secondary dropdown-toggle px-4"
												type="button" id="sido2" data-toggle="dropdown"
												aria-haspopup="true" aria-expanded="false">
											</select>

										</div>
										<div class="mx-4">

											<select class="btn btn-secondary dropdown-toggle px-4"
												type="button" id="gugun2" data-toggle="dropdown"
												aria-haspopup="true" aria-expanded="false">

											</select>

										</div>
										<div class="mx-4">

											<select class="btn btn-secondary dropdown-toggle px-4"
												type="button" id="dong2" data-toggle="dropdown"
												aria-haspopup="true" aria-expanded="false">
											</select>

										</div>
										
										<div class="mx-4">
											<a id="addBookmarkBtn" class="btn btn-secondary" href="#" role="button" onclick="addBookmark();">관심 등록</a>
										</div>
									</div>

								</div>
							</div>
						</div>
						
						<!-- Begin BookmarkList -->
						<%@ include file="bookmarkList.jsp"%>
						<!-- End Bookmarked List -->
						
					</div>
					<div class="container-fluid py-4" style="height: 600px"
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
									<div class="map_wrap h-100">
										<div id="map"
											style="width: 100%; height: 100%; "></div>
										<ul id="category">
											<li id="BK9" data-order="0"><span
												class="category_bg bank"></span> 은행</li>
											<li id="MT1" data-order="1"><span
												class="category_bg mart"></span> 마트</li>
											<li id="PM9" data-order="2"><span
												class="category_bg pharmacy"></span> 약국</li>
											<li id="OL7" data-order="3"><span
												class="category_bg oil"></span> 주유소</li>
											<li id="CE7" data-order="4"><span
												class="category_bg cafe"></span> 카페</li>
											<li id="CS2" data-order="5"><span
												class="category_bg store"></span> 편의점</li>
										</ul>
									</div>
								</div>
							</div>
							<!-- Pie Chart -->
							<div class="col-xl-8 col-lg-7">
								<div class="card shadow mb-4 h-100">
									<!-- Card Header - Dropdown -->
									<div
										class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
										<h6 class="m-0 font-weight-bold text-primary">동 조회 목록(클릭시
											지도에 위치 표시)</h6>
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
										<div class="text-center small " id="info">
											<span class="mr-2"> <i
												class="fas fa-circle text-secondary"></i> 조회할 매물을 선택해 주세요.
											</span>

										</div>
									</div>
								</div>
							</div>
						</div>

					</div>



				</div>




			</div>
			<!-- End of Main Content -->
			
<script>
// 관심 등록
function addBookmark() {
	var target = document.getElementById('sido2');
	var sido = target.options[target.selectedIndex].value;
	target = document.getElementById('gugun2');
	var gugun = target.options[target.selectedIndex].value;
	target = document.getElementById('dong2');
	var dong = target.options[target.selectedIndex].value;
	console.log(sido);
	console.log(gugun);
	console.log(dong);
	window.location.href = "insert.bookmark?sido="+ sido + "&gugun=" + gugun + "&dong=" + dong;
}


</script>

			<!-- Footer -->
			

			<script type="text/javascript"
				src="//dapi.kakao.com/v2/maps/sdk.js?appkey=f7a2faaabcf3fe0fe487a55bc0b9cfb0&libraries=services"></script>
			<script type="text/javascript">
				var markers = [];
				
				var container = document.getElementById('map');
				var options = {
					center : new kakao.maps.LatLng(33.450701, 126.570667),
					level : 3
				};
				//지도 생성
				var map = new kakao.maps.Map(container, options);
				var geocoder = new kakao.maps.services.Geocoder();
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
				//지도 이동 함수
				function setCenter(lat, lng) {
					// 이동할 위도 경도 위치를 생성합니다 
					var moveLatLon = new kakao.maps.LatLng(lat, lng);

					// 지도 중심을 이동 시킵니다
					map.setCenter(moveLatLon);

					// 결과값으로 받은 위치를 마커로 표시합니다
					addMarker(moveLatLon);

				}

				//마커 추가 함수
				function addMarker(position) {

					// 마커를 생성합니다
					var marker = new kakao.maps.Marker({
						position : position
					});

					// 마커가 지도 위에 표시되도록 설정합니다
					marker.setMap(map);

					// 생성된 마커를 배열에 추가합니다
					markers.push(marker);

				}

				//마커 세팅
				function setMarkers(map) {
					for (var i = 0; i < markers.length; i++) {
						markers[i].setMap(map);
					}
				}
				// "마커 보이기" 버튼을 클릭하면 호출되어 배열에 추가된 마커를 지도에 표시하는 함수입니다
				function showMarkers() {
					setMarkers(map)
				}
				// "마커 감추기" 버튼을 클릭하면 호출되어 배열에 추가된 마커를 지도에서 삭제하는 함수입니다
				function hideMarkers() {
					setMarkers(null);
				}

				//표 클릭시 동작
				function rowClicked2() {

					var table = document.getElementById('house_list');
					var rowList = table.rows;

					for (i = 1; i < rowList.length; i++) {//thead부분 제외.

						var row = rowList[i];
						var str = "";

						row.onclick = function() {
							return function() {

								//개별적으로 값 가져오기

								var lat = this.cells[4].innerHTML;//지역
								var lng = this.cells[5].innerHTML;//점수

								setCenter(lat, lng);

							};//return
						}(row);//onclick
					}//for

				}//function

				window.onload = rowClicked2();
			</script>
			<%@ include file="include/footer.jsp"%>