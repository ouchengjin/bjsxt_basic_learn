package com.bjsxt.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合模式
 * @ClassName: AbstractFileOrFolder
 * @Description: TODO(描述)
 * @author Alan Ouyang
 * @date 2020-06-04 21:35:19
 */
//抽象组件
public interface AbstractFileOrFolder {
	void killVirus();
}

class ImageFile implements AbstractFileOrFolder{
	private String name;
	
	public ImageFile(String name) {
		super();
		this.name = name;
	}

	@Override
	public void killVirus() {
		System.out.println(name+"图片文件杀毒");
	}
}
class TextFile implements AbstractFileOrFolder{
	private String name;
	public TextFile(String name) {
		super();
		this.name = name;
	}
	@Override
	public void killVirus() {
		System.out.println(name+"文本文件杀毒");
	}
}

class VideoFile implements AbstractFileOrFolder{
	private String name;
	public VideoFile(String name) {
		super();
		this.name = name;
	}
	@Override
	public void killVirus() {
		System.out.println(name+"视频文件杀毒");
	}
}

class Folder implements AbstractFileOrFolder{
	private String name;
	//定义容器，用于存放本容器下的子节点
	List<AbstractFileOrFolder> abstractFileOrFolderlist= new ArrayList<AbstractFileOrFolder>();
	public Folder(String name) {
		super();
		this.name = name;
	}
	
	public void add(AbstractFileOrFolder abstractFileOrFolder) {
		abstractFileOrFolderlist.add(abstractFileOrFolder);
	}
	
	public void remove(AbstractFileOrFolder abstractFileOrFolder) {
		abstractFileOrFolderlist.remove(abstractFileOrFolder);
	}
	
	public AbstractFileOrFolder getChild(int index) {
		return abstractFileOrFolderlist.get(index);
	}
	@Override
	public void killVirus() {
		for(AbstractFileOrFolder abstractFileOrFolder:abstractFileOrFolderlist) {
			abstractFileOrFolder.killVirus();
		}
		System.out.println(name+"文件夹杀毒");
	}
}