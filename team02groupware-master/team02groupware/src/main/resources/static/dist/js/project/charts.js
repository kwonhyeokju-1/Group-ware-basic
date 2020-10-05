//myTask.html 도넛 차트 제이쿼리 

$(function() {

	var c3DonutChart = c3.generate({
		bindto : '#task-status-chart',
		data : {
			columns : [ [ "완료", taskSuccess ], [ "마감일 지남", taskAfterDeadline ],
					[ "계획됨", taskPlanning ], [ "마감일 없음", taskNodeadline ],
			],
			type : 'donut',
			onclick : function(d, i) {
			},
			onmouseover : function(d, i) {
			},
			onmouseout : function(d, i) {
			}
		},
		color : {
			pattern : [ 'rgba(88,216,163,1)', 'rgba(237,28,36,0.6)',
					'rgba(4,189,254,0.6)', 'rgba(193,196,200, 0.8)' ]
		},
		padding : {
			top : 0,
			right : 0,
			bottom : 20,
			left : 0,
		},
		donut : {
			title : ["Total: "  + taskSum]
		}
	});

	
	
	setInterval(function() {
		
		var request = $.ajax({
			url : "/taskChart",
			method : "GET",
			dataType : "json"
		});

		request.done(function(data) {
			var taskPlanning = $('.taskPlanning');
			var taskAfterDeadline = $('.taskAfterDeadline');
			var taskSuccess = $('.taskSuccess');
			var taskNodeadline = $('.taskNodeadline');
			taskPlanning.text(data.taskPlanning);
			taskAfterDeadline.text(data.taskAfterDeadline);
			taskSuccess.text(data.taskSuccess);
			taskNodeadline.text(data.taskNodeadline);

			c3DonutChart.load({
				columns : [ [ "완료", data.taskSuccess ],
						[ "마감일 지남", data.taskAfterDeadline ],
						[ "계획됨", data.taskPlanning ],
						[ "마감일 없음", data.taskNodeadline ], ],
						
			});

		});

		request.fail(function(jqXHR, textStatus) {
			alert("Request failed: " + textStatus);
		});

	}, 3000);

});
