package cn.xzj.amr.dao.impl;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import cn.xzj.amr.dao.ITypeDAO;
import cn.xzj.amr.dao.abs.AbstractDAO;
import cn.xzj.amr.vo.Type;

@Component
public class TypeDAOImpl extends AbstractDAO implements ITypeDAO {

	@Override
	public boolean doCreate(Type vo) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doUpdate(Type vo) throws Exception {
		return super.getSession().update("cn.xzj.amr.mapping.TypeNS.doUpdate",
				vo) > 0;
	}

	@Override
	public boolean doRemoveBatch(Set<Integer> ids) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Type findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Type> findAll() throws Exception {
		return super.getSession().selectList(
				"cn.xzj.amr.mapping.TypeNS.findAll");
	}

	@Override
	public List<Type> findAllSplit(String column, String keyWord,
			Integer currentPage, Integer lineSize) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getAllCount(String column, String keyWord) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
