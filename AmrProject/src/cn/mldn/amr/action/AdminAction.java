package cn.mldn.amr.action;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.mldn.amr.adapter.AbstractActionAdapter;
import cn.mldn.amr.service.IAdminService;
import cn.mldn.amr.vo.Emp;
import cn.mldn.util.MD5Code;
import cn.mldn.util.SplitUtil;

@Controller
@RequestMapping("/pages/admin/*")
public class AdminAction extends AbstractActionAdapter {
	@Resource
	private IAdminService adminService;

	@RequestMapping("checkEid")
	public ModelAndView checkEid(Integer eid, HttpServletResponse response) {
		try {
			super.print(response, !this.adminService.checkEid(eid));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping("addPre")
	public ModelAndView addPre(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		if (super.isAuth(1, request)) {

			try {
				Map<String, Object> map = this.adminService.addPre();
				mav.addObject("allLevels", map.get("allLevels"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			mav.setViewName(super.getMsg("admin.add.page"));
		} else {
			mav.setViewName(super.getMsg("error.page"));
		}
		return mav;
	}

	@RequestMapping("add")
	public ModelAndView add(Emp vo, MultipartFile pic,
			HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		if (super.isAuth(2, request)) {
			vo.setPhoto(super.createSingleFileName(pic)); // 创建文件名称
			vo.setHeid(super.getEid(request)); // 取得创建者雇员编号
			vo.setPassword(new MD5Code().getMD5ofStr(vo.getPassword())); // 密码加密
			mav.setViewName(super.getMsg("forward.page"));
			try {
				if (this.adminService.add(vo, super.getEid(request))) {
					super.saveUploadFile(pic, request, vo.getPhoto());// 保存文件
					super.setMsgAndUrl("vo.add.success", "admin.add.action",
							mav);
				} else {
					super.setMsgAndUrl("vo.add.failure", "admin.add.action",
							mav);
				}
			} catch (Exception e) {
				super.setMsgAndUrl("vo.add.failure", "admin.add.action", mav);
				e.printStackTrace();
			}
		} else {
			mav.setViewName(super.getMsg("error.page"));
		}
		return mav;
	}

	@RequestMapping("list")
	public ModelAndView list(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		if (super.isAuth(3, request)) {
			SplitUtil split = new SplitUtil(this);
			super.handleSplit(request, split); // 处理分页的参数数据
			try {
				Map<String, Object> map = this.adminService.list(super.getEid(request),
						split.getColumn(), split.getKeyword(),
						split.getCurrentPage(), split.getLineSize());
				mav.addObject("allEmps", map.get("allEmps"));
				split.setAttribute(request, map.get("empCount"),
						"admin.list.action", null, null, null, null);
			} catch (Exception e) {
				e.printStackTrace();
			}
			mav.setViewName(super.getMsg("admin.list.page"));
		} else {
			mav.setViewName(super.getMsg("error.page"));
		}
		return mav;
	}

	@Override
	public String getFlag() {
		return "管理员";
	}

	@Override
	public String getSaveFileDiv() {
		return "/upload/emp/";
	}

	@Override
	public String getDefaultColumn() {
		return "name";
	}

	@Override
	public String getColumnData() {
		return "雇员姓名:name|雇员编号:eid|雇员电话:phone";
	}

}
