/*
 * 프로젝트리스트 관련 제이쿼리
 * 김연지
 * */

function setCookie(cname, cvalue, exdays) {
  var d = new Date();
  d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
  var expires = "expires="+d.toUTCString();
  document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
}

function getCookie(cname) {
  var name = cname + "=";
  var ca = document.cookie.split(';');
  for(var i = 0; i < ca.length; i++) {
    var c = ca[i];
    while (c.charAt(0) == ' ') {
      c = c.substring(1);
    }
    if (c.indexOf(name) == 0) {
      return c.substring(name.length, c.length);
    }
  }
  return "";
}

$(function() {
	
				var gridViewType = getCookie('gridViewType');
				if(gridViewType == 'list'){
					$('.project-card').css('display','none');
					$('.pr-table-list').css('display','block');
					$('.view-list').addClass('active');
					$('.view-grid').removeClass('active');
				}else{
					$('.project-card').css('display','flex');
					$('.pr-table-list').css('display','none');
					$('.view-list').removeClass('active')
					$('.view-grid').addClass('active');
				}
					
				$('.view-list').click(function(){
						$('.project-card').css('display','none');
						$('.pr-table-list').css('display','block');
						setCookie('gridViewType', 'list', 1);
					});
					 
					
				$('.view-grid').click(function(){
					$('.project-card').css('display','flex');
					$('.pr-table-list').css('display','none');
					setCookie('gridViewType', 'grid', 1);
				})
							
					
				// 프로젝트 추가 모달
					// submit 버튼 클릭시 프로젝트제목 유효성검사
					$(".pr-submit-btn").click(function(checkInput) {
												
						if ($('[name="projectTitle"]').val() == '') {
							$('[name="projectTitle"]').css("border",
									"1px solid red");
							$('[name="projectTitle"]').focus();
							return false;
						}
						
						projectAddForm.action = "/projectInsert";
						projectAddForm.submit();

					})
					// 멤버추가버튼 클릭시 셀렉트 활성화
					$(".member-add-btn").click(function() {
						$('#add-select2').select2('open');
					})

				// 프로젝트 클릭시 /taskList로 이동
					$(".project-list").on('click',function(projectListClick) {
								var projectCode = $(this).find('.project-code-input').val();
								var projectTitle = $(this).find('h3').text();
								
								console.log(projectCode);
								console.log(projectTitle);
								
								location.href = '/taskList?projectCode='
										+ projectCode + '&projectTitle='
										+ projectTitle + '';

							})
					$(".project-list-tr").on('click', function() {
							var projectCode = $(this).attr('data-projectCode');
							var projectTitle = $(this).attr('data-projectTitle');							
							location.href='/taskList?projectCode='+projectCode+'&projectTitle='+projectTitle;								
					});

		
				// 프로젝트 수정 모달
					$(".pr-setting-btn").on('click', function() {
						// console.log('프로젝트 수정 버튼 클릭')
					// 프로젝트 모달 바깥 영역 클릭X
						event.stopPropagation();
					
						 
						var delProject = $(this).parents('.project-list-wrap');
						var projectCode = $(this).parent().parent('.pr-ikon').parents(".pr-header").find('.project-code-input').val();
							console.log(projectCode);						
						var request = $.ajax({
							url: "/projectModalopen",
							method:"GET",
							data: {
								'projectCode' : projectCode
							},
							dataType: "html"
						});
						
						
						request.done(function(data) {									
							
							if($('#editLayoutItem').length > 0){				
								$('#editLayoutItem').remove();
							}							
							
							$('#editLayoutItem').modal({ backdrop : 'static' });
							$('body').append(data);
								
							$('.select2').select2();
							
							$(".member-update-btn").click(function() {
								$('#update-select2').select2('open');
							})
							
						
													
							$('#editLayoutItem').modal({
								backdrop : 'static'
							})
						
							var listDelete = $('.project-delete-btn');
				            listDelete.on('click', function() {
				                swal({
				                    title: "해당 프로젝트를 삭제하시겠습니까?",
				                    icon: "warning",
				                    buttons: ["취소", "삭제"],
				                    dangerMode: true,
				                })
				                .then((willDelete) => {
				                    if (willDelete) {
				                    	console.log('삭제버튼클릭');
				                    	var request = $.ajax({
				                    	  url: "/projectDelete",
				                    	  method: "POST",
				                    	  data: { 'projectCode' : projectCode },
				                    	  dataType: "json"
				                    	});
				                    	 
				                    	request.done(function( data ) {
				                    		console.log('삭제');
				                    		console.log(data.result);
				                    		if(data.result==1){
				                    			delProject.remove();
				                    		}
				                    		$('.close').click();
				                    		
				                    		
				                    	});
				                    	 
				                    	request.fail(function( jqXHR, textStatus ) {
				                    	  alert( "Request failed: " + textStatus );
				                    	});
				                    	
				                        swal({
				                            title: "프로젝트가 삭제되었습니다.",
				                            icon: "success",
				                        });
				                    } else {
				                        swal("삭제가 취소되었습니다.");
				                    }
				                });
				            });
						});
						request.fail(function( jqXHR, textStatus ) {
							alert( "Request failed: " + textStatus );
						}); 
						
					})
				})