/*
 * @file documentFormList.js
 * @brief 양식함 관리 페이지 관련 js
 * @author 김건훈
 */


$(function(){

	 /*
	  * @brief 사내전자결재규정 물음표 아이콘 Modal Event
	  * @author 김건훈
	  */	
	$('.ik-help-circle').on('mouseover',function(e){
			
		var ruleTipType = $(this).siblings().text()
		//console.log(ruleTipType)
		if(ruleTipType=='사내전자결재규정'){
			$('#modal-content-type').text('사내에서 전자결재 문서를 작성할 때 안내할 사항들을 기재할 수 있습니다.');	
		}else if(ruleTipType=='분류 설정'){
			$('#modal-content-type').text('문서 양식 분류 저장 시 띄어쓰기 와 공백은 저장되지 않습니다.');
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
	
	
	 /*
	  * @brief 검색창 드롭다운 검색키워드 변경 이벤트
	  * @author 김건훈
	  */	
	$('.dropdown-item').on('click',function(){
		//console.log('드롭다운버튼클릭');
		var searchType = $(this).text().trim();
		var tag = "<i class=\"ik ik-chevron-down mr-0 align-middle\"></i>";
		//console.log(searchType);
		$(this).parent().siblings('.dropdown-toggle').text(searchType);
		$(this).parent().siblings('.dropdown-toggle').append(tag);
	});
	
	
	/*
	  * @brief 문서양식 검색 Event
	  * @author 김건훈
	  */
	var documentFormSearchFn=  function(){
		 var sk = $('.search-keyword-btn').text().trim();
		 if(sk=='분류'){
			 sk='d_form_type';
		 }else if(sk=='양식명'){
			 sk='d_form_name';
		 }else if(sk=='약칭'){
			 sk='d_form_abbreviation';
		 }
		 var sv = $('#document-form-search-input').val().trim();
		 console.log(sk);
		 console.log(sv);
		 
		 location.href="/selectDocumentFormList?sk="+sk+"&sv="+sv+"";
	 };
	 
	 /*
	  * @brief 문서양식 검색 Event (Enter키 입력 시)
	  * @author 김건훈
	  */
	$('#document-form-search-input').keyup(function(key) {
		 if (key.keyCode == 13){
			 //console.log('검색이벤트')
			 documentFormSearchFn();
		 }	
	});
	
	 /*
	  * @brief 문서양식 검색 Event (검색버튼 클릭 시)
	  * @author 김건훈
	  */
	$('#document-form-search-btn').click(function() {			
			 documentFormSearchFn();
	});
		
		
		
	
	
	 /*
	  * @brief icheck plug-in 사용
	  * @author 김건훈
	  */

	$(".ea-icheck").iCheck({

		checkboxClass: 'icheckbox_square-blue'

	});
	 
	//페이지 로딩 시 체크박스 체크 초기화
	$('#all-ea-checkbox,.ea-checkbox').iCheck('uncheck');
	
	//문서양식리스트 행 개수
	var eaDocumentFormListCount = $('.documentFormListTr').length;

	 
	 /*
	  * @brief 각각 체크박스 체크 이벤트
	  * @author 김건훈
	  */

	  $('.ea-checkbox').on('ifChecked', function(event){
		  //console.log('체크박스클릭');
		  
		  //console.log(eaDocumentFormListCount);
		  
		  var checkCount  = $('.ea-checkbox:checked').length;
		  //console.log(checkCount);	
			  if(checkCount == eaDocumentFormListCount){							
				 	 $('#all-ea-checkbox').iCheck('check');
			  }else{
				  	 $('#all-ea-checkbox').iCheck('uncheck');
			  }
			  
			  if(checkCount>0){
					$('.table-row-delete-nav').css('visibility','visible')
				}else{
					$('.table-row-delete-nav').css('visibility','hidden')
				}
		  });
	
	  $('.ea-checkbox').on('ifUnchecked', function(event){
		  //console.log('체크박스클릭');
		  var checkCount  = $('.ea-checkbox:checked').length;
		  //console.log(checkCount);
			  if(checkCount == eaDocumentFormListCount){							
				 	 $('#all-ea-checkbox').iCheck('check');
			  }else{
				  	 $('#all-ea-checkbox').iCheck('uncheck');
			  }
			  
			  if(checkCount>0){
					$('.table-row-delete-nav').css('visibility','visible')
				}else{
					$('.table-row-delete-nav').css('visibility','hidden')
				}
		  });
	  
	 
	
	
	 /*
	  * @brief 전체 체크박스 체크 이벤트
	  * @author 김건훈
	  */
	  
	  $('#all-ea-checkbox').on('ifChecked', function(event){
		  
		  var checkCount  = $('.ea-checkbox:checked').length;
		  	 	
		  $('.ea-checkbox').iCheck('check');

	  });
	
		
	  $('#all-ea-checkbox').on('ifUnchecked', function(event){
		 
		  var checkCount  = $('.ea-checkbox:checked').length;
		  
		  if(checkCount == eaDocumentFormListCount){
		 		
			  $('.ea-checkbox').iCheck('uncheck');
		  }
	  });
	  
	  
	  /*
	   * @brief 사내 전자결재 수정 form 전환 Event
	   * @author 김건훈
	   */
	   $('.ea-rule-update-btn').on('click',function(){
		   //console.log('사내전자 결재 수정 버튼 클릭')
		   $('.ea-rule-update-after').css('display','block');
		   $('.ea-rule-update-btn-after').css('display','block');
		   
		   $('.ea-rule-update-before').css('display','none');
		   $('.ea-rule-update-btn-before').css('display','none');
		   
		   var eaRuleContents = $('#ea-rule-contents').html();
		   //console.log(eaRuleContents);
		   $('#ea-rule-update-summernote').summernote('code',eaRuleContents);
	   });
	  
	   $('.ea-rule-cancel-btn').on('click',function(){
		   //console.log('사내전자 결재 수정 취소 버튼 클릭')
		   $('.ea-rule-update-after').css('display','none');
		   $('.ea-rule-update-btn-after').css('display','none');
		   
		   $('.ea-rule-update-before').css('display','block');
		   $('.ea-rule-update-btn-before').css('display','block');
		   
		   $('#ea-rule-update-summernote').summernote('reset');
		   
	   });
	   
	   
	   /*
	    * @brief 문서양식 삭제 Event
	    * @author 김건훈
	    */
	   $('.ea-document-form-delete').on('click',function(){
		   swal({
	           title: "선택한 항목을 삭제하시겠습니까?",
	           text: "선택한 양식을 삭제하시겠습니까?",
	           icon: "warning",
	           buttons: ["취소", "삭제"],
	           dangerMode: true,
	       })
	       .then((willDelete) => {
	           if (willDelete) {
	        	   var eaDocumentFormListCodeArr = [];
	        	   
	        	   $('.ea-checkbox:checked').each(function(){
	        		   eaDocumentFormListCodeArr.push($(this).val());
	        		 });
	        	   //console.log(eaDocumentFormListCodeArr);
	        	   
	        	   var request = $.ajax({
					    url: "/deleteDocumentFormPro",
					    method: "POST",
					    data: JSON.stringify(eaDocumentFormListCodeArr),
					    dataType: "json",
					    contentType : 'application/json'
					  });
					   
					  request.done(function(data) {
					  	//console.log(data.result);
						  
						 swal({
			                   title: "삭제되었습니다.",
			                   text: "선택한 양식이	 삭제되었습니다.",
			                   icon: "success",
			                 })
			                 .then((value) => {
			                	 location.href="/selectDocumentFormList";
								  });
					  });
					   
		           }else{
		               swal("삭제가 취소되었습니다.");
		            }
					  request.fail(function( jqXHR, textStatus ) {
					    alert( "Request failed: " + textStatus );
					  }); 
	        	   
	       });
		   
	   });
	  
	   /*
	    * @brief 사내 전자결재 수정 완료 Event
	    * @author 김건훈
	    */
	    $('#ea-rule-update-submit-btn').on('click',function(){
	    	//console.log('수정완료 버튼 클릭')
	    	var eaRuleVal=$('#ea-rule-update-summernote').val();
	    	//console.log(eaRuleVal);
	    	
	    	      var request = $.ajax({
				    url: "/ajaxUpdateEaRule",
				    method: "POST",
				    data: {eaRuleVal : eaRuleVal},
				    dataType: "json"
				  });
				   
				  request.done(function(data) {
				  	//console.log(data.result);
					 $('.ea-rule-update-before').css('display','block');
					 $('.ea-rule-update-btn-before').css('display','block');
					 $('.ea-rule-update-after').css('display','none');
					 $('.ea-rule-update-btn-after').css('display','none');
					 $('#ea-rule-contents').html(eaRuleVal);
					 $('#ea-rule-update-summernote').summernote('reset');
					 
					 swal({
						 title: "수정되었습니다.",
						 text: "규정이 수정되었습니다.",
						 icon: "success"
						});
				  });
				   
				  
				  request.fail(function( jqXHR, textStatus ) {
				    alert( "Request failed: " + textStatus );
				  });  
	    });   
		   
		   
	   /*
	   * @brief 사내 전자결재 수정 화면 summernote plug-in 사용
	   * @author 김건훈
	   */
	   $('#ea-rule-update-summernote').summernote({   
             height: 300,                 
             minHeight: null,             
             maxHeight: null,             
             focus: true,      
             lang: "ko-KR",
             popover: {
                 image: [],
                 link: [],
                 air: []
               },
             toolbar: [
                    ['style', ['bold', 'italic', 'underline']],
                    ['font', ['strikethrough']],
                    ['fontsize', ['fontsize']],
                    ['color', ['color']],
                    ['para', ['paragraph']],
                    ['height', ['height']],
                    ['Insert', ['picture']],
                    ['Insert', ['link']],
                    ['table', ['table']]
                	   ]   
     });
	   
	   
	    /*
		 * @brief 문서 분류 삭제 Event
		 * @author 김건훈
		 */
	    
		var deleteDocumentFormTypeFn = function(){
			//console.log('분류삭제');	
			swal({
                title: "선택한 분류를 삭제하시겠습니까?",
                text: "해당 분류를 삭제하시면 기존 분류의 해당하는 문서 양식은 \"공통\" 분류로 지정됩니다. 계속하시겠습니까?",
                icon: "warning",
                buttons: ["취소", "삭제"],
                dangerMode: true,
            })
            .then((willDelete) => {
                if (willDelete) {
                	//console.log('삭제처리')
                	var deleteFormTypeCode=$(this).parents('span').siblings('.document-form-type-name').attr('value');
                	//console.log(deleteFormTypeCode);
                	//$(this).parents('.document-form-type-li').remove();
                	var documentFormTypeLi=$(this).parents('.document-form-type-li');
                	var request = $.ajax({
        			    url: "/ajaxDeleteDocumentFormType",
        			    method: "POST",
        			    data: {deleteFormTypeCode : deleteFormTypeCode},
        			    dataType: "json"
        			  	});
        			   
        			   request.done(function(data) {	
        				   //console.log('문서양식 분류 삭제완료');
        				   //console.log(data.result);
        				   documentFormTypeLi.remove();
        				   swal({
                               title: "삭제되었습니다.",
                               text: "선택한 분류가 삭제되었습니다.",
                               icon: "success",
                           });
        			   });
        			   
        			  
        			   request.fail(function( jqXHR, textStatus ) {
        			    alert( "Request failed: " + textStatus );
        			   }); 

                   
                } else {
                    swal("삭제가 취소되었습니다.");
                }
            });
		}
		$('.document-form-type-li').find('.ik-trash-2').on('click', deleteDocumentFormTypeFn);
		
		
		/*
		 * @brief 문서 분류 수정 Event
		 * @author 김건훈
		 */
		
		var updateDocumentFormTypeFn = function(){
			//console.log('분류수정');
			$(this).parents('span').siblings('.document-form-type-update-done-btn').css('display','block');
			$('.document-form-type-update-delete-btn').css('display','none');
			
			var updateDocumentFormLi=$(this).closest('.document-form-type-li').find('.document-form-type-name');
			var updateDocumentFormName=updateDocumentFormLi.text();
			//console.log(updateDocumentFormName+'<----수정하기 전 기존 값');
			var updateDocumentFormCode=updateDocumentFormLi.attr('value');
			updateDocumentFormLi.replaceWith('<input type="text" id="'+updateDocumentFormCode+'" class="update-document-form-input" style="width:70%" value="'+updateDocumentFormName+'">');
			

			$('.document-form-type-update-done-btn').off('click').on('click',function(){
				//console.log('문서양식 수정완료 버튼클릭')
				var updateDocumentFormInputVal = $('.update-document-form-input').val().replace(/ /g, '');
				//console.log(updateDocumentFormInputVal+'<----수정하기 위해 input에 입력한 문서양식분류 수정값 ')
				
				if(updateDocumentFormInputVal!=updateDocumentFormName&&updateDocumentFormInputVal!=''&&updateDocumentFormInputVal.length<=10){
					//console.log('입력한 값이 기존의 값과 달라야만 update 가능')
					var request = $.ajax({
						url: "/ajaxUpdateDocumentFormType",
						method: "POST",
						data: {	updateDocumentFormCode : updateDocumentFormCode,
								updateDocumentFormInputVal : updateDocumentFormInputVal
							  },
						dataType: "json"
					});
					
					request.done(function(data) {
						//console.log(data.result);
						  swal({
							   title: "수정되었습니다.",
							   text: "문서 분류가 수정 되었습니다.",
							   icon: "success"
						   });
					});
					
					request.fail(function( jqXHR, textStatus ) {
						alert( "Request failed: " + textStatus );
					}); 
				}
				
				if(updateDocumentFormInputVal==''){
					updateDocumentFormInputVal=updateDocumentFormName;
					swal({
	  					title: "분류명을 입력해주세요.",
	  					text: "분류명을 수정하기 위하여 입력해주세요.",
	  					icon: "error"
	  				});
				}
				
				if(updateDocumentFormInputVal.length>10){
					updateDocumentFormInputVal=updateDocumentFormName;
					swal({
	 					title: "분류명은 10 글자 이내로 작성해야합니다.",
	 					text: "분류명을 10글자 이내로 다시 작성해주세요.",
	 					icon: "error"
	 				});
				}
				
				$('.update-document-form-input').replaceWith('<span value="'+updateDocumentFormCode+'" class="document-form-type-name">'+updateDocumentFormInputVal+'</span>');
				$('.document-form-type-update-done-btn').css('display','none');
				$('.document-form-type-update-delete-btn').css('display','block');
				
			  });
			
			$('.update-document-form-input').keyup(function(key) {
				 if (key.keyCode == 13){
					//console.log('문서양식분류 수정을위한 엔터키 입력')
					var updateDocumentFormInputVal = $('.update-document-form-input').val().replace(/ /g, '');
					//console.log(updateDocumentFormInputVal+'<----수정하기 위해 input에 입력한 문서양식분류 수정값 ')
					
					if(updateDocumentFormInputVal!=updateDocumentFormName&&updateDocumentFormInputVal!=''&&updateDocumentFormInputVal.length<=10){
						//console.log('입력한 값이 기존의 값과 달라야만 update 가능')
						var request = $.ajax({
							url: "/ajaxUpdateDocumentFormType",
							method: "POST",
							data: {	updateDocumentFormCode : updateDocumentFormCode,
									updateDocumentFormInputVal : updateDocumentFormInputVal
								  },
							dataType: "json"
						});
						
						request.done(function(data) {
							//console.log(data.result);
							  swal({
								   title: "수정되었습니다.",
								   text: "문서 분류가 수정 되었습니다.",
								   icon: "success"
							   });
						});
						
						request.fail(function( jqXHR, textStatus ) {
							alert( "Request failed: " + textStatus );
						}); 
					}
					
					if(updateDocumentFormInputVal==''){
						updateDocumentFormInputVal=updateDocumentFormName;
						swal({
		  					title: "분류명을 입력해주세요.",
		  					text: "분류명을 수정하기 위하여 입력해주세요.",
		  					icon: "error"
		  				});
					}
					
					if(updateDocumentFormInputVal.length>10){
						updateDocumentFormInputVal=updateDocumentFormName;
						swal({
		 					title: "분류명은 10 글자 이내로 작성해야합니다.",
		 					text: "분류명을 10글자 이내로 다시 작성해주세요.",
		 					icon: "error"
		 				});
					}
					
					$('.update-document-form-input').replaceWith('<span value="'+updateDocumentFormCode+'" class="document-form-type-name">'+updateDocumentFormInputVal+'</span>');
					$('.document-form-type-update-done-btn').css('display','none');
					$('.document-form-type-update-delete-btn').css('display','block');
				 }
			 });
			    	
			}
		$('.document-form-type-li').find('.ik-edit').on('click', updateDocumentFormTypeFn);
		
		
		/*
		 * @brief 문서 분류 추가 Event
		 * @author 김건훈
		 */
	   	var insertDocumentFormTypeFn=function(){
	   	   
		   	var inputDocumentFormTypeVal=$('#add-document-form-type-input').val().replace(/ /g, '');
		   	
		   		var request = $.ajax({
		   			url: "/ajaxInsertDocumentFormType",
		   			method: "POST",
		   			data: {inputDocumentFormTypeVal : inputDocumentFormTypeVal},
		   			dataType: "json"
		   		});
		   		
		   		request.done(function(data) {
		   				//console.log(data.result);
		   			if(data.result==0){
		   				//console.log(inputDocumentFormTypeVal);
		   				swal({
		   					title: "중복된 분류명입니다.",
		   					text: "["+inputDocumentFormTypeVal+"]"+" 은(는) 중복된 분류명입니다.",
		   					icon: "error"
		   				});
		   				
		   			}else{
		   				//console.log(data.formTypeCode);
		   				var documentFormTypeLi = $('.document-form-type-clone:last').clone();
		   				//console.log(documentFormTypeLi)
		   				
		   				documentFormTypeLi.find('.document-form-type-name').text(inputDocumentFormTypeVal);
		   				documentFormTypeLi.find('.document-form-type-name').attr('value',data.formTypeCode);
		   				documentFormTypeLi.css('display','block');
		   				documentFormTypeLi.appendTo('.document-form-type-ul');
		   				
		   				documentFormTypeLi.find('.ik-edit').click(updateDocumentFormTypeFn);				   
		   				documentFormTypeLi.find('.ik-trash-2').click(deleteDocumentFormTypeFn);
		   				
		   				swal({
		   					title: "추가되었습니다.",
		   					text: "문서 분류가 추가되었습니다.",
		   					icon: "success"
		   				});
		   				
		   				$('#add-document-form-type-input').val('');
		   			}
		   			
		   		});
		   		
		   		
		   		request.fail(function( jqXHR, textStatus ) {
		   			alert( "Request failed: " + textStatus );
		   		});   
		   		
		   	
		   		
	   } 

	   
	    $('#add-document-form-type-btn').on('click',function(){
	    	//console.log('분류 추가버튼')
	    	var inputDocumentFormTypeVal=$('#add-document-form-type-input').val().replace(/ /g, '');
	  
	    	//console.log(inputDocumentFormTypeVal);
	    	//console.log(inputDocumentFormTypeVal.length+'<------- 문서양식분류 추가하기 위해 입력한 값 글자 수');
	    	//console.log(inputDocumentFormTypeVal.indexOf('')+'<------- 문서양식분류 추가하기 위해 입력한 값 공백 포함여부');
	    	
		   	if(inputDocumentFormTypeVal!=''&&inputDocumentFormTypeVal.length<=10){
		   		insertDocumentFormTypeFn();
		   }else if(inputDocumentFormTypeVal==''){
			   //console.log('문서양식분류 입력값이 공백일 경우')
			   swal({
  					title: "분류명을 입력해주세요.",
  					text: "분류명을 추가하기 위하여 입력해주세요.",
  					icon: "error"
  				});
		   }else if(inputDocumentFormTypeVal>10){
			   //console.log('문서양식분류 입력값 글자 수 초과 경우')
			   swal({
 					title: "분류명은 10 글자 이내로 작성해야합니다.",
 					text: "분류명을 10글자 이내로 다시 작성해주세요.",
 					icon: "error"
 				});
		   }
	    });
	 
	   
	    $('#add-document-form-type-input').keyup(function(key) {
	    	if (key.keyCode == 13){
	    		
	    		if($(this).val().replace(/ /g, '')!='' && $(this).val().trim().length<=10){
	    			insertDocumentFormTypeFn();
	    		}else if($(this).val().replace(/ /g, '')==''){
	    			//console.log('문서양식분류 입력값이 공백일 경우')
	    			swal({
	  					title: "분류명을 입력해주세요.",
	  					text: "분류명을 추가하기 위하여 입력해주세요.",
	  					icon: "error"
	  				});
	    		}else if($(this).val().replace(/ /g, '').length>10){
	    			//console.log('문서양식분류 입력값 글자 수 초과 경우')
	    			swal({
	 					title: "분류명은 10 글자 이내로 작성해야합니다.",
	 					text: "분류명을 10글자 이내로 다시 작성해주세요.",
	 					icon: "error"
	 				});
	    		}
	    	}
	    });
	    
	    
	    /*
		 * @brief 문서 양식 미리보기
		 * @author 김건훈
		 */
	    
	    $('.documentFormListTr').on('click', function(){
	    	//console.log('문서양식 미리보기');
	    	var dFormCode = $(this).find('.ea-checkbox').val();
	    	//console.log(dFormCode);
	    	
	    	var request = $.ajax({
				url: "/ajaxSelectDocumentFormForDetail",
				method: "POST",
				data: {	
						dFormCode : dFormCode
					  },
				dataType: "json"
			});
			
			request.done(function(data) {
				//console.log(data.dFormDetailContent);
				//console.log(data.dApprovalFormatDetailContent);
				$('#document-form-modal-view-title').text(data.dFormName);
				$('.modal-body-document-form-approval-format').html(data.dApprovalFormatDetailContent);
				if(data.dFormDetailContent=='' || data.dFormDetailContent==null){
					data.dFormDetailContent='작성된 문서양식 상세내용이 없습니다.'
				};
				$('.modal-body-document-form-detail-content').html(data.dFormDetailContent);
				
				$('#select-document-form-detail').attr('href','/selectDocumentFormDetail?dFormCode='+data.dFormCode+'')
			});
			
			request.fail(function( jqXHR, textStatus ) {
				alert( "Request failed: " + textStatus );
			}); 
	    	
	    });
});