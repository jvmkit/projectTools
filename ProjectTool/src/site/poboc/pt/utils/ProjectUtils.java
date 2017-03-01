package site.poboc.pt.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;

public enum ProjectUtils {
	su;
	public boolean isNotBlank(String str){
		return null != str && !"".equals(str);
	}
	
	public String toHeaderLowerCase(String str){
		if(this.isNotBlank(str)){
			if(1 == str.length()){
				return str.toLowerCase();
			} else {
				String lowerCase = str.substring
						(0, 1).toLowerCase();
				return lowerCase + str.substring(1, str.length());
			}
		} else {
			return str;
		}
	}
	
	public String getBasePath() throws URISyntaxException{
		return this.getClass().getClassLoader().getResource(".").toURI().getPath();
	}
	
	public StringBuilder readFileToSB(String filePath){
		StringBuilder sb = new StringBuilder();
		InputStream is = this.getClass().getResourceAsStream(filePath);
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			if(null == is){
				is = new FileInputStream(new File(filePath));
			}
			isr = new InputStreamReader(is,"UTF-8");
			br = new BufferedReader(isr);
			
			String temp = null;
			while(null != (temp= br.readLine())){
				sb.append(temp).append("\n");
			}
//			System.out.println(file.getName()+" content:"+"\n"+sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				isr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sb;
	}
	
	public String join(String[] strArr, String seperater){
		if(null != strArr && strArr.length > 0
				&& null != seperater){
			if(1 == strArr.length){
				return strArr[0];
			}
			StringBuilder sb = new StringBuilder();
			for(String str : strArr){
				sb.append(str).append(seperater);
			}
			return sb.substring(0, sb.length() - seperater.length());
		}
		return "";
	}
	
	public void writeString2File(ReplaceBean rb, String srcPath, String tailFileName, String cascade, boolean isInterface){
		String pkgPath = ProjectUtils.su
				.join(rb.getBasePkg().split("\\."), File.separator);
		String domainClass = rb.getDomainClass();
		if(isInterface){
			domainClass = "I"+domainClass;
		}
		String classFile;
		if(srcPath.endsWith(File.separator)
				|| srcPath.endsWith("/")){
			classFile = srcPath+pkgPath+File.separator+cascade+File.separator+domainClass+tailFileName;
		} else {
			classFile = srcPath+File.separator+pkgPath+File.separator+cascade+File.separator+domainClass+tailFileName;
		}
		
		File file = new File(classFile);
		if(!file.exists()){
			try {
				file.getParentFile().mkdirs();
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(file.exists()){
			FileOutputStream fos = null;
			try {
				fos = new FileOutputStream(file);
				fos.write(rb.getContent().toString().getBytes());
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void writeAction2Struts(){
		
	}
	
	public static void main(String[] args) {
//		String[] str = {"cn","itcast"};
//		System.out.println(ProjectUtils.su.join(str, File.separator));
		StringBuilder sb = ProjectUtils.su.readFileToSB(
				"E:\\workspace_private\\bos_collection\\bos_collection_web\\src\\main\\resources\\struts.xml");
		System.out.println(sb.toString());
	}
	
}
