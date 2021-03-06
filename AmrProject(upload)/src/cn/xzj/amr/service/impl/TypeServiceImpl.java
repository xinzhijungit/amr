package cn.xzj.amr.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.xzj.amr.dao.ITypeDAO;
import cn.xzj.amr.service.ITypeService;
import cn.xzj.amr.service.abs.AbstractService;
import cn.xzj.amr.vo.Type;

@Service
public class TypeServiceImpl extends AbstractService implements ITypeService {
	@Resource
	private ITypeDAO typeDAO;

	@Override
	public List<Type> list() throws Exception {
		return this.typeDAO.findAll();
	}
	@Override
	public boolean edit(Type vo,int eid) throws Exception {
		if (!super.checkAuth(eid, 9)) {
			return false ;
		} 
		return this.typeDAO.doUpdate(vo);
	}

}
