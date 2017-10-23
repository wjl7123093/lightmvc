package light.mvc.service.task.impl;

import light.mvc.dao.BaseDaoI;
import light.mvc.model.sys.Tuser;
import light.mvc.service.task.TaskDemoServiceI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskDemoServiceImpl implements TaskDemoServiceI {

	@Autowired
	private BaseDaoI<Tuser> userDao;

	@Override
	public void test() {
		System.out.println("定时任务执行...");
	}

}
