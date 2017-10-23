package light.mvc.service.demo.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import light.mvc.dao.BaseDaoI;
import light.mvc.model.demo.Tdemo;
import light.mvc.pageModel.base.PageFilter;
import light.mvc.pageModel.demo.Demo;
import light.mvc.service.demo.DemoServiceI;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoServiceI {

	@Autowired
	private BaseDaoI<Tdemo> demoDao;

	@Override
	public void add(Demo r) {
		Tdemo t = new Tdemo();
		t.setName(r.getName());
		t.setDescription(r.getDescription());
		demoDao.save(t);
	}

	@Override
	public void delete(Long id) {
		Tdemo t = demoDao.get(Tdemo.class, id);
		demoDao.delete(t);
	}

	@Override
	public void edit(Demo r) {
		Tdemo t = demoDao.get(Tdemo.class, r.getId());
		t.setDescription(r.getDescription());
		t.setName(r.getName());
		demoDao.update(t);
	}

	@Override
	public Demo get(Long id) {
		Tdemo t = demoDao.get(Tdemo.class, id);
		Demo r = new Demo();
		r.setDescription(t.getDescription());
		r.setId(t.getId());
		r.setName(t.getName());
		return r;
	}

	@Override
	public List<Demo> dataGrid(Demo demo, PageFilter ph) {
		List<Demo> ul = new ArrayList<Demo>();
		Map<String, Object> params = new HashMap<String, Object>();
		String hql = " from Tdemo t ";
		List<Tdemo> l = demoDao.find(hql + whereHql(demo, params) + orderHql(ph), params, ph.getPage(), ph.getRows());
		for (Tdemo t : l) {
			Demo u = new Demo();
			BeanUtils.copyProperties(t, u);
			ul.add(u);
		}
		return ul;
	}

	@Override
	public Long count(Demo demo, PageFilter ph) {
		Map<String, Object> params = new HashMap<String, Object>();
		String hql = " from Tdemo t ";
		return demoDao.count("select count(*) " + hql + whereHql(demo, params), params);
	}

	private String whereHql(Demo demo, Map<String, Object> params) {
		String hql = "";
		if (demo != null) {
			hql += " where 1=1 ";
			if (demo.getName() != null) {
				hql += " and t.name like :name";
				params.put("name", "%%" + demo.getName() + "%%");
			}
		}
		return hql;
	}

	private String orderHql(PageFilter ph) {
		String orderString = "";
		if ((ph.getSort() != null) && (ph.getOrder() != null)) {
			orderString = " order by t." + ph.getSort() + " " + ph.getOrder();
		}
		return orderString;
	}

}
