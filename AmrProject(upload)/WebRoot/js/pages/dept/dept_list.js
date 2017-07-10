$(function(){
	$("[id*=editBtn-]").each(function(){
		var did = this.id.split("-")[1] ;
		var titlePre = $("#title-" + did).val() ;
		$(this).on("click",function(){
			//console.log("***** did = " + did) ;
			var title = $("#title-" + did).val() ;
			if (title != "" && title != titlePre) {	// 表示有数据可以修改
				$.post("pages/dept/edit.action",{did:did,title:title},function(data){
					operateAlert(data.trim() == "true" , "部门名称修改成功！","部门名称修改失败！") ;
				},"text") ;
				titlePre = title;
			} else {
				operateAlert(false , "部门名称修改成功！","修改部门名称不能与原来名称一致！") ;
			}
		}) ;
	})
})
























