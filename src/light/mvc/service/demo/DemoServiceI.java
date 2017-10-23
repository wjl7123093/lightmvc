package light.mvc.service.demo;

import java.util.List;

import light.mvc.pageModel.base.PageFilter;
import light.mvc.pageModel.demo.Demo;

public interface DemoServiceI {

	public List<Demo> dataGrid(Demo demo, PageFilter ph);

	public Long count(Demo demo, PageFilter ph);

	public void add(Demo demo);

	public void delete(Long id);

	public void edit(Demo demo);

	public Demo get(Long id);

}
