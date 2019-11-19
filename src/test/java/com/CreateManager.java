package com;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.xuancg.generator.StartWebApp;
import com.xuancg.generator.domain.TableInfo;
import com.xuancg.generator.service.IGenService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= {StartWebApp.class})
public class CreateManager {

	@Autowired
	private IGenService genService;
	
	@Test
	public void test() {
		 try {
			 List<TableInfo> list = genService.selectTableList(new TableInfo());
			 System.out.println("-------"+list.size());
			 List<String> tableNames = new ArrayList<>(list.size());
			 list.forEach(node -> tableNames.add(node.getTableName())); 
			 
			 byte[] context = genService.generatorCode(tableNames.toArray(new String[list.size()]));
			 File file = new File("C:\\Users\\宣晨光\\Desktop\\codec.zip");
			 FileOutputStream fos = new FileOutputStream(file);
			 fos.write(context);
			 fos.close();
			 
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		
	}
}
