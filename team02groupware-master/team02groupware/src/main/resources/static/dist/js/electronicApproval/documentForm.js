/*
 * @file documentForm.js
 * @brief 양식생성 페이지 관련 js
 * @author 김건훈
 */

		$(function(){
				
					/*
					  * @brief 옵션 선택 드롭다운 키워드 변경 이벤트
					  * @author 김건훈
					  */	
					$('.dropdown-item').on('click',function(){
						//console.log('드롭다운버튼클릭');
						var searchType = $(this).text();
						var searchTypeVal=$(this).attr('value');
						var tag = "<i class=\"ik ik-chevron-down mr-0 align-middle\"></i>";
						//console.log(searchType);
						//console.log(searchTypeVal);
						$(this).parent().siblings('.dropdown-toggle').text(searchType);
						$(this).parent().siblings('.dropdown-toggle').attr('value',searchTypeVal);
						$(this).parent().siblings('.dropdown-toggle').append(tag);
					});
					
					
					/*
					  * @brief icheck plug-in 사용
					  * @author 김건훈
					  */

					$(".ea-icheck").iCheck({

						checkboxClass: 'icheckbox_square-blue'

					});
					 
					 //페이지 로딩 시 체크박스 체크 초기화
					$('.ea-checkbox').iCheck('uncheck');
					
					 
					 /*
					  * @brief 양식생성 페이지 테이블 내 약칭,보존연한,보안등급 물음표 아이콘 Modal Event
					  * @author 김건훈
					  */	
					$('.ik-help-circle').on('mouseover',function(e){
						//console.log('마우스오버');
						var ruleTipType = $(this).siblings().text()
						//console.log(ruleTipType)
						if(ruleTipType=='약칭'){
							$('#modal-content-type').text('약칭은 문서 번호에 쓰이기 때문에 간단할 수록 좋습니다. 중복하여 사용할 수 있지만 구분하는 것이 좋습니다.');	
						}else if(ruleTipType=='보존 연한'){
							$('#modal-content-type').text('문서의 초기값으로 설정 할 보존연한을 선택합니다. 변경 금지 선택 시 기안자와 결재자가 이를 수정할 수 없습니다. 보존 연한이 만료되면 삭제 문서 목록으로 이동합니다.');
						}else if(ruleTipType=='보안 등급'){
							$('#modal-content-type').text('문서의 초기값으로 설정 할 보안등급을 선택합니다. 변경 금지 선택 시 기안자와 결재자가 이를 수정할 수 없습니다. 보안 등급에 따라 열람 권한이 제한됩니다.');
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
					   $('#document-form-detail-content-summer-note').summernote({
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
					
					   /* 뒤로가기 버튼 클릭시 팝업창 */
					   $(document).keyup(function() {
						  
						   //크롬 상위 버전 이라 custom messeage 지원 안함
						   $(window).on("beforeunload", function() {
							    return "";
							});
					
					   });
					   	
					   /*
						* @brief 결재 포맷 양식 설정 Event
						* @author 김건훈
						*/	
					   $('.approval-format-set-btn').on('click',function(){
						   //console.log('결재포맷선택버튼')
						   var approvalFormatRadioVal = $('.approval-format-radio').find('input:checked').val();
						   //console.log(approvalFormatRadioVal);
						   if(approvalFormatRadioVal=='EAAPF001'){
							   $('#selected-approval-format-1').css('display','block');
							   $('#approval-format-set-btn').text('변경');
							   $(this).attr('data-dismiss','modal');
							   
						   }else{
							  
							   $(this).removeAttr('data-dismiss');
							   swal({
				 					title: "해당 결재 양식은 준비 중 입니다.",
				 					text: "다른 결재 양식을 선택해주세요.",
				 					icon: "error"
				 				});
						   }
					   });
					   
					   /*
						* @brief 문서 양식 생성 Event(유효성 검사 포함)
						* @author 김건훈
						*/	
					   $('#insert-document-form-submit-btn').on('click',function(){
						   //console.log('문서 양식 생성 버튼 클릭')
						  
						   if($('#document-form-type-drop-down').attr('value')!=null){  
							   var dFormTypeCode=$('#document-form-type-drop-down').attr('value').trim(); //문서양식분류 드롭다운
						   }
						   var dFormName=$('#document-form-name-input').val().trim(); //문서 양식 명 입력값
						   var dFormAbbreviation=$('#document-form-abbre-input').val().trim(); // 문서 양식 약칭 입력값
						   var dFormDetailExplanation=$('#document-form-detail-input').val().trim(); // 문서 양식 설명 입력값
						   var dExpiryDate=$('#document-form-expiry-drop-down').text().trim(); // 문서 기안시 초기 보존연한 값
						   var dSecurityLevel=$('#document-form-security-drop-down').text().trim().substring(0,1); // 문서 기안시 초기 보안등급 값
						   var dExpiryDateChangeable=$('#document-form-expiry-check-box').is(":checked") // 문서 보존연한 변경 여부 체크
						   if(dExpiryDateChangeable==true){
							   dExpiryDateChangeable='Y';
						   }else{
							   dExpiryDateChangeable='N';
						   }
						   var dSecurityLevelChangeable=$('#document-form-security-check-box').is(":checked") // 문서 보안등급 변경 여부 체크
						   if(dSecurityLevelChangeable==true){
							   dSecurityLevelChangeable='Y';
						   }else{
							   dSecurityLevelChangeable='N';
						   }
						   var dApprovalFormatCode=$('.approval-format-radio').find('input:checked').val(); // 결재 양식 선택 값
						   var dFormDetailContent=$('#document-form-detail-content-summer-note').val(); //문서 양식 상세 입력 값
						  
						   /*console.log(dFormTypeCode);
						   console.log(dFormName);
						   console.log(dFormAbbreviation);
						   console.log(dFormDetailExplanation);
						   console.log(dExpiryDate);
						   console.log(dSecurityLevel);
						   console.log(dExpiryDateChangeable);
						   console.log(dSecurityLevelChangeable);
						   console.log(dApprovalFormatCode);
						   console.log(dFormDetailContent);*/
						   
						   if(dFormTypeCode==null || dFormTypeCode==''){
							   //console.log('분류를 선택해주세요.');
							   swal({
				 					title: "선택된 분류가 없습니다.",
				 					text: "문서 양식 분류를 선택해주세요.",
				 					icon: "error"
				 				});
							   return;
						   }else if(dFormName==''||dFormName==null){
							   
							   swal({
				 					title: "입력된 문서 양식명이 없습니다.",
				 					text: "문서 양식명을 입력해주세요.",
				 					icon: "error"
				 				});
							   return;
						   }else if(dFormAbbreviation==''||dFormAbbreviation==null){
							   
							   swal({
				 					title: "입력된 문서 양식 약칭이 없습니다.",
				 					text: "문서 양식 약칭을 입력해주세요.",
				 					icon: "error"
				 				});
							   return;
						   }else if(dExpiryDate=='보존연한 선택'){
							   
							   swal({
				 					title: "선택된 보존연한이 없습니다.",
				 					text: "보존연한을 선택해주세요.",
				 					icon: "error"
				 				});
							   return;
						   }else if(dSecurityLevel=='보안등급 선택'){
							  
							   swal({
				 					title: "선택된 보안등급이 없습니다.",
				 					text: "보안등급을 선택해주세요.",
				 					icon: "error"
				 				});
							   return;
						   }else if($('#approval-format-set-btn').text()=='설정'){

							   swal({
				 					title: "선택된 결재양식이 없습니다.",
				 					text: "결재양식을 선택해주세요.",
				 					icon: "error"
				 				});
							   return;
						   }
						   
						   /*console.log(dFormTypeCode);
						   console.log(dFormName);
						   console.log(dFormAbbreviation);
						   console.log(dFormDetailExplanation);
						   console.log(dExpiryDate);
						   console.log(dSecurityLevel);
						   console.log(dExpiryDateChangeable);
						   console.log(dSecurityLevelChangeable);
						   console.log(dApprovalFormatCode);
						   console.log(dFormDetailContent);*/
						   
						   insertDocumentFormMap = {};
							  
						   insertDocumentFormMap.dFormTypeCode = dFormTypeCode;
						   insertDocumentFormMap.dFormName = dFormName;
						   insertDocumentFormMap.dFormAbbreviation = dFormAbbreviation;
						   insertDocumentFormMap.dFormDetailExplanation = dFormDetailExplanation;
						   insertDocumentFormMap.dExpiryDate = dExpiryDate;
						   insertDocumentFormMap.dSecurityLevel = dSecurityLevel;
						   insertDocumentFormMap.dExpiryDateChangeable = dExpiryDateChangeable;
						   insertDocumentFormMap.dSecurityLevelChangeable = dSecurityLevelChangeable;
						   insertDocumentFormMap.dApprovalFormatCode = dApprovalFormatCode;
						   insertDocumentFormMap.dFormDetailContent = dFormDetailContent;
							
						   console.log(insertDocumentFormMap);
						   
						   var request = $.ajax({
							    url: "/insertDocumentFormPro",
							    method: "POST",
							    data: insertDocumentFormMap,
							    dataType: "json"
							  });
							   
							  request.done(function(data) {
								  //console.log(data.result);
								  $(window).unbind();
								  swal({
									  title: "저장되었습니다.",
		                               text: "문서 양식이 저장되었습니다.",
		                               icon: "success",
									})
									.then((success) => {
									  location.href="/selectDocumentFormList";
									});
							  });
							   
							  request.fail(function( jqXHR, textStatus ) {
							    alert( "Request failed: " + textStatus );
							  }); 
						   
					   });
					   
				});