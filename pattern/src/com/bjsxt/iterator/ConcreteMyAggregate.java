package com.bjsxt.iterator;

import java.util.ArrayList;
import java.util.List;

public class ConcreteMyAggregate {
	private List<Object> list = new ArrayList<Object>();
	public ConcreteMyAggregate() {
		// TODO Auto-generated constructor stub
	}
	
	public void addObject(Object obj) {
		list.add(obj);
	}
	public void removeObject(Object obj) {
		list.remove(obj);
	}
	public List<Object> getList() {
		return list;
	}
	public void setList(List<Object> list) {
		this.list = list;
	}
	
	public MyIterator creatIterator() {
		return new ConcreteIterator();
	}
	
	//使用内部类定义迭代器，可以直接使用外部类的属性
	private class ConcreteIterator implements MyIterator{
		private int cursor=0;//定义游标用于记录遍历时的位置
		@Override
		public void first() {
			cursor=0;
		}

		@Override
		public void next() {
//			if(cursor<list.size()) {
				cursor++;
//			}
		}

		@Override
		public boolean hasNext() {
			boolean ret=false;
			if(cursor<list.size()) {
				ret=true;
			}
			return ret;
		}

		@Override
		public boolean isFirst() {
			return cursor==0?true:false;
		}

		@Override
		public boolean isLast() {
			return cursor==(list.size()-1)?true:false;
		}

		@Override
		public Object getCurrentObj() {
			return list.get(cursor);
		}
		
	}
}
