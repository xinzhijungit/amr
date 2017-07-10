package cn.xzj.amr.dao.impl;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import cn.xzj.amr.dao.IDeptDAO;
import cn.xzj.amr.dao.abs.AbstractDAO;
import cn.xzj.amr.vo.Dept;
@Component
public class DeptDAOImpl extends AbstractDAO implements IDeptDAO {

	@Override
	public boolean doCreate(Dept vo) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doUpdate(Dept vo) throws Exception {
		return super.getSession().update(
				"cn.xzj.amr.mapping.DeptNS.doUpdate",vo)>0;
	}

	@Override
	public boolean doRemoveBatch(Set<Integer> ids) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Dept findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Dept> findAll() throws Exception {
		return super.getSession().selectList(
				"cn.xzj.amr.mapping.DeptNS.findAll");
	}

	@Override
	public List<Dept> findAllSplit(String column, String keyWord,
			Integer currentPage, Integer lineSize) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getAllCount(String column, String keyWord) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Dept> findAllBySflag(Integer sflag) throws Exception {
		return super.getSession().selectList("cn.xzj.amr.mapping.DeptNS.findAllBySflag", sflag);
	}

}
