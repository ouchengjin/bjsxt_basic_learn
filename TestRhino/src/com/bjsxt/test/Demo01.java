package com.bjsxt.test;



import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.URL;
import java.util.List;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * 测试脚本引擎执行JavaScript代码
 * @ClassName: Demo01
 * @Description: TODO(描述)
 * @author author
 * @date 2020-05-21 22:42:38
 */
public class Demo01 {

	public static void main(String[] args) throws ScriptException, NoSuchMethodException, IOException {
		//获得脚本引擎对象
		ScriptEngineManager sem= new ScriptEngineManager();
		ScriptEngine engine=sem.getEngineByName("javascript");//或者写js
		//定义变量,存储到引擎上下文中
		engine.put("msg", " Alan is a good man");
		String str = "var user= {name:'Alan',age:18,schools:['北京大学','清华大学']};";
		str += "print(user.name)";
		//执行脚本
		engine.eval(str);
		engine.eval("msg='sxt is a good school';");
		Object str2= engine.get("msg");
		System.out.println(str2);
		
		//定义函数
		engine.eval("function add(a,b){var sum=a+b;return sum;}");
		//取得调用接口
		Invocable jsInvoke=(Invocable)engine;
		//执行脚本中定义的方法
		Object result1=jsInvoke.invokeFunction("add", new Object[] {10,300});
		System.out.println(result1);
		
		//js导入其他java包，调用java包方法，若需要详细了解细节，可以学习Rhino的语法
		String jsCode="var list = java.util.Arrays.asList(\"北京大学\",\"清华大学\");";
		engine.eval(jsCode);
		List<String> list =(List<String>) engine.get("list");
		for(String temp :list) {
			System.out.println(temp);
		}
		
		//执行一个js文件（我们将a.js放到src下即可）
		URL url=Demo01.class.getClassLoader().getResource("a.js");
		Reader rd = new FileReader(url.getPath());
		engine.eval(rd);
		rd.close();//由于只是测试就不那么规范了，实际使用时，要使用try catch finally
		
		
		
	}

}
