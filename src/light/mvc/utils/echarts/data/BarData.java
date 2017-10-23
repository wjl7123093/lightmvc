package light.mvc.utils.echarts.data;

public class BarData {

	private String name;
	private String stack;
	
	public BarData(){}
	
	public BarData(String name, String stack) {
		super();
		this.name = name;
		this.stack = stack;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStack() {
		return stack;
	}

	public void setStack(String stack) {
		this.stack = stack;
	}

	
	
}
