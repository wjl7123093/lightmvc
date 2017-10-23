package light.mvc.utils.echarts.series.event;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 事件列表，每一个数组项为Object {}，内容如下
 *
 * @author liuzh
 */
public class Event {
    private String name;

    /**
     * 获取name值
     */
    public String name() {
        return this.name;
    }

    /**
     * 设置name值
     *
     * @param name
     */
    public Event name(String name) {
        this.name = name;
        return this;
    }

    private Integer weight;

    /**
     * 获取weight值
     */
    public Integer weight() {
        return this.weight;
    }

    /**
     * 设置weight值
     *
     * @param weight
     */
    public Event weight(Integer weight) {
        this.weight = weight;
        return this;
    }

    private List<Evolution> evolution;

    /**
     * 获取evolution值
     */
    public List<Evolution> evolution() {
        if (this.evolution == null) {
            this.evolution = new ArrayList<Evolution>();
        }
        return this.evolution;
    }

    /**
     * 设置evolution值
     *
     * @param evolution
     */
    public Event evolution(List<Evolution> evolution) {
        this.evolution = evolution;
        return this;
    }

    /**
     * 添加evolution值
     *
     * @param values
     * @return
     */
    public Event evolution(Evolution... values) {
        if (values == null || values.length == 0) {
            return this;
        }
        this.evolution().addAll(Arrays.asList(values));
        return this;
    }

    /**
     * 构造方法
     */
    public Event() {
    }

    /**
     * 构造方法
     *
     * @param name
     */
    public Event(String name) {
        this.name = name;
    }

    /**
     * 构造方法
     *
     * @param name
     * @param weight
     */
    public Event(String name, Integer weight) {
        this.name = name;
        this.weight = weight;
    }

    /**
     * 获取name值
     */
    public String getName() {
        return name;
    }

    /**
     * 设置name值
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取weight值
     */
    public Integer getWeight() {
        return weight;
    }

    /**
     * 设置weight值
     *
     * @param weight
     */
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    /**
     * 获取evolution值
     */
    public List<Evolution> getEvolution() {
        return evolution;
    }

    /**
     * 设置evolution值
     *
     * @param evolution
     */
    public void setEvolution(List<Evolution> evolution) {
        this.evolution = evolution;
    }
}
