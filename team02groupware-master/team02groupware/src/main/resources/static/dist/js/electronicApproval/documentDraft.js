/*
 * @file documentDraft.js
 * @brief 기안하기 페이지 관련 js
 * @author 김건훈
 */

		$(function(){

			 /*
			  * @brief 옵션 선택 드롭다운 키워드 변경 이벤트
			  * @author 김건훈
			  */	
			$(document).on('click','.dropdown-item',function(){
				//console.log('드롭다운버튼클릭');
				var searchType = $(this).text();
				var searchTypeVal=$(this).attr('value');
				var tag = "<i class=\"ik ik-chevron-down mr-0 align-middle\"></i>";
				//console.log(searchType);
				$(this).parent().siblings('.dropdown-toggle').text(searchType);
				$(this).parent().siblings('.dropdown-toggle').attr('value',searchTypeVal);
				$(this).parent().siblings('.dropdown-toggle').append(tag);
				
				
				
				
			});
			
			
			 /*
			  * @brief 문서양식 분류 선택시 종류 가져오는 Event
			  * @author 김건훈
			  */	
			$('.document-form-type-dropdown-item').on('click',function(){
				//console.log('드롭다운버튼클릭');
				
				var dFormTypeCode=$(this).attr('value');
				$('.draft-document-form-name-drop-down-clone').remove();
				
				//console.log(dFormTypeCode);
				
				//문서양식 분류 선택시 종류 가져오는 Event
				var request = $.ajax({
				    url: "/selectDocumentFormTypeForInsertDocumentDraft",
				    method: "POST",
				    data: { dFormTypeCode : dFormTypeCode },
				    dataType: "json"
				  });
				   
				  request.done(function(data) {
					  //console.log(data.result);
					  //console.log(data.result.length);
					  for(var i=0; i<data.result.length; i++){
						  var documentFormName = $('.draft-document-form-name-drop-down').first().clone();
						  documentFormName.text(data.result[i].dFormName);
						  documentFormName.attr('value',data.result[i].dFormCode);
						  documentFormName.css('display','block');
						  documentFormName.addClass('draft-document-form-name-drop-down-clone');
						  $('#draft-document-form-name-drop-down-menu').append(documentFormName);
					  }
		
				  });
				   
				  request.fail(function( jqXHR, textStatus ) {
				    alert( "Request failed: " + textStatus );
				  }); 
				
				
				
				
				$('#draft-document-form-type-drop-down').css('visibility','visible');
			});
			
			
			 /*
			  * @brief 문서양식 종류 선택시 문서양식 가져오는 Event
			  * @author 김건훈
			  */	
			$(document).on('click','.draft-document-form-name-drop-down-clone',function(){
				//console.log('드롭다운버튼클릭');
				
				var dFormCode=$(this).attr('value');

				//console.log(dFormCode);
				
				//문서양식 종류 선택시 문서양식 가져오는 Event
				var request = $.ajax({
				    url: "/selectDocumentFormTypeForInsertDocumentDraft",
				    method: "POST",
				    data: { dFormCode : dFormCode },
				    dataType: "json"
				  });
				   
				  request.done(function(data) {
					  //console.log(data.result);
					
					  var searchType = $('#draft-document-form-type-name-drop-down').text().trim();
					  //console.log(searchType);
					  $('#draft-approval-format-table-after').css('visibility','visible');
					  $('#draft-documnet-contents').css('display','block');
					  $('#draft-documnet-before').css('display','none');
					  
					
					  $('#draft-document-form-expiry-date').text(data.result[0].dExpiryDate);
					  $('#draft-document-form-security-level').text(data.result[0].dSecurityLevel+'등급');
					  
				
					  if(searchType=='프로젝트'){
						  $('#project-document-section').css('visibility','visible');
					  }
					  
					  $('#draft-document-summernote').summernote('code',data.result[0].dFormDetailContent);
				  });
				   
				  request.fail(function( jqXHR, textStatus ) {
				    alert( "Request failed: " + textStatus );
				  }); 
				
				
				
				
				
			});
			
			
			 
			/*
			  * @brief 기안하기 페이지 테이블 내 보존연한,보안등급 물음표 아이콘 Modal Event
			  * @author 김건훈
			  */	
			$('.ik-help-circle').on('mouseover',function(e){
				//console.log('마우스오버');
				var ruleTipType = $(this).siblings().text()
				console.log(ruleTipType)
				if(ruleTipType=='보존 연한'){
					$('#modal-content-type').text('문서양식의 초기값으로 설정 된 보존연한을 표시합니다. 보존 연한이 만료되면 삭제 문서 목록으로 이동합니다.');
				}else if(ruleTipType=='보안 등급'){
					$('#modal-content-type').text('문서의 초기값으로 설정 된 보안등급을 표시합니다. 보안 등급에 따라 열람 권한이 제한됩니다.');
				}
				var divLeft = e.pageX - 150
				var divTop = e.pageY - 50
					
				$('.ruletip').css({display:"block", "top": divTop, "left": divLeft});
				
				$(this).css("color","black");
				
			});
		
			$('.ik-help-circle').on('mouseleave',function(){
				
				$('.ruletip').css("display","none");
				$(this).css("color","#bcc8d8");
			});
			
				/* summernote plug-in */
			   $('#draft-document-summernote').summernote({
		             height: 300,                 
		             minHeight: null,             
		             maxHeight: null,             
		             focus: true,      
		             lang: "ko-KR",
		             popover: {
		                 image: [],
		                 link: [],
		                 air: []
		               }
		     });
					   
				});