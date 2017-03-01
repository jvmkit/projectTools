package site.poboc.pt.utils;

import org.dom4j.Document;

public class ReplaceBean {

	private String basePkg;// 基础包路径

	private String domainClass;// 实体类名

	private String domainVer;// 实体类首字母小写

	private String srcPath;// src目录路径

	private String actionTplPath;// action模版路径

	private String serTplPath;// service接口模版路径

	private String serImplTplPath;// service实现类模版路径

	private String daoTplPath;// dao模版路径

	private String daoImplTplPath;// dao实现类路径

	private StringBuilder content;// 模版内容（替换前后）

	private String[] strutsPath;

	private Document strutsDoc;

	private String daoInterfacePath;
	private String daoImplPath;
	private String serviceInterfacePath;
	private String serviceImplPath;
	private String actionPath;

	public String getDaoInterfacePath() {
		return daoInterfacePath;
	}

	public void setDaoInterfacePath(String daoInterfacePath) {
		this.daoInterfacePath = daoInterfacePath;
	}

	public String getDaoImplPath() {
		return daoImplPath;
	}

	public void setDaoImplPath(String daoImplPath) {
		this.daoImplPath = daoImplPath;
	}

	public String getServiceInterfacePath() {
		return serviceInterfacePath;
	}

	public void setServiceInterfacePath(String serviceInterfacePath) {
		this.serviceInterfacePath = serviceInterfacePath;
	}

	public String getServiceImplPath() {
		return serviceImplPath;
	}

	public void setServiceImplPath(String serviceImplPath) {
		this.serviceImplPath = serviceImplPath;
	}

	public String getActionPath() {
		return actionPath;
	}

	public void setActionPath(String actionPath) {
		this.actionPath = actionPath;
	}

	public String getBasePkg() {
		return basePkg;
	}

	public void setBasePkg(String basePkg) {
		this.basePkg = basePkg;
	}

	public String getDomainClass() {
		return domainClass;
	}

	public void setDomainClass(String domainClass) {
		this.domainClass = domainClass;
	}

	public String getDomainVer() {
		return domainVer;
	}

	public void setDomainVer(String domainVer) {
		this.domainVer = domainVer;
	}

	public String getSrcPath() {
		return srcPath;
	}

	public void setSrcPath(String srcPath) {
		this.srcPath = srcPath;
	}

	public String getActionTplPath() {
		return actionTplPath;
	}

	public void setActionTplPath(String actionTplPath) {
		this.actionTplPath = actionTplPath;
	}

	public String getSerTplPath() {
		return serTplPath;
	}

	public void setSerTplPath(String serTplPath) {
		this.serTplPath = serTplPath;
	}

	public String getSerImplTplPath() {
		return serImplTplPath;
	}

	public void setSerImplTplPath(String serImplTplPath) {
		this.serImplTplPath = serImplTplPath;
	}

	public String getDaoTplPath() {
		return daoTplPath;
	}

	public void setDaoTplPath(String daoTplPath) {
		this.daoTplPath = daoTplPath;
	}

	public String getDaoImplTplPath() {
		return daoImplTplPath;
	}

	public void setDaoImplTplPath(String daoImplTplPath) {
		this.daoImplTplPath = daoImplTplPath;
	}

	public StringBuilder getContent() {
		return content;
	}

	public void setContent(StringBuilder content) {
		this.content = content;
	}

	public String[] getStrutsPath() {
		return strutsPath;
	}

	public void setStrutsPath(String[] strutsPath) {
		this.strutsPath = strutsPath;
	}

	public Document getStrutsDoc() {
		return strutsDoc;
	}

	public void setStrutsDoc(Document strutsDoc) {
		this.strutsDoc = strutsDoc;
	}

}
