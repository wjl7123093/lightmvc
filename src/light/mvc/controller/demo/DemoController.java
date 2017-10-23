package light.mvc.controller.demo;

import javax.servlet.http.HttpServletRequest;

import light.mvc.controller.base.BaseController;
import light.mvc.pageModel.base.Grid;
import light.mvc.pageModel.base.Json;
import light.mvc.pageModel.base.PageFilter;
import light.mvc.pageModel.demo.Demo;
import light.mvc.service.demo.DemoServiceI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/demo")
public class DemoController extends BaseController {

	@Autowired
	private DemoServiceI demoService;

	@RequestMapping("/manager")
	public String manager() {
		return "/demo/demo";
	}

	@RequestMapping("/dataGrid")
	@ResponseBody
	public Grid dataGrid(Demo demo, PageFilter ph) {
		Grid grid = new Grid();
		grid.setRows(demoService.dataGrid(demo, ph));
		grid.setTotal(demoService.count(demo, ph));
		return grid;
	}

	@RequestMapping("/viewPage")
	public String viewPage(HttpServletRequest request, Long id) {
		Demo r = demoService.get(id);
		request.setAttribute("demo", r);
		return "/demo/demoView";
	}

	@RequestMapping("/addPage")
	public String addPage() {
		return "/demo/demoAdd";
	}

	@RequestMapping("/add")
	@ResponseBody
	public Json add(Demo demo) {
		Json j = new Json();
		try {
			demoService.add(demo);
			j.setSuccess(true);
			j.setMsg("添加成功！");
		} catch (Exception e) {
			j.setMsg(e.getMessage());
		}
		return j;
	}

	@RequestMapping("/delete")
	@ResponseBody
	public Json delete(Long id) {
		Json j = new Json();
		try {
			demoService.delete(id);
			j.setMsg("删除成功！");
			j.setSuccess(true);
		} catch (Exception e) {
			j.setMsg(e.getMessage());
		}
		return j;
	}

	@RequestMapping("/get")
	@ResponseBody
	public Demo get(Long id) {
		return demoService.get(id);
	}

	@RequestMapping("/editPage")
	public String editPage(HttpServletRequest request, Long id) {
		Demo r = demoService.get(id);
		request.setAttribute("demo", r);
		return "/demo/demoEdit";
	}

	@RequestMapping("/edit")
	@ResponseBody
	public Json edit(Demo demo) {
		Json j = new Json();
		try {
			demoService.edit(demo);
			j.setSuccess(true);
			j.setMsg("编辑成功！");
		} catch (Exception e) {
			j.setMsg(e.getMessage());
		}
		return j;
	}

}
