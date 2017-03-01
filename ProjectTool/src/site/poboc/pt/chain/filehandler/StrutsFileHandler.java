package site.poboc.pt.chain.filehandler;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.QName;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import site.poboc.pt.chain.replacer.ReplacerChain;
import site.poboc.pt.utils.IgnoreDTDEntityResolver;
import site.poboc.pt.utils.ProjectUtils;
import site.poboc.pt.utils.ReplaceBean;

public class StrutsFileHandler extends AbstractFileHander {

	@Override
	public void readFromFile(ReplaceBean rb) {
		String[] strutsPath = rb.getStrutsPath();
		StringBuilder sb = ProjectUtils.su.readFileToSB(strutsPath[0]);
		rb.setContent(sb);
	}

	@Override
	public void writeToFile(ReplaceBean rb) {
		Document strutsDoc = rb.getStrutsDoc();
		XMLWriter writer = null;
		try {
			OutputFormat format = OutputFormat.createPrettyPrint();
			format.setEncoding("UTF-8");
			writer = new XMLWriter(new FileOutputStream(rb.getStrutsPath()[0]), format);
			writer.write(strutsDoc);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(null != writer){
					writer.close();
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	@Override
	public void replace(StringBuilder sb, ReplaceBean replaceBean) {
		try {
			SAXReader saxReader = new SAXReader(); 
			saxReader.setValidation(false);
//			saxReader.setIgnoreComments(true);
			saxReader.setEncoding("utf-8");
			saxReader.setEntityResolver(new IgnoreDTDEntityResolver());
			Document strutsDoc  = saxReader.read(new ByteArrayInputStream(sb.toString().getBytes("utf-8")));
//			Document strutsDoc = DocumentHelper.parseText(sb.toString());
			Element rootElement = strutsDoc.getRootElement();
			Element element = this.getElementByName(rootElement, replaceBean.getStrutsPath()[1]);

			element = element.addElement("action");
			element.addAttribute("name", replaceBean.getDomainVer() + "Action_*");
			element.addAttribute("class", replaceBean.getDomainVer() + "Action");
			element.addAttribute("method", "{1}");

			replaceBean.setStrutsDoc(strutsDoc);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Element getElementByName(Element element, String name) {
		List<Element> elements = element.elements();
		if (null != elements && elements.size() > 0) {
			Iterator<Element> iterator = elements.iterator();
			while (iterator.hasNext()) {
				Element next = iterator.next();
				Attribute attribute = next.attribute("name");
				if (null == attribute)
					continue;
				String text = attribute.getText();
				if (name.equals(text)) {
					return next;
				}
			}
		}
		return null;
	}

}
