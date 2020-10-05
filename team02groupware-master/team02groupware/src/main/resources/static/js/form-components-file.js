(function($) {
  'use strict';
  $(function() {
	  
	// 파일 선택 클릭시
    $(document).on('click', '.file-upload-browse', function() {
      var file = $(this).parent().parent().find('.file-upload-default');
      file.trigger('click');
      
    });
    
    // 파일 선택
    $(document).on('change', '.file-upload-default', function(e) {
    	
    	var file = $(this).parent().parent().find('.file-upload-default');
    	console.log(file.val());
    	var files = e.target.files; // FileList 객체
    	  console.log(files);
    	  console.log(files[0]);
    	var fileSize = files[0].size;
    	var maxSize = 5 * 1024 * 1024;	// 5MB
    	var addFileSize = 0;
    	
    	$(this).siblings('.fileSizeCheck').val('');
    	
    	$('.fileSizeCheck').each(function (index, item){
    		
    		console.log('횟수체크')
    		
    		addFileSize += Number($(this).val());
    	});
    	
    	console.log('파일사이즈 합계 : ', addFileSize)
    	console.log('현재 파일 사이즈 : ', fileSize)
    	
    	addFileSize += fileSize;
    	console.log('두개 합한거 : ', addFileSize)

    	$(this).siblings('.fileSizeCheck').val(fileSize);
    	
    	// 파일 사이즈 유효성검사
    	if(addFileSize > maxSize){
    		file.val("");
    		console.log(file.val());
    		alert('첨부파일의 용량은 5MB 이내로 등록 가능합니다.')
    		
    	}else{
    		// 파일 사이즈 문자열 추가
        	if(fileSize < 1024){
        		fileSize = fileSize+"바이트";
        	}else if(fileSize < 1048576){
        		fileSize = Math.floor((fileSize / 1024)*100)/100+"KB";
        	}else if(fileSize < 1.0737e+9){
        		fileSize = Math.floor((fileSize / 1048576)*100)/100+"MB";
        	}
        	
          
          $(this).parent().find('.form-control').val($(this).val().replace(/C:\\fakepath\\/i, '')+" "+fileSize);
    	}
    });
    
    
    $(document).on('click', '.file-update-cancle', function(e) {
    	
    	e.preventDefault();
    	
    	if(confirm('파일을 내리시겠습니까?')){
    		
    		var file = $(this).parent().find('.file-upload-default');
    		var fileNum = $(this).prev().attr('fileNum');
    		var thisInputGroup = $(this).closest('.file-input-group');
    		var delNumTag = '<input type="hidden" class="file-delete-num" name="fileDeleteNum" value='+fileNum+'>';
    		
    		file.val("");
    		$(this).prev().val("");
    		$(this).next().val(fileNum);
    		
    		$('#boardUpdateForm').append(delNumTag);
    		thisInputGroup.remove();
    		
    		console.log(fileNum);
    		
    	}else{}
        
    });
    
    
    $(document).on('click', '.file-upload-cancle',function(e) {
    	
    	e.preventDefault();
    	
    	var inputGroup = $(this).closest('.file-input-group');
    	var fileInputGroup = $('.file-group-div').find('.file-input-group');
    	
    	console.log(inputGroup.length)
    	
    	if(fileInputGroup.length == 1){
    		$(this).prev().val('');
    	}else{
    		inputGroup.remove();
    	}
    	
        
    });
    
    // 게시판 글쓰기화면 파일 추가버튼
    $('.file-add-btn').on('click', function() {
    	
    	var fileInputGroupLength = $('.file-input-group').length;
    	console.log(fileInputGroupLength);
    	
    	if(fileInputGroupLength >= 5){
    		
    		alert('파일은 최대 5개까지 첨부하실 수 있습니다.')
    		
    	}else{
    		
    		var fileInputGroup = $('.file-input-group').eq(0).clone();
        	fileInputGroup.find('.file-upload-info').val('');
    	   			    
        	$('.file-group-div').append(fileInputGroup)
    	}
    });
    
    // 게시판 수정화면 파일추가 버튼
    $('.file-add-btn-update').on('click', function() {
    	
    	var fileInputGroupLength = $('.file-input-group').length;
    	console.log(fileInputGroupLength);
    	
    	if(fileInputGroupLength >= 5){
    		
    		alert('파일은 최대 5개까지 첨부하실 수 있습니다.')
    		
    	}else{
    		
    		var fileInputGroup = '<div class="file-input-group input-group col-xs-5">'
    			fileInputGroup += '<input type="file" name="file" class="file-upload-default"/>'
    			fileInputGroup += '<input type="text" class="form-control file-upload-info" placeholder="선택된 파일이 없습니다." readonly="readonly">'
    			fileInputGroup += '<a class="file-upload-cancle" href="#" style="padding:0;">'
    			fileInputGroup += '<i class="ik ik-x-square" style="color: red;"></i>'
    			fileInputGroup += '</a>'
    			fileInputGroup += '<div style="width:20px;"></div>'
    			fileInputGroup += '<span class="input-group-append">'
    			fileInputGroup += '<button class="file-upload-browse btn btn-primary" type="button">파일 선택</button>'
    			fileInputGroup += '</span>'
    			fileInputGroup += '</div>'

        	$('.file-group-div').append(fileInputGroup)
    	}
    	
    });
    
    

  });
})(jQuery);

