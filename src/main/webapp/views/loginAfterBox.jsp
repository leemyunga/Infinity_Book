<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<style>
	#alarmlist{
		position: fixed;
		z-index: 9999;	 
		right: 5px;
		top: 45px;
		width: 300px;
        background-color: white;
        border: 1px solid #f7f7f7;
  		border-radius: 15px;     
	}
</style>
<div id="login"></div>
<div id="alarmlist" style="height: 400px; overflow: auto; display:none;"></div>
<script>
    var content = "<div class='top-content'>";
    content += "<div class='container'>";
    content += "<div class='row'>";
    content += "<div class='col-md-12'>";
    content += "<div class='right-element'>";
    content += "<a href='/admin/adminMain' style='color: red;'>[관리자 페이지]&nbsp;&nbsp;</a>" + "반가워요 <b>${sessionScope.loginNickname}</b>님! <a href='logout.do' style='color: blue;'>[로그아웃]</a>&nbsp;&nbsp;&nbsp;&nbsp;";
    content += "<a href='message_list.go'>💬 채팅</a>&nbsp;&nbsp;&nbsp;&nbsp;";
    content += "<a onclick='alarm()' style='cursor: pointer;' >🔔알림</a>";
    content += "</div><!--top-right-->";
    content += "</div>";
    content += "</div>";
    content += "</div>";
    content += "</div>";
    $("#login").html(content);
    
    function alarm(){    	
	var alarmlist = document.getElementById("alarmlist");    	    	
    	$.ajax({
    		url:"alarm.ajax",
    		method:"get",
    		data:{
    		},
    		success:function(data){
    			console.log("알림가져오기 성공");    		
    			$('#alarmlist').html(data);

	    		    if (alarmlist.style.display === "none") {
	    		        alarmlist.style.display = "block";
	    		        
	    		    } else {
	    		        alarmlist.style.display = "none";
	    		    }
	    		    /*
	    		    $('.alaram_list').on('click', function(){
	    		    	var code_idx = $(this).attr('code');
	    		    	var idx = $(this).attr('idx');
	    		    	console.log(code_idx, idx);
	    		    });
	    		    */    			
    			}
    	});
    }
    
</script>
