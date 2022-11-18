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

								newPage();

							};//return
						}(row);//onclick
					}//for

				}//function

				window.onload = rowClicked2();
				
				
				function newPage()  {
					 hideMarkers();
					 var table = 
						 `
					 <table id="house_list" width="100%" class='table'>
						<tr>
						 	<td>아파트 명<br>(클릭 시 매물 정보로 이동)
							</td>
							<td>동</td>
							<td>건축 년도</td>
							<td>지번</td>
						</tr>
							`
					 // Adding the entire table to the body tag
					 var infotag =document.getElementById('info');
					 if(infotag){
						 infotag.remove();
					 }
					 
					 var cardBody = 
					 fetch("getDong.house?dong=" + obj.dong.value+"&gugun="+obj.gugun.value+"&sido="+obj.sido.value)
						.then(response => response.text())
						.then(data => {
							console.log(data)
							var jsonObject = JSON.parse(data);
							for(json in jsonObject){
								console.log(jsonObject[json]);
								setCenter(jsonObject[json]["lat"],jsonObject[json]["lng"])
								table=table+
								`
								<tr>
									<td><a
										href="searchApt.house?aptCode=${jsonObject[json]["aptCode"]}&aptName=${jsonObject[json]["aptName"]}&lat=${jsonObject[json]["lat"]}&lng=${jsonObject[json]["lng"]}">${jsonObject[json]["aptName"]}</a></td>
									<td>${jsonObject[json]["dongName"]}</td>
									<td>${jsonObject[json]["buildYear"]}</td>
									<td>${jsonObject[json]["jibun"]}</td>
									<td style="display: none;">${jsonObject[json]["lat"]}</td>
									<td style="display: none;">${jsonObject[json]["lng"]}</td>
								</tr>
							`
							}
							table= table+
							`
							</table>
							`
							document.getElementById('ma').innerHTML = table;
							rowClicked2();


						});

				 }