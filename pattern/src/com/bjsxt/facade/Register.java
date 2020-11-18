package com.bjsxt.facade;

public class Register {

	public static void register() {
		HandianquGongShangJu gongShangJu = new HandianquGongShangJu();
		ZhaoShangBank zhaoShangBank = new ZhaoShangBank();
		HaidianquZhiJianJu zhiJianJu = new HaidianquZhiJianJu();
		ShuiWuJu shuiWuJu = new ShuiWuJu();
		gongShangJu.checkName();
		zhaoShangBank.openAccount();
		zhiJianJu.zhiJian();
		shuiWuJu.banShui();
	}
}
