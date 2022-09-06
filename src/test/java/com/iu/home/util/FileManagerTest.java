package com.iu.home.util;

import org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.home.MyAbstractTest;

public class FileManagerTest extends MyAbstractTest{

//	@Autowired
	private FileManager fileManager;
	
	//@Test
	public void saveFileTest() throws Exception{
		fileManager.saveFile("resources/upload/test");
		System.out.println("Finish--------");
	}
}
