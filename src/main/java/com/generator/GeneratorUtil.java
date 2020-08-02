package com.generator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ResourceUtils;

public class GeneratorUtil {

	
	
	/**
	 * maven: mybatis-generator:generate
	 * @throws Exception
	 */
	public void generator() throws Exception{

		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		//指定 逆向工程配置文件
		File configFile = ResourceUtils.getFile("classpath:generatorConfig.xml");
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(configFile);
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,
				callback, warnings);
		myBatisGenerator.generate(null);

		if (warnings.isEmpty()) {
			System.out.println("MyBatis文件生成成功！！");
		} else {
			System.out.println(warnings.toString());
		}

	} 
	
	public static void main(String[] args) throws Exception {
		try {
			GeneratorUtil generatorSqlmap = new GeneratorUtil();
			generatorSqlmap.generator();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}

