$(function(){
	$("[id*=editBtn-]").each(function(){
		var tid = this.id.split("-")[1] ;
		var titlePre = $("#title-"+ tid).val();
		$(this).on("click",function(){
			//console.log("***** tid = " + tid) ; 
			var title = $("#title-"+ tid).val();
			if (title != "" && title != titlePre) {	
				$.post("pages/type/edit.action",{tid:tid,title:title},function(data){
				operateAlert(data.trim() == "true" , "办公用品分类信息修改成功！","办公用品分类信息修改失败！") ;
			},"text");
				titlePre = title;
			}else {
				operateAlert(false , "办公用品分类信息修改成功！！","修改办公用品分类信息不能与原来信息一致！") ;
			}
		}) ;
	})
})