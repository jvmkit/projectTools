package cn.itcast.pt.test;

import java.io.File;
import java.net.URISyntaxException;

import site.poboc.pt.utils.ProjectUtils;

public class TestResource {
	
	public String getBasePath() throws URISyntaxException{
		return this.getClass().getClassLoader().getResource(".").toURI().getPath();
	}
	
	public static void main(String[] args) throws URISyntaxException {
		String basePath = ProjectUtils.su.getBasePath();
		File file = new File(basePath+"/cn/itcast/pt/template/action/action.tpl");
		System.out.println(file);
	}
}
