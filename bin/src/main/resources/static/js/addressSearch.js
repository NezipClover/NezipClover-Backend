dong2let data = ['삼익대청아파트,39.53,202208,119000,서울특별시 강남구 개포동 개포로109길 21',
  '마일스디오빌,36.29,202208,38500,서울특별시 강남구 논현동 학동로 165']
  window.onload = function(){
	var houses = Request("houses");
    var container = document.getElementById('map');
    var options = {
        center: new kakao.maps.LatLng(33.450701, 126.570667),
        level: 3
    };

    var map = new kakao.maps.Map(container, options);
    var geocoder = new kakao.maps.services.Geocoder();
    // 주소로 좌표를 검색합니다

    
    for (let i = 0; i < data.length; i++){
      let temp = data[i].split(",");  
      geocoder.addressSearch(temp[4], function(result, status) {
      
          // 정상적으로 검색이 완료됐으면 
           if (status === kakao.maps.services.Status.OK) {
      
              var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
      
              // 결과값으로 받은 위치를 마커로 표시합니다
              var marker = new kakao.maps.Marker({
                  map: map,
                  position: coords
              });
      
              // 인포윈도우로 장소에 대한 설명을 표시합니다
              var infowindow = new kakao.maps.InfoWindow({
                content: `<div style="width:150px;text-align:center;padding:6px 0;">
                ${temp[0]}<br>
                평수 : ${temp[1]}<br>
                거래일자 : ${temp[2]}<br>
                거래가격 : ${temp[3]}<br>
                주소 : ${temp[4]}<br>         
                </div>`,
                
              });
              kakao.maps.event.addListener(marker, 'mouseover', function() {
                // 마커 위에 인포윈도우를 표시합니다
                infowindow.open(map, marker);  
              });
      
              kakao.maps.event.addListener(marker, 'mouseout', function() {
                // 마커 위에 인포윈도우를 표시합니다
                infowindow.close();  
              });
      
              // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
              map.setCenter(coords);
          } 
      });    
    }
    const dropboxitem1 = document.getElementById('si');
    dropboxitem1.addEventListener('click', (event) => {
      const dropbox1 = document.getElementById('dropdownMenuButton1')
      dropbox1.innerText = dropboxitem1.innerText;
    })
    const dropboxitem2 = document.getElementById('gu');
    dropboxitem2.addEventListener('click', (event) => {
      const dropbox2 = document.getElementById('dropdownMenuButton2')
      dropbox2.innerText = dropboxitem2.innerText;
    })

    const dropboxitem3 = document.getElementById('dong1');
    dropboxitem3.addEventListener('click', (event) => {
      const dropbox3 = document.getElementById('dropdownMenuButton3')
      dropbox3.innerText = dropboxitem3.innerText;
    
      geocoder.addressSearch(dropbox3.innerText, function(result, status) {

        // 정상적으로 검색이 완료됐으면 
        if (status === kakao.maps.services.Status.OK) {
    
            var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
    
            // 결과값으로 받은 위치를 마커로 표시합니다
            
    
            // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
            map.setCenter(coords);
        } 
    });

    })
    const dropboxitem4 = document.getElementById('dong2');
    dropboxitem4.addEventListener('click', (event) => {
      const dropbox3 = document.getElementById('dropdownMenuButton3')
      dropbox3.innerText = dropboxitem4.innerText;
      console.log("dong2");
      geocoder.addressSearch(dropbox3.innerText, function(result, status) {

        // 정상적으로 검색이 완료됐으면 
        if (status === kakao.maps.services.Status.OK) {
    
            var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
    
            // 결과값으로 받은 위치를 마커로 표시합니다
            
    
            // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
            map.setCenter(coords);
        } 
    });    
    
  })


}

