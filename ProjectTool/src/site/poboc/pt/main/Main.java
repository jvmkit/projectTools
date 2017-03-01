package site.poboc.pt.main;

import javax.swing.SwingUtilities;

import site.poboc.pt.frame.MainFrame;

public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run() {
				new MainFrame().init();
			}
		});
	}
}
