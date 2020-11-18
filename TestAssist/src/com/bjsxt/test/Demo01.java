package com.bjsxt.test;

import java.io.IOException;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtField;
import javassist.CtMethod;
import javassist.NotFoundException;

/**
 * 测试javaassist生成一个新的类
 * @ClassName: Demo01
 * @Description: TODO(描述)
 * @author author
 * @date 2020-05-23 16:52:37
 */
public class Demo01 {
	public static void main(String[] args) throws CannotCompileException, NotFoundException, IOException {
		ClassPool pool= ClassPool.getDefault();
		CtClass cc=pool.makeClass("com.bjsxt.bean.Emp");
		//创建属性
		CtField f1=CtField.make("private int empNo;", cc);
		CtField f2=CtField.make("private String empName;", cc);
		cc.addField(f1);
		cc.addField(f2);
		//创建方法
		CtMethod m1= CtMethod.make("public int  getEmpNo(){return empNo;} ", cc);
		CtMethod m2= CtMethod.make("public void setEmpNo(int empNo){this.empNo=empNo;} ", cc);
		cc.addMethod(m1);
		cc.addMethod(m2);
		//添加构造器
		CtConstructor c1=new CtConstructor(new CtClass[] {CtClass.intType,pool.get("java.lang.String")}, cc);
		c1.setBody("{this.empNo=empNo;this.empName=empName;}");//上面的方法中也有修改body体的方法
		cc.addConstructor(c1);
		
		cc.writeFile("D:\\mycode\\myjava");
		
		System.out.println("生成类，成功");
		
	}

}
