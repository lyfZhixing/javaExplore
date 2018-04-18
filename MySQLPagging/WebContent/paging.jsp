<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分页显示</title>
</head>
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">

/**
 * 自定义翻页函数
 * ajax提交需要显示的页面的页码和页面显示的记录数至servlet，成功后返回需要显示页的所有信息，并使用html()方法添加至页面
 */
function paging(pageindex,pagesize){
			
			$.ajax({
				type : "GET",
				url : "PaggingServlet",
				data : {
					"pageindex":pageindex,
					"pagesize":pagesize
				},
				dataType : "json",
				success : function(page) {
					
					var inhtml_1 = " <h3 style='text-align:center;color:black'>查询结果</h3><div><div class='header-info'>共<span id='recordmax'>"+page.recordmax+"</span>条结果，分成<span id='pagemax'>"+page.pagemax+"</span>页显示， 当前第<span id='pageindex'>"+page.pageindex+"</span>页</div><div><input type='button' id='prepage' value='上页'/><input type='button' id='nextpage' value='下页'/></div></div>";
					  $("#searchresult").html(inhtml_1);
					  
					  var inhtml_2 = "<tr><th>订单号</th><th>书名</th><th>单价</th><th>数量</th></tr>";
					  /*遍历Paging中list获取书单信息*/
					  $.each(page.list,function(index,item){
						inhtml_2 += "<tr><td>"+item.oid+"</td><td>"+item.name+"</td><td>"+item.price+"</td><td>"+item.num+"</td><td> </tr>";
						  
					  });
					  $(".listtable").html(inhtml_2);
				},
				error: function(){
					alert("出问题啦");
				}
			}); 
	}
	
	//首次查询，点击检索按钮
	$(function(){
		$("#bt").live("click",function(){
			var pagesize = $("#pagesize").val();
			paging(1,pagesize);
		});
	});
	//下一页
	$(function(){
		$("#nextpage").live("click",function(){
			var pageindex = parseInt($("#pageindex").text())+1;
			var pagesize = $("#pagesize").val();
			var pagemax = parseInt($("#pagemax").text());
			if(pageindex > pagemax){
				alert("已经是最后一页了");
			}else{
				paging(pageindex,pagesize);
			}
			
		});
	});
	//上一页
	$(function(){
		$("#prepage").live("click",function(){
			var pageindex = parseInt($("#pageindex").text())-1;
			var pagesize = $("#pagesize").val();
			if(pageindex <= 0){
				alert("已经是第一页了");
			}else{
				paging(pageindex,pagesize);
			}
			
		});
	});
</script>
<body>
	输入每页显示的记录数：
	<input type="text" id="pagesize" size="17" placeholder="默认为3" />
	<input type="button" id="bt" value="检索"/>
	<span id="searchresult"></span>
	<table class="listtable">
	
	</table>
</body>
</html>