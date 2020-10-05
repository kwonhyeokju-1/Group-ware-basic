(function($) {
    'use strict';
    $(function() {
    $('.file-upload-browse').on('click', function() {
        var file = $(this).parent().parent().parent().find('.file-upload-default');
        file.trigger('click');
      });
      $('.file-upload-default').on('change', function() {
        $(this).parent().find('.form-control').val($(this).val().replace(/C:\\fakepath\\/i, ''));
      });
    });
 
    $(document).ready(function() {
        var listDelete = $('.list-delete');
        listDelete.on('click', function() {
            swal({
                title: "Are you sure?",
                text: "Do you really want to delete this item?",
                icon: "warning",
                buttons: ["Cancel", "Delete Now"],
                dangerMode: true,
            })
            .then((willDelete) => {
                if (willDelete) {
                    swal({
                        title: "Deleted",
                        text: "The list item has been deleted!",
                        icon: "success",
                    });
                } else {
                    swal("The item is not deleted!");
                }
            });
        });
        $('.html-editor').summernote({
          height: 300,
          tabsize: 2
        });
    })

    
$(document).ready(function() {
	/*
	 * @file layouts.js
	 * @brief 전자결재 관련 테이블 row 삭제시 SweetAlert Library 수정
	 * @author 김건훈
	 */
        var listDelete = $('.ea-list-delete');
        listDelete.on('click', function() {
            swal({
                title: "선택한 항목을 삭제하시겠습니까?",
                text: "선택한 문서를 삭제하시겠습니까?",
                icon: "warning",
                buttons: ["취소", "삭제"],
                dangerMode: true,
            })
            .then((willDelete) => {
                if (willDelete) {
                    swal({
                        title: "삭제되었습니다.",
                        text: "선택한 문서가 삭제되었습니다.",
                        icon: "success",
                    });
                } else {
                    swal("삭제가 취소되었습니다.");
                }
            });
        });
        
 
        
        $('.html-editor').summernote({
          height: 300,
          tabsize: 2
        });
    }) 
})(jQuery);