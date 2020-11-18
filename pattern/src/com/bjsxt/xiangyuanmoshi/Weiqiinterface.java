package com.bjsxt.xiangyuanmoshi;
//享元接口
public interface Weiqiinterface {
	void setColor(String color);
	String getColor();
	void disPlay(QiziZuobiao qiziZuobiao);
}
//
class WeiqiShare implements Weiqiinterface{
	private String color;
	public WeiqiShare() {
		// TODO Auto-generated constructor stub
	}
	
	public WeiqiShare(String color) {
		super();
		this.color = color;
	}

	@Override
	public void setColor(String color) {
		this.color=color;
		
	}

	@Override
	public String getColor() {
		// TODO Auto-generated method stub
		return color;
	}

	@Override
	public void disPlay(QiziZuobiao qiziZuobiao) {
		System.out.println("棋子颜色："+color);
		System.out.println("棋子坐标："+qiziZuobiao.getX()+"---"+qiziZuobiao.getY());
	}
	
}
