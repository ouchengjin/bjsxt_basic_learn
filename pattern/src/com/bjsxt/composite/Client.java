package com.bjsxt.composite;

public class Client {

	public static void main(String[] args) {
		ImageFile imageFile= new ImageFile("欧成金的帅气照片");
		TextFile textFile = new TextFile("即位诏书");
		VideoFile videoFile = new VideoFile("视频录像");
		Folder FolderFile= new Folder("我的收藏");
		FolderFile.add(imageFile);
		FolderFile.add(textFile);
		FolderFile.add(videoFile);
		FolderFile.killVirus();
	}

}
