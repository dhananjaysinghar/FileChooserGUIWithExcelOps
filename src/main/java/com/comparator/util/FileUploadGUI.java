package com.comparator.util;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JFileChooser;

import com.comparator.domain.Account;

public class FileUploadGUI extends javax.swing.JFrame {

	private final JFileChooser fileChooser;

	private javax.swing.JButton chooseFile;
	private javax.swing.JLabel fileLocation;
	private javax.swing.JButton jButton1;

	public FileUploadGUI() {
		initComponents();
		fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File("C:/temp/"));
	}

	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new FileUploadGUI().setVisible(true);
			}
		});

	}

	private void initComponents() {
		jButton1 = new javax.swing.JButton();
		chooseFile = new javax.swing.JButton();
		fileLocation = new javax.swing.JLabel();
		jButton1.setText("jButton1");
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		chooseFile.setText("Choose File...");
		chooseFile.setToolTipText("");
		chooseFile.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				chooseFileActionPerformed(evt);
			}
		});

		fileLocation.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(chooseFile).addGap(10, 10, 10)
						.addComponent(fileLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 256,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(43, 43, 43)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(fileLocation, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(chooseFile, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGap(215, 215, 215)));

		pack();
	}

	private void chooseFileActionPerformed(java.awt.event.ActionEvent evt) {
		int returnValue = fileChooser.showOpenDialog(this);

		if (returnValue == JFileChooser.APPROVE_OPTION) {
			try {
				String path = fileChooser.getSelectedFile().getAbsolutePath();
				CommonUtils.runJob(path);
				System.exit(0);

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			fileLocation.setText("No FIle Choosen !");
		}
	}
}