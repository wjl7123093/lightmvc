package light.mvc.framework.interceptors;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import light.mvc.framework.constant.GlobalConstant;
import light.mvc.pageModel.base.SessionInfo;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 权限拦截器
 * 
 */
public class SecurityInterceptor implements HandlerInterceptor {

	private List<String> excludeUrls;// 不需要拦截的资源

	public List<String> getExcludeUrls() {
		return excludeUrls;
	}

	public void setExcludeUrls(List<String> excludeUrls) {
		this.excludeUrls = excludeUrls;
	}

	/**
	 * 完成页面的render后调用
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object,
			Exception exception) throws Exception {

	}

	/**
	 * 在调用controller具体方法后拦截
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object,
			ModelAndView modelAndView) throws Exception {

	}

	/**
	 * 在调用controller具体方法前拦截
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
		String requestUri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String url = requestUri.substring(contextPath.length());
		SessionInfo sessionInfo = (SessionInfo) request.getSession().getAttribute(GlobalConstant.SESSION_INFO);
		//判断是否包含在菜单权限里

		if ((url.indexOf("/admin/") > -1) ||url.indexOf("/mobile/") > -1 || excludeUrls.contains(url)) {// 如果要访问的资源是不需要验证的
			return true;
		}
		
		if ((sessionInfo == null) || (sessionInfo.getId() == null)) {// 如果没有登录或登录超时
			if(url.indexOf("/mobile/") > -1){
				request.setAttribute("msg", "您还没有登录或登录已超时，请重新登录，然后再刷新本功能！");
				request.getRequestDispatcher("/error/mobileNoSession.jsp").forward(request, response);
				return false;
			}
			request.setAttribute("msg", "您还没有登录或登录已超时，请重新登录，然后再刷新本功能！");
			request.getRequestDispatcher("/error/noSession.jsp").forward(request, response);
			return false;
		}
		
		if(!sessionInfo.getResourceAllList().contains(url)){
			return true;
		}

		if (!sessionInfo.getResourceList().contains(url)) {// 如果当前用户没有访问此资源的权限
			request.setAttribute("msg", "您没有访问此资源的权限！<br/>请联系超管赋予您<br/>[" + url + "]<br/>的资源访问权限！");
			request.getRequestDispatcher("/error/noSecurity.jsp").forward(request, response);
			return false;
		}

		return true;
	}
}
