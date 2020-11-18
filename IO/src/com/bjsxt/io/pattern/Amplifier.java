package com.bjsxt.io.pattern;
/**
 * 扩音器
 * 类与类之间的关系
 * 1.依赖：形参|局部变量
 * 2.关联：属性
 * 依据强度
 * 		聚合：整体与部分不一致的声明周期，如人与手
 *		 组合：整体与部分一致的生命周期，如人与大脑
 * 3.继承：父子类关系
 * 4.实现：接口与实现类的关系
 * 
 * @ClassName: Amplifier
 * @Description: TODO(描述)
 * @author author
 * @date 2020-04-04 21:43:07
 */
public class Amplifier {
	private Voice voice;//属性---关联
	public Amplifier() {
		// TODO Auto-generated constructor stub
	}
	public Amplifier(Voice voice) {
		super();
		this.voice = voice;
	}
	public void say() {
		System.out.println(voice.getVoice()*1000);
	}

}
