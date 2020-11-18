package com.bjsxt.iterator;
/**
 * 自定义的迭代器接口
 * @ClassName: MyIterator
 * @Description: TODO(描述)
 * @author Alan Ouyang
 * @date 2020-06-06 21:31:24
 */
public interface MyIterator {
	void first();//将游标指向第一个元素
	void next();//将游标指向下一个元素
	boolean hasNext();//判断是否存在一个元素
	
	boolean isFirst();
	boolean isLast();
	
	Object getCurrentObj();//获取当前游标指向的对象
}
