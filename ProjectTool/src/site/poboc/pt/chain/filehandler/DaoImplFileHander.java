package site.poboc.pt.chain.filehandler;

import site.poboc.pt.chain.replacer.ReplacerChain;
import site.poboc.pt.utils.ProjectUtils;
import site.poboc.pt.utils.ReplaceBean;

public class DaoImplFileHander extends AbstractFileHander {

	@Override
	public void readFromFile(ReplaceBean rb) {
		String daoImplTplPath = rb.getDaoImplTplPath();
		StringBuilder sb = ProjectUtils.su.readFileToSB(daoImplTplPath);
		rb.setContent(sb);
	}

	@Override
	public void writeToFile(ReplaceBean rb) {
		ProjectUtils.su.writeString2File(rb, rb.getDaoImplPath(), "DaoImpl.java", "dao/impl", false);
	}

	@Override
	public void replace(StringBuilder sb, ReplaceBean replaceBean) {
		ReplacerChain.chain.replace(sb, replaceBean);
	}

}
