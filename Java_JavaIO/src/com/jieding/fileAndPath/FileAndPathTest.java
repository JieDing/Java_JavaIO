package com.jieding.fileAndPath;

import java.nio.file.Path;
import java.nio.file.Paths;

public class FileAndPathTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Path basePath = Paths.get(System.getProperty("user.dir"));
		Path workRelative = Paths.get("work");
		/**
		 * path.resolve()可以将path路径与括号中的参数拼接起来，形成一个新的路径
		 */
		Path workPath = basePath.resolve(workRelative);
		/**
		 * path.resolveSibling()可以指定父路径产生兄弟路径
		 */
		Path tempPath = workPath.resolveSibling("temp");
		
		System.out.println(tempPath.toString());
		
		Path relative = workPath.relativize(tempPath);
		/**
		 * path.relativize()可以根据path目录，得到参数目录的相对路径
		 */
		System.out.println(relative.toString());
		
		System.out.println("parent: "+tempPath.getParent());
		System.out.println("file: "+tempPath.getFileName());
		System.out.println("root: "+tempPath.getRoot());
		
	}

}
