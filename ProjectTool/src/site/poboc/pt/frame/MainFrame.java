package site.poboc.pt.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URISyntaxException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import site.poboc.pt.chain.filehandler.FileHanderChain;
import site.poboc.pt.chain.replacer.ReplacerChain;
import site.poboc.pt.utils.ProjectUtils;
import site.poboc.pt.utils.ReplaceBean;

public class MainFrame extends JFrame {
	
	private JTextArea contentArea = new JTextArea();
	
	private JTextField actionPathField = new JTextField();
	private JTextField actionPkgField = new JTextField();
	
	private JTextField serviceInterfaceField = new JTextField();
	private JTextField serviceImplField = new JTextField();
	
	private JTextField daoInterfaceField = new JTextField();
	private JTextField daoImplField = new JTextField();
	
	private JTextField domainClassField = new JTextField();
	private JTextField domainPkgField = new JTextField("cn.itcast.bos");
	
	private JTextField srcField = new JTextField();
	private JTextField strutsField = new JTextField();

	public void init() {
		this.setTitle("项目基础类生成工具");
		this.setSize(600, 400);
		this.setLocation(300, 200);

		JPanel rootPane = new JPanel();
		rootPane.setLayout(new BorderLayout());

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		Dimension preferredSize = new Dimension(600, 100);
		tabbedPane.setPreferredSize(preferredSize);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.VERTICAL);

		// action层配置面板
		JPanel actionPane = new JPanel();
		actionPane.setLayout(new GridLayout(3, 2));
		JLabel actionLabel = new JLabel("action路径：");
//		actionLabel.setHorizontalAlignment(JLabel.RIGHT);
//		actionLabel.setVerticalAlignment(JLabel.CENTER);
		actionPane.add(actionLabel);
		actionPane.add(actionPathField);
		actionPane.add(new JLabel(""));
		actionPane.add(new JLabel(""));
		actionPane.add(new JLabel(""));
		actionPane.add(new JLabel(""));
//		actionPane.add(new JLabel(""));
//		actionPane.add(new JLabel(""));
//		actionPane.add(new JLabel(""));
//		actionPane.add(new JLabel(""));
		
		// service层配置面板
		JPanel servicePane = new JPanel();
		servicePane.setLayout(new GridLayout(3, 2));
		servicePane.add(new JLabel("service接口："));
		servicePane.add(serviceInterfaceField);
		servicePane.add(new JLabel("service实现类："));
		servicePane.add(serviceImplField);
		servicePane.add(new JLabel(""));
		servicePane.add(new JLabel(""));
//		servicePane.add(new JLabel(""));
//		servicePane.add(new JLabel(""));
//		servicePane.add(new JLabel(""));
//		servicePane.add(new JLabel(""));
		
		// dao层配置面板
		JPanel daoPane = new JPanel();
		daoPane.setLayout(new GridLayout(3, 2));
		daoPane.add(new JLabel("dao接口："));
		daoPane.add(daoInterfaceField);
		daoPane.add(new JLabel("dao实现类："));
		daoPane.add(daoImplField);
		daoPane.add(new JLabel(""));
		daoPane.add(new JLabel(""));
//		daoPane.add(new JLabel(""));
//		daoPane.add(new JLabel(""));
//		daoPane.add(new JLabel(""));
//		daoPane.add(new JLabel(""));

		// action层配置面板
		JPanel domainPane = new JPanel();
		domainPane.setLayout(new GridLayout(3, 2));
		domainPane.add(new JLabel("domain类名："));
		domainPane.add(domainClassField);
		domainPane.add(new JLabel("基础包名："));
		domainPane.add(domainPkgField);
		domainPane.add(new JLabel(""));
		domainPane.add(new JLabel(""));
//		domainPane.add(new JLabel(""));
//		domainPane.add(new JLabel(""));
//		domainPane.add(new JLabel(""));
//		domainPane.add(new JLabel(""));
		
		JPanel targetPane = new JPanel();
		targetPane.setLayout(new GridLayout(3, 2));
		targetPane.add(new JLabel("struts路径："));
		targetPane.add(strutsField);
		targetPane.add(new JLabel(""));
		targetPane.add(new JLabel(""));
		targetPane.add(new JLabel(""));
		targetPane.add(new JLabel(""));
//		targetPane.add(new JLabel(""));
//		targetPane.add(new JLabel(""));
//		targetPane.add(new JLabel(""));
//		targetPane.add(new JLabel(""));
		
		//选项卡面板
//		tabbedPane.addTab("Action层配置", null, actionPane);
//		tabbedPane.addTab("Service层配置", null, servicePane);
//		tabbedPane.addTab("Dao层配置", null, daoPane);
		tabbedPane.addTab("Domain配置", null, domainPane);
		tabbedPane.addTab("Dao输出配置", null, daoPane);
		tabbedPane.addTab("Service输出配置", null, servicePane);
		tabbedPane.addTab("Action输出配置", null, actionPane);
		tabbedPane.addTab("struts输出配置", null, targetPane);
		rootPane.add(tabbedPane, BorderLayout.NORTH);

		contentArea.setEditable(false);
		rootPane.add(contentArea, BorderLayout.CENTER);
		
		JPanel westPane = new JPanel();
		JButton geneBtn = new JButton("生成代码");
		geneBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						String domainClass = domainClassField.getText();
						String basePkg = domainPkgField.getText();
						String strutsPath = strutsField.getText();
						String daoInterfacePath = daoInterfaceField.getText();
						String daoImplPath = daoImplField.getText();
						String serviceInterfacePath = serviceInterfaceField.getText();
						String serviceImplPath = serviceImplField.getText();
						String actionPath = actionPathField.getText();
						String[] strutsPathArr;
						
						if(ProjectUtils.su.isNotBlank(domainClass)
								&& ProjectUtils.su.isNotBlank(basePkg)
								&& ProjectUtils.su.isNotBlank(daoInterfacePath)
								&& ProjectUtils.su.isNotBlank(daoImplPath)
								&& ProjectUtils.su.isNotBlank(serviceInterfacePath)
								&& ProjectUtils.su.isNotBlank(serviceImplPath)
								&& ProjectUtils.su.isNotBlank(actionPath)
								&& ProjectUtils.su.isNotBlank(strutsPath)
								&& (strutsPathArr = strutsPath.split("\\$")).length == 2){
							boolean hasError = false;
							contentArea.setForeground(Color.BLACK);
							contentArea.setText("");
							ReplaceBean rb = new ReplaceBean();
							rb.setDomainClass(domainClass);
							rb.setBasePkg(basePkg);
							rb.setDomainVer(ProjectUtils
									.su.toHeaderLowerCase(domainClass));
//							rb.setSrcPath(srcPath);
							rb.setDaoImplPath(daoImplPath);
							rb.setDaoInterfacePath(daoInterfacePath);
							rb.setServiceImplPath(serviceImplPath);
							rb.setServiceInterfacePath(serviceInterfacePath);
							rb.setActionPath(actionPath);
							rb.setStrutsPath(strutsPathArr);
							try {
								initTplPath(rb);
							} catch (URISyntaxException e1) {
								hasError = true;
								contentArea.setText("模版路径初始化错误！");
								e1.printStackTrace();
							}
							if(!hasError){
								try {
									FileHanderChain.chain.handle(rb);
								} catch (Exception e2) {
									hasError = true;
									contentArea.setForeground(Color.RED);
									contentArea.setText("代码生成异常！");
									e2.printStackTrace();
								}
								if(!hasError){
									contentArea.setText(domainClassField.getText()+"代码生成成功！");
								}
							}
						} else {
							contentArea.setForeground(Color.RED);
							contentArea.setText("请您确认以下信息是否输入正确：\n "
									+ "    domain类名是否输入\n"
									+ "    基础包名是否输入\n"
									+ "    Action、Service、Dao路径是否输入\n"
									+ "    struts路径是否输入\n"
									+ "    struts路径格式是否正确，格式是：struts.xml绝对路径$package标签的name属性\n");
						}
					}
				});
				
			}

			private void initTplPath(ReplaceBean rb) throws URISyntaxException {
				rb.setActionTplPath("/site/poboc/pt/template/action/Action.tpl");
				rb.setSerTplPath("/site/poboc/pt/template/service/Service.tpl");
				rb.setSerImplTplPath("/site/poboc/pt/template/service/ServiceImpl.tpl");
				rb.setDaoTplPath("/site/poboc/template/dao/Dao.tpl");
				rb.setDaoImplTplPath("/site/poboc/template/dao/DaoImpl.tpl");
			}
		});
		westPane.add(geneBtn);
		
		rootPane.add(westPane, BorderLayout.WEST);

		this.setContentPane(rootPane);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
