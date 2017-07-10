package cn.xzj.amr.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;

import cn.xzj.amr.dao.IResDAO;
import cn.xzj.amr.dao.abs.AbstractDAO;
import cn.xzj.amr.vo.Res;

@Component
public class ResDAOImpl extends AbstractDAO implements IResDAO {

	@Override
	public boolean doCreate(Res vo) throws Exception {
		return super.getSession().insert("cn.xzj.amr.mapping.ResNS.doCreate",
				vo) > 0;
	}

	@Override
	public boolean doUpdate(Res vo) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doRemoveBatch(Set<Integer> ids) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Res findById(Integer id) throws Exception {
		return super.getSession().selectOne(
				"cn.xzj.amr.mapping.ResNS.findById", id);
	}

	@Override
	public List<Res> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Res> findAllSplit(String column, String keyWord,
			Integer currentPage, Integer lineSize) throws Exception {
		return super.listHandle(column, keyWord, currentPage, lineSize,
				"cn.xzj.amr.mapping.ResNS.findAllSplit");
	}

	@Override
	public Integer getAllCount(String column, String keyWord) throws Exception {
		return super.countHandle(column, keyWord,
				"cn.xzj.amr.mapping.ResNS.getAllCount");
	}
	@Override
	public boolean doUpdateAmount(Integer rid, Integer amount) throws Exception {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("rid", rid);
		map.put("amount", amount);
		return super.getSession().update(
				"cn.xzj.amr.mapping.ResNS.doUpdateAmount", map) > 0;
	}
	@Override
	public List<Res> findAllByRids(Set<Integer> ids) throws Exception {
		return super.getSession().selectList(
				"cn.xzj.amr.mapping.ResNS.findAllByRids", ids.toArray());
	} 
}
