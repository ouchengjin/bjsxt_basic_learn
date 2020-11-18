package com.bjsxt.xml;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
/**
 * 存储对象
 * @ClassName: PersonHandler
 * @Description: TODO(描述)
 * @author author
 * @date 2020-05-08 22:41:33
 */

public class PersonHandler extends DefaultHandler {
	private List<Person> persons;
	private Person person;
	private String tag;//记录标签名，避免空的问题

	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
//		System.out.println("处理文档开始");
		persons= new ArrayList<Person>();
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.println("处理元素开始"+qName);
		if(null!= qName) {
			tag=qName;
		}
		if(null!= qName&&"person".equals(qName)) {
			person= new Person();
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String str=new String(ch,start,length);
		if(null!=tag&&"name".equals(tag)) {
//			System.out.println(new String(ch,start,length));
			person.setName(str);
		}else if(null!=tag&&"age".equals(tag)) {
			Integer age=Integer.valueOf(str);
			person.setAge(age);
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
//		System.out.println("处理元素结束"+qName);
		if("person".equals(qName)) {
			persons.add(person);
		}
		tag=null;
	}

	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("处理文档结束");
	}

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	
}
