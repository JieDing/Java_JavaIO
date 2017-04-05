package com.jieding.fileAndPath;

import java.nio.file.Path;
import java.nio.file.Paths;

public class FileAndPathTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Path basePath = Paths.get(System.getProperty("user.dir"));
		Path workRelative = Paths.get("work");
		/**
		 * path.resolve()���Խ�path·���������еĲ���ƴ���������γ�һ���µ�·��
		 */
		Path workPath = basePath.resolve(workRelative);
		/**
		 * path.resolveSibling()����ָ����·�������ֵ�·��
		 */
		Path tempPath = workPath.resolveSibling("temp");
		
		System.out.println(tempPath.toString());
		
		Path relative = workPath.relativize(tempPath);
		/**
		 * path.relativize()���Ը���pathĿ¼���õ�����Ŀ¼�����·��
		 */
		System.out.println(relative.toString());
		
		System.out.println("parent: "+tempPath.getParent());
		System.out.println("file: "+tempPath.getFileName());
		System.out.println("root: "+tempPath.getRoot());
		
	}

}
