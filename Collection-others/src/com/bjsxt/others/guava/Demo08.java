package com.bjsxt.others.guava;

import java.util.Map;
import java.util.Set;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.google.common.collect.Table.Cell;
import com.google.common.collect.Tables;

public class Demo08 {

	public static void main(String[] args) {

		Table<String, String, Integer> tables= HashBasedTable.create();
		tables.put("a", "javase", 80);
		tables.put("b", "javase", 90);
		
		tables.put("a", "oracle", 100);
		tables.put("c", "oracle", 95);
		Set<Cell<String, String, Integer>> cells= tables.cellSet();
		for(Cell<String, String, Integer> temp:cells) {
			System.out.println(temp.getRowKey()+"-->"+temp.getColumnKey()+"-->"+temp.getValue());
		}
		
		System.out.println("=====================学生查看成绩=======================");
		System.out.print("学生\t");
		Set<String> cours= tables.columnKeySet();
		for(String temp:cours) {
			System.out.print(temp+"\t");
		}
		
		System.out.println();
		Set<String> stus= tables.rowKeySet();
		for (String temp : stus) {
			System.out.print(temp+"\t");
			Map<String, Integer> scores=tables.row(temp);
			for(String c:cours) {
				System.out.print(scores.get(c)+"\t");
			}
	
			System.out.println();
		}
		
		System.out.println("=====================课程查看成绩=======================");
		System.out.print("课程\t");
		Set<String> students= tables.rowKeySet();
		for(String temp:students) {
			System.out.print(temp+"\t");
		}
		
		System.out.println();
		Set<String> cours2= tables.columnKeySet();
		for (String temp : cours2) {
			System.out.print(temp+"\t");
			Map<String, Integer> scoresandstu=tables.column(temp);
			for(String c:students) {
				System.out.print(scoresandstu.get(c)+"\t");
			}
	
			System.out.println();
		}
		
		System.out.println("=====================转换=======================");
		Table<String, String, Integer> tables2=Tables.transpose(tables);
		Set<Cell<String, String, Integer>> cells2= tables2.cellSet();
		for(Cell<String, String, Integer> temp:cells2) {
			System.out.println(temp.getRowKey()+"-->"+temp.getColumnKey()+"-->"+temp.getValue());
		}
	}

}
