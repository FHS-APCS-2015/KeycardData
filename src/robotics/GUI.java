/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package robotics;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JOptionPane;

/**
 *
 * @author David
 */
public class GUI extends javax.swing.JFrame implements KeyListener,
		WindowListener {
	private static final String path = "";
	private static final String studentData = "StudentData.csv";
	private static final String attendanceData = "AttendanceData.csv";
	private static final int CURRENT_SEASON = 2015;

	private EmployeeRecords records;

	public GUI() {
		initComponents();

		JOptionPane.showMessageDialog(null, "Type help for commands");

		records = new EmployeeRecords();

		records.loadEmployeeDataFromFile(path + studentData);
		records.loadAttendanceDataFromFile(path + attendanceData);

		displayTextArea.addKeyListener(this);
		this.addWindowListener(this);
	}

	public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		System.out.println("Window closing!");
		records.logOutAllStudents();
		records.writeAttendanceDataToFile(path + attendanceData);
	}

	public void windowClosed(java.awt.event.WindowEvent windowEvent) {
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		displayTextArea = new javax.swing.JTextArea();
		jScrollPane2 = new javax.swing.JScrollPane();
		output = new javax.swing.JTextArea();
		jTextField1 = new javax.swing.JTextField();
		jLabel1 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyTyped(java.awt.event.KeyEvent evt) {
				formKeyTyped(evt);
			}
		});

		jPanel1
				.setBorder(javax.swing.BorderFactory
						.createTitledBorder("Firebots Attendance Tracker - Type 'help' to see commands"));

		jScrollPane1.setEnabled(false);

		displayTextArea.setEditable(false);
		displayTextArea.setColumns(20);
		displayTextArea.setFont(new java.awt.Font("Consolas", 0, 10)); // NOI18N
		displayTextArea.setRows(5);
		jScrollPane1.setViewportView(displayTextArea);

		output.setColumns(20);
		output.setLineWrap(true);
		output.setRows(5);
		jScrollPane2.setViewportView(output);

		jTextField1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField1ActionPerformed(evt);
			}
		});
		jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyTyped(java.awt.event.KeyEvent evt) {
				jTextField1KeyTyped(evt);
			}
		});

		jLabel1.setText(">");

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout
				.setHorizontalGroup(jPanel1Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addComponent(jLabel1)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(jTextField1))
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addComponent(jScrollPane1,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				477,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																		.addComponent(jScrollPane2,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				332, Short.MAX_VALUE)))
										.addContainerGap()));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						jPanel1Layout
								.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										jPanel1Layout
												.createParallelGroup(
														javax.swing.GroupLayout.Alignment.LEADING, false)
												.addComponent(jScrollPane2,
														javax.swing.GroupLayout.DEFAULT_SIZE, 319,
														Short.MAX_VALUE).addComponent(jScrollPane1))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										jPanel1Layout
												.createParallelGroup(
														javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jTextField1,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel1))
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));

		pack();
	}// </editor-fold>

	private void formKeyTyped(java.awt.event.KeyEvent evt) {
		if (evt.getKeyCode() == evt.VK_UP) {
			// game.handleEvent(Game.Event.UP);
		}
	}

	private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {
		if (evt.getKeyChar() == '\n') {
			String command = jTextField1.getText();
			output.append("\n> " + jTextField1.getText());
			jTextField1.setText("");

			handleCommand(command);
		}
	}

	private void handleCommand(String command) {
		displayTextArea.append("\n");
		String[] words = command.split(" ");

		if (words.length == 0)
			return;

		String first = words[0];
		String second = (words.length >= 2) ? words[1] : null;
		String third = (words.length >= 3) ? words[2] : null;
		String rest = (words.length >= 2) ? command.substring(
				command.indexOf(" ") + 1).trim() : "";

		if (first.equals("help")) {
			displayHelpMessage();
		} else if (records.isId(first)) { // ***** Register Swipe *****
			String id = first;
			records.registerSwipe(id, LocalDateTime.now());
			Employee e = records.getEmployeeById(id);
			if (e != null) {
				displayTextArea.append("Registered swipe for " + e.getFirstName()
						+ ". Student is "
						+ ((e.isInBuilding()) ? "signed IN" : "signed OUT"));

				records.writeAttendanceDataToFile(path + attendanceData);
			}
			// ***** Lookup by Name ****
		} else if (records.isName(first)) {
			List<Employee> list = records.getEmployeesByName(first);
			for (Employee e : list) {
				displayTextArea.append(e.displayInfo() + "\n");
				displayTextArea.append(e.getReportFor() + "\n");
			}

			// **** List Missing Students ****
		} else if (first.equals("missing")) {
			if (second == null)
				return;

			List<Employee> list = records.getCurrentlyAbsentEmployeesFor(second);
			for (Employee e : list)
				displayTextArea.append(e.displayInfo() + "\n");

			displayTextArea.append("Total: " + list.size());

		} else if (first.equals("logout")) { // **** Logout a student Student ****
			Employee e = records.getEmployeeById(second);
			if (e != null) {
				if (third != null) {
					try {
						double amt = Double.parseDouble(third);
						int hours = (int) amt;
						int minutes = (int) (amt - hours * 60);
						LocalDateTime t = LocalDateTime.now().minusHours(hours)
								.minusMinutes(minutes);
						e.logout(t);

						records.writeAttendanceDataToFile(path + attendanceData);
					} catch (Exception exc) {
						System.out.println("Problem logging student out");
					}
				}
			}

		} else if (first.equals("report")) {
			ArrayList<Employee> list = records.getAllEmployees();
			Collections.sort(list);
			Collections.reverse(list);

			for (Employee e : list) {
				displayTextArea.append(e.getFirstName() + " " + e.getLastName() + "\n");
				displayTextArea.append(e.getReportFor());
			}

			records.writeAttendanceReportToFile("..\\attendanceReport.csv");
		} else if (first.equals("list")) {
			displayTextArea.append((second == null) ? records.getAllStudentsString()
					: records.getStudentsString(rest) + "\n");

			// **** List who is present ****
		} else if (first.equals("who")) {
			List<Employee> lst = records
					.getEmployeesInBuildingAt(LocalDateTime.now());

			if (second == null) {
				displayTextArea.append("Students preset at " + LocalDateTime.now()
						+ ": " + lst.size() + "\n");

				for (Employee e : lst) {
					this.displayTextArea.append(e.getFirstName() + " " + e.getLastName()
							+ "\n");
				}
			} else {
				List<Employee> lst2 = new ArrayList<Employee>();
				for (Employee e : lst) {
					if (e.getSubteam().toLowerCase().equals(second.toLowerCase()))
						lst2.add(e);
				}

				displayTextArea.append("members of " + second.toUpperCase()
						+ " preset at " + LocalDateTime.now() + ": " + lst2.size() + "\n");

				for (Employee e : lst2) {
					this.displayTextArea.append(e.getFirstName() + " " + e.getLastName()
							+ "\n");
				}
			}
			this.displayTextArea.append("***\n");
		} else if (first.equals("exitnosave")) {
			System.exit(0);
		} else if (first.equals("register")) {
			if (second == null) {
				displayTextArea.append("To use the command: register <id-number>");
				return;
			}

			if (records.isId(second)) {
				displayTextArea.append("This id is already registered.");
				return;
			}

			String fn = JOptionPane.showInputDialog("Type your first name");
			String ln = JOptionPane.showInputDialog("Type your last name");
			String team = JOptionPane.showInputDialog("What subteam are you on?");
			Employee e = new Employee(second, fn, ln, Employee.getSubteamFor(team),
					CURRENT_SEASON);
			records.addEmployee(e);
			records.writeEmployeeDataToFile(path + studentData);
			displayTextArea.append("You have been registered.");

			records.registerSwipe(e.getId(), LocalDateTime.now());
			displayTextArea
					.append("Registered swipe for " + e.getFirstName() + ". Student is "
							+ ((e.isInBuilding()) ? "signed IN" : "signed OUT"));

			records.writeAttendanceDataToFile(path + attendanceData);
		}
	}

	private void displayHelpMessage() {
		displayTextArea.append("Commands:\n");
		displayTextArea.append("help\t\t- Get this list\n\n");

		displayTextArea.append("who\t\t- List who is present\n");
		displayTextArea
				.append("who [subteam]\t\t- List who is present in a subteam.\n\n");

		displayTextArea.append("[id #]\t\t- Scans person in or out\n");
		displayTextArea
				.append("[first name]\t\t- List whether person is present\n");
		displayTextArea.append("[last name]\t\t- List whether person is present\n");
		displayTextArea
				.append("list\t\t- List all people (regardless of whether present)\n");
		displayTextArea
				.append("list [subteam name]\t\t- List all people in subteam.\n");

	}

	/**
	 * @param args
	 *          the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed"
		// desc=" Look and feel setting code (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the
		 * default look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf. html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
					.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(GUI.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(GUI.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(GUI.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(GUI.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new GUI().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify
	private javax.swing.JLabel jLabel1;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextArea output;
	private javax.swing.JTextArea displayTextArea;

	// End of variables declaration

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == e.VK_UP) {
			// game.handleEvent(Game.Event.UP);
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}
}