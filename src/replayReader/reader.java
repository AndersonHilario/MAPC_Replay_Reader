package replayReader;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import org.apache.commons.io.FilenameUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Iterator;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;
import javax.swing.JDesktopPane;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JSplitPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.table.DefaultTableModel;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.MouseMotionAdapter;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;

public class reader {

	private JFrame frame;
	private JTabbedPane tabbedPaneAgents1;
	private JTable tableStorages;
	private JTable tableResourceNodes;
	private JTable tableTeams;
	private JTable tableJobs;
	private JTable tableDumps;
	private JTable tableWorkshops;
	private JTable tableShops;
	private JTable tableChargingStation;
	private JTable tableAgents1;
	private JTable tableWells;
	private JComboBox<String> comboBoxTblAgents1;
	private JComboBox<String> comboBoxTblAgents2;
	private JComboBox<String> comboBoxTblAgents3;
	private JTable tableAgents3;
	private JTable tableAgents2;
	private boolean resetedChange;
	private ArrayList<String> combo1Historico = new ArrayList<>();
	private ArrayList<String> combo2Historico = new ArrayList<>();
	private ArrayList<String> combo3Historico = new ArrayList<>();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					reader window = new reader();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public reader() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 943, 754);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel lblTitle = new JLabel("Replay Reader");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 24));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Storages", null, panel, null);
		tabbedPane.setEnabledAt(0, true);

		JScrollPane scrollPane = new JScrollPane();

		tableStorages = new JTable();
		tableStorages.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Used Capacity",
				"Total Capacity", "Stored Items", "Name", "All Stored Items", "Lon", "Lat" }));
		scrollPane.setViewportView(tableStorages);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(scrollPane,
				GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(scrollPane,
				GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE));
		panel.setLayout(gl_panel);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Resource Nodes", null, panel_1, null);

		JScrollPane scrollPane_1 = new JScrollPane();

		tableResourceNodes = new JTable();
		tableResourceNodes
				.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Resource", "Name", "Lon", "Lat" }));
		scrollPane_1.setViewportView(tableResourceNodes);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addComponent(scrollPane_1,
				GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addComponent(scrollPane_1,
				GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE));
		panel_1.setLayout(gl_panel_1);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Teams", null, panel_2, null);

		JScrollPane scrollPane_2 = new JScrollPane();

		tableTeams = new JTable();
		tableTeams.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Score", "Name", "Massium" }));
		scrollPane_2.setViewportView(tableTeams);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING).addComponent(scrollPane_2,
				GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE));
		gl_panel_2.setVerticalGroup(
				gl_panel_2.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_2.createSequentialGroup().addGap(5)
						.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)));
		panel_2.setLayout(gl_panel_2);

		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Jobs", null, panel_3, null);

		JScrollPane scrollPane_3 = new JScrollPane();

		tableJobs = new JTable();
		tableJobs.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Reward", "Delivered Items", "Start",
				"End", "Id", "Storage", "Poster", "Required Items" }));
		scrollPane_3.setViewportView(tableJobs);
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(gl_panel_3.createParallelGroup(Alignment.LEADING).addComponent(scrollPane_3,
				GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE));
		gl_panel_3.setVerticalGroup(
				gl_panel_3.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_3.createSequentialGroup().addGap(5)
						.addComponent(scrollPane_3, GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)));
		panel_3.setLayout(gl_panel_3);

		JPanel panel_6 = new JPanel();
		tabbedPane.addTab("Dumps", null, panel_6, null);

		JScrollPane scrollPane_4 = new JScrollPane();

		tableDumps = new JTable();
		tableDumps.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Name", "Lon", "Lat" }));
		scrollPane_4.setViewportView(tableDumps);
		GroupLayout gl_panel_6 = new GroupLayout(panel_6);
		gl_panel_6.setHorizontalGroup(gl_panel_6.createParallelGroup(Alignment.LEADING).addComponent(scrollPane_4,
				GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE));
		gl_panel_6.setVerticalGroup(
				gl_panel_6.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_6.createSequentialGroup().addGap(5)
						.addComponent(scrollPane_4, GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)));
		panel_6.setLayout(gl_panel_6);

		JPanel panel_7 = new JPanel();
		tabbedPane.addTab("Workshops", null, panel_7, null);

		JScrollPane scrollPane_5 = new JScrollPane();

		tableWorkshops = new JTable();
		tableWorkshops.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Name", "Lon", "Lat" }));
		scrollPane_5.setViewportView(tableWorkshops);
		GroupLayout gl_panel_7 = new GroupLayout(panel_7);
		gl_panel_7.setHorizontalGroup(gl_panel_7.createParallelGroup(Alignment.LEADING).addComponent(scrollPane_5,
				GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE));
		gl_panel_7.setVerticalGroup(
				gl_panel_7.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_7.createSequentialGroup().addGap(5)
						.addComponent(scrollPane_5, GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)));
		panel_7.setLayout(gl_panel_7);

		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Shops", null, panel_4, null);

		JScrollPane scrollPane_6 = new JScrollPane();

		tableShops = new JTable();
		tableShops.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Name", "Lon", "Lat" }));
		scrollPane_6.setViewportView(tableShops);
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(gl_panel_4.createParallelGroup(Alignment.LEADING).addComponent(scrollPane_6,
				GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE));
		gl_panel_4.setVerticalGroup(
				gl_panel_4.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_4.createSequentialGroup().addGap(5)
						.addComponent(scrollPane_6, GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)));
		panel_4.setLayout(gl_panel_4);

		JPanel panel_8 = new JPanel();
		tabbedPane.addTab("Wells", null, panel_8, null);

		JScrollPane scrollPane_9 = new JScrollPane();
		GroupLayout gl_panel_8 = new GroupLayout(panel_8);
		gl_panel_8.setHorizontalGroup(gl_panel_8.createParallelGroup(Alignment.LEADING).addComponent(scrollPane_9,
				GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE));
		gl_panel_8.setVerticalGroup(gl_panel_8.createParallelGroup(Alignment.LEADING).addComponent(scrollPane_9,
				GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE));

		tableWells = new JTable();
		tableWells.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Integrity", "Name", "Lon", "Team", "Type", "Lat" }));
		scrollPane_9.setViewportView(tableWells);
		panel_8.setLayout(gl_panel_8);

		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("Charging Stations", null, panel_5, null);

		JScrollPane scrollPane_7 = new JScrollPane();

		tableChargingStation = new JTable();
		tableChargingStation
				.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Rate", "Name", "Lon", "Late" }));
		scrollPane_7.setViewportView(tableChargingStation);
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(gl_panel_5.createParallelGroup(Alignment.LEADING).addComponent(scrollPane_7,
				GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE));
		gl_panel_5.setVerticalGroup(
				gl_panel_5.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_5.createSequentialGroup().addGap(5)
						.addComponent(scrollPane_7, GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)));
		panel_5.setLayout(gl_panel_5);

		tabbedPaneAgents1 = new JTabbedPane(JTabbedPane.TOP);

		comboBoxTblAgents1 = new JComboBox<String>();

		JPanel panel_9 = new JPanel();
		tabbedPaneAgents1.addTab("Agents", null, panel_9, null);

		JScrollPane scrollPane_8 = new JScrollPane();

		tableAgents1 = new JTable();
		tableAgents1.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Charge Max", "Charge", "Role", "Route Length", "Lon", "Team", "Load Max", "Speed",
						"Vision", "Route", "Load", "Last Action", "Skill", "Name", "Items", "Facility", "Lat" }));
		scrollPane_8.setViewportView(tableAgents1);
		GroupLayout gl_panel_9 = new GroupLayout(panel_9);
		gl_panel_9.setHorizontalGroup(gl_panel_9.createParallelGroup(Alignment.LEADING).addComponent(scrollPane_8,
				GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE));
		gl_panel_9.setVerticalGroup(gl_panel_9.createParallelGroup(Alignment.LEADING).addComponent(scrollPane_8,
				GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE));
		panel_9.setLayout(gl_panel_9);

		JButton btnImportarJson = new JButton("Importar JSON");
		btnImportarJson.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg) {
				JFileChooser fileChooser = new JFileChooser();
				int returnValue = fileChooser.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();
					readJSON(selectedFile);
				}
			}
		});
		frame.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { lblTitle, tabbedPane,
				panel, panel_2, panel_3, panel_6, panel_7, panel_8, btnImportarJson }));

		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);

		JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);

		comboBoxTblAgents2 = new JComboBox<String>();

		comboBoxTblAgents3 = new JComboBox<String>();

		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(10)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTitle, GroupLayout.DEFAULT_SIZE, 907, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup().addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(tabbedPaneAgents1, GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
										.addGroup(groupLayout.createSequentialGroup()
												.addComponent(tabbedPane_2, GroupLayout.DEFAULT_SIZE, 493,
														Short.MAX_VALUE)
												.addGap(3))
										.addGroup(groupLayout.createSequentialGroup()
												.addComponent(tabbedPane_1, GroupLayout.DEFAULT_SIZE, 493,
														Short.MAX_VALUE)
												.addGap(4))
										.addComponent(comboBoxTblAgents2, GroupLayout.PREFERRED_SIZE, 139,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(comboBoxTblAgents3, GroupLayout.PREFERRED_SIZE, 139,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(comboBoxTblAgents1, GroupLayout.PREFERRED_SIZE, 139,
												GroupLayout.PREFERRED_SIZE))))
				.addGap(10))
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(btnImportarJson, GroupLayout.DEFAULT_SIZE, 898, Short.MAX_VALUE).addGap(19)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup()
				.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE).addGap(21)
				.addComponent(comboBoxTblAgents1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(tabbedPaneAgents1, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
								.addGap(14)
								.addComponent(comboBoxTblAgents2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGap(16).addComponent(tabbedPane_1, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
								.addGap(7)
								.addComponent(comboBoxTblAgents3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGap(10).addComponent(tabbedPane_2, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)))
				.addGap(28).addComponent(btnImportarJson, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
				.addGap(20)));

		JScrollPane scrollPane_11 = new JScrollPane();
		tabbedPane_2.addTab("New tab", null, scrollPane_11, null);

		tableAgents3 = new JTable();
		tableAgents3.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Charge Max", "Charge", "Role", "Route Length", "Lon", "Team", "Load Max", "Speed",
						"Vision", "Route", "Load", "Last Action", "Skill", "Name", "Items", "Facility", "Lat" }));
		scrollPane_11.setViewportView(tableAgents3);

		JScrollPane scrollPane_10 = new JScrollPane();
		tabbedPane_1.addTab("New tab", null, scrollPane_10, null);

		tableAgents2 = new JTable();
		tableAgents2.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Charge Max", "Charge", "Role", "Route Length", "Lon", "Team", "Load Max", "Speed",
						"Vision", "Route", "Load", "Last Action", "Skill", "Name", "Items", "Facility", "Lat" }));
		scrollPane_10.setViewportView(tableAgents2);
		frame.getContentPane().setLayout(groupLayout);
	}

	public void readJSON(File file) {
		try {
			resetedChange = false;
			String fileNameExt = file.getName();
			String fileName = FilenameUtils.removeExtension(fileNameExt);
			int stepInt = 0;
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(new FileReader(file));

			for (int i = 0; i < 5; i++) {
				JSONObject jsonObject = (JSONObject) obj;
				JSONObject step = (JSONObject) jsonObject.get(fileName);
				JSONArray storages = (JSONArray) step.get("storages");
				JSONArray resourceNodes = (JSONArray) step.get("resourceNodes");
				JSONArray teams = (JSONArray) step.get("teams");
				JSONArray jobs = (JSONArray) step.get("jobs");
				JSONArray dumps = (JSONArray) step.get("dumps");
				JSONArray workshops = (JSONArray) step.get("workshops");
				JSONArray shops = (JSONArray) step.get("shops");
				JSONArray wells = (JSONArray) step.get("wells");
				JSONArray chargingStations = (JSONArray) step.get("chargingStations");
				JSONArray entities = (JSONArray) step.get("entities");

				fillStorage(storages);
				fillResourceNode(resourceNodes);
				fillTeam(teams);
				fillJob(jobs);
				fillDump(dumps);
				fillWorkshop(workshops);
				fillShop(shops);
				fillWells(wells);
				fillChargingStation(chargingStations);
				fillComboBoxAgent(entities);
				fillTableAgents(entities);

				stepInt = Integer.parseInt(fileName);
				stepInt++;
				fileName = Integer.toString(stepInt);

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void fillStorage(JSONArray storages) {
		DefaultTableModel model = (DefaultTableModel) tableStorages.getModel();
		for (int i = 0; i < storages.size(); i++) {
			JSONObject storageAtual = (JSONObject) storages.get(i);
			long usedCapacity = (long) storageAtual.get("usedCapacity");
			long totalCapacity = (long) storageAtual.get("totalCapacity");
			JSONArray storedItems = (JSONArray) storageAtual.get("storedItems");
			String name = (String) storageAtual.get("name");
			JSONArray allStoredItems = (JSONArray) storageAtual.get("allStoredItems");
			double lon = (double) storageAtual.get("lon");
			double lat = (double) storageAtual.get("lat");
			model.addRow(new Object[] { usedCapacity, totalCapacity, storedItems, name, allStoredItems, lon, lat });
		}
	}

	private void fillResourceNode(JSONArray resourceNodes) {
		DefaultTableModel model = (DefaultTableModel) tableResourceNodes.getModel();
		for (int i = 0; i < resourceNodes.size(); i++) {
			JSONObject resourceNodeAtual = (JSONObject) resourceNodes.get(i);
			String resource = (String) resourceNodeAtual.get("resource");
			String name = (String) resourceNodeAtual.get("name");
			double lon = (double) resourceNodeAtual.get("lon");
			double lat = (double) resourceNodeAtual.get("lat");
			model.addRow(new Object[] { resource, name, lon, lat });
		}
	}

	private void fillTeam(JSONArray teams) {
		DefaultTableModel model = (DefaultTableModel) tableTeams.getModel();
		for (int i = 0; i < teams.size(); i++) {
			JSONObject teamAtual = (JSONObject) teams.get(i);
			long score = (long) teamAtual.get("score");
			String name = (String) teamAtual.get("name");
			long massium = (long) teamAtual.get("massium");
			model.addRow(new Object[] { score, name, massium });
		}
	}

	private void fillJob(JSONArray jobs) {
		DefaultTableModel model = (DefaultTableModel) tableJobs.getModel();
		for (int i = 0; i < jobs.size(); i++) {
			JSONObject jobAtual = (JSONObject) jobs.get(i);
			long reward = (long) jobAtual.get("reward");
			JSONArray deliveredItems = (JSONArray) jobAtual.get("deliveredItems");
			long start = (long) jobAtual.get("start");
			long end = (long) jobAtual.get("end");
			String id = (String) jobAtual.get("id");
			String storage = (String) jobAtual.get("storage");
			String poster = (String) jobAtual.get("poster");
			JSONArray requiredItemsArray = (JSONArray) jobAtual.get("requiredItems");
			String requiredItems = "";
			// tableJobs.setRowHeight(tableJobs.getRowHeight() * requiredItemsArray.size());
			for (int j = 0; j < requiredItemsArray.size(); j++) {
				JSONObject itemAtual = (JSONObject) requiredItemsArray.get(j);
				long amount = (long) itemAtual.get("amount");
				String name = (String) itemAtual.get("name");
				requiredItems += name + ": " + amount + "\n";
			}
			model.addRow(new Object[] { reward, deliveredItems, start, end, storage, id, poster, requiredItems });
		}
	}

	private void fillDump(JSONArray dumps) {
		DefaultTableModel model = (DefaultTableModel) tableDumps.getModel();
		for (int i = 0; i < dumps.size(); i++) {
			JSONObject dumpAtual = (JSONObject) dumps.get(i);
			String name = (String) dumpAtual.get("name");
			double lon = (double) dumpAtual.get("lon");
			double lat = (double) dumpAtual.get("lat");
			model.addRow(new Object[] { name, lon, lat });
		}
	}

	private void fillWorkshop(JSONArray workshops) {
		DefaultTableModel model = (DefaultTableModel) tableWorkshops.getModel();
		for (int i = 0; i < workshops.size(); i++) {
			JSONObject workshopAtual = (JSONObject) workshops.get(i);
			String name = (String) workshopAtual.get("name");
			double lon = (double) workshopAtual.get("lon");
			double lat = (double) workshopAtual.get("lat");
			model.addRow(new Object[] { name, lon, lat });
		}
	}

	private void fillShop(JSONArray shops) {
		DefaultTableModel model = (DefaultTableModel) tableShops.getModel();
		for (int i = 0; i < shops.size(); i++) {
			JSONObject shopAtual = (JSONObject) shops.get(i);
			String name = (String) shopAtual.get("name");
			double lon = (double) shopAtual.get("lon");
			double lat = (double) shopAtual.get("lat");
			model.addRow(new Object[] { name, lon, lat });
		}
	}

	private void fillChargingStation(JSONArray chargingStations) {
		DefaultTableModel model = (DefaultTableModel) tableChargingStation.getModel();
		for (int i = 0; i < chargingStations.size(); i++) {
			JSONObject chargingStationAtual = (JSONObject) chargingStations.get(i);
			long rate = (long) chargingStationAtual.get("rate");
			String name = (String) chargingStationAtual.get("name");
			double lon = (double) chargingStationAtual.get("lon");
			double lat = (double) chargingStationAtual.get("lat");
			model.addRow(new Object[] { rate, name, lon, lat });
		}
	}

	private void fillComboBoxAgent(JSONArray agents) {
		DefaultComboBoxModel<String> combobox = (DefaultComboBoxModel<String>) comboBoxTblAgents1.getModel();
		DefaultComboBoxModel<String> combobox2 = (DefaultComboBoxModel<String>) comboBoxTblAgents2.getModel();
		DefaultComboBoxModel<String> combobox3 = (DefaultComboBoxModel<String>) comboBoxTblAgents3.getModel();

		for (int i = 0; i < agents.size(); i++) {
			JSONObject agentAtual = (JSONObject) agents.get(i);
			String name = (String) agentAtual.get("name");
			if (i <= 22) {
				if (combobox.getIndexOf(name) == -1) {
					comboBoxTblAgents1.addItem(name);
				}
			}

			if (i > 22 && i <= 44) {
				if (combobox2.getIndexOf(name) == -1) {
					comboBoxTblAgents2.addItem(name);
				}
			}

			if (i > 44) {
				if (combobox3.getIndexOf(name) == -1) {
					comboBoxTblAgents3.addItem(name);
				}
			}
		}
	}

	private void fillWells(JSONArray wells) {
		DefaultTableModel model = (DefaultTableModel) tableWells.getModel();
		for (int i = 0; i < wells.size(); i++) {
			JSONObject wellsAtual = (JSONObject) wells.get(i);
			long integrity = (long) wellsAtual.get("integrity");
			String name = (String) wellsAtual.get("name");
			double lon = (double) wellsAtual.get("lon");
			String team = (String) wellsAtual.get("team");
			String type = (String) wellsAtual.get("type");
			double lat = (double) wellsAtual.get("lat");
			model.addRow(new Object[] { integrity, name, lon, team, type, lat });
		}
	}

	private void resetTable(DefaultTableModel model) {
		if (model.getRowCount() > 0) {
			resetedChange = true;
			while (model.getRowCount() > 0) {
				model.removeRow(0);
			}
		}
	}

	private void fillTableAgents(JSONArray agents) {
		comboBoxTblAgents1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel model = (DefaultTableModel) tableAgents1.getModel();
				Object agenteSelecionadoCombo1 = comboBoxTblAgents1.getSelectedItem();

				for (int i = 0; i < agents.size(); i++) {
					JSONObject agentAtual = (JSONObject) agents.get(i);
					if (agentAtual.get("name").equals(agenteSelecionadoCombo1)) {
						long chargeMax = (long) agentAtual.get("chargeMax");
						long charge = (long) agentAtual.get("charge");
						String role = (String) agentAtual.get("role");
						long routeLength = (long) agentAtual.get("routeLength");
						String team = (String) agentAtual.get("team");
						long loadMax = (long) agentAtual.get("loadMax");
						long speed = (long) agentAtual.get("speed");
						long vision = (long) agentAtual.get("vision");
						JSONArray route = (JSONArray) agentAtual.get("route");
						long load = (long) agentAtual.get("load");
						JSONObject lastAction = (JSONObject) agentAtual.get("lastAction");
						long skill = (long) agentAtual.get("skill");
						String name = (String) agentAtual.get("name");
						JSONArray items = (JSONArray) agentAtual.get("items");
						String facility = (String) agentAtual.get("facility");
						double lon = (double) agentAtual.get("lon");
						double lat = (double) agentAtual.get("lat");

						combo1Historico.add(name);
						int size = combo1Historico.size();
						if (size >= 2) {
							if (!combo1Historico.get(size - 1).equalsIgnoreCase(combo1Historico.get(size - 2))) {
								resetTable(model);
							}
						}

						model.addRow(new Object[] { chargeMax, charge, role, routeLength, lon, team, loadMax, speed,
								vision, route, load, lastAction, skill, name, items, facility, lat });
					}
				}
			}
		});

		comboBoxTblAgents2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel model = (DefaultTableModel) tableAgents2.getModel();
				Object agenteSelecionadoCombo2 = comboBoxTblAgents2.getSelectedItem();

				for (int i = 0; i < agents.size(); i++) {
					JSONObject agentAtual = (JSONObject) agents.get(i);
					if (agentAtual.get("name").equals(agenteSelecionadoCombo2)) {
						long chargeMax = (long) agentAtual.get("chargeMax");
						long charge = (long) agentAtual.get("charge");
						String role = (String) agentAtual.get("role");
						long routeLength = (long) agentAtual.get("routeLength");
						String team = (String) agentAtual.get("team");
						long loadMax = (long) agentAtual.get("loadMax");
						long speed = (long) agentAtual.get("speed");
						long vision = (long) agentAtual.get("vision");
						JSONArray route = (JSONArray) agentAtual.get("route");
						long load = (long) agentAtual.get("load");
						JSONObject lastAction = (JSONObject) agentAtual.get("lastAction");
						long skill = (long) agentAtual.get("skill");
						String name = (String) agentAtual.get("name");
						JSONArray items = (JSONArray) agentAtual.get("items");
						String facility = (String) agentAtual.get("facility");
						double lon = (double) agentAtual.get("lon");
						double lat = (double) agentAtual.get("lat");

						combo2Historico.add(name);
						int size = combo2Historico.size();
						if (size >= 2) {
							if (!combo2Historico.get(size - 1).equalsIgnoreCase(combo2Historico.get(size - 2))) {
								resetTable(model);
							}
						}
						
						model.addRow(new Object[] { chargeMax, charge, role, routeLength, lon, team, loadMax, speed,
								vision, route, load, lastAction, skill, name, items, facility, lat });
					}
				}
			}
		});

		comboBoxTblAgents3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) tableAgents3.getModel();
				Object agenteSelecionadoCombo3 = comboBoxTblAgents3.getSelectedItem();

				for (int i = 0; i < agents.size(); i++) {
					JSONObject agentAtual = (JSONObject) agents.get(i);
					if (agentAtual.get("name").equals(agenteSelecionadoCombo3)) {
						long chargeMax = (long) agentAtual.get("chargeMax");
						long charge = (long) agentAtual.get("charge");
						String role = (String) agentAtual.get("role");
						long routeLength = (long) agentAtual.get("routeLength");
						String team = (String) agentAtual.get("team");
						long loadMax = (long) agentAtual.get("loadMax");
						long speed = (long) agentAtual.get("speed");
						long vision = (long) agentAtual.get("vision");
						JSONArray route = (JSONArray) agentAtual.get("route");
						long load = (long) agentAtual.get("load");
						JSONObject lastAction = (JSONObject) agentAtual.get("lastAction");
						long skill = (long) agentAtual.get("skill");
						String name = (String) agentAtual.get("name");
						JSONArray items = (JSONArray) agentAtual.get("items");
						String facility = (String) agentAtual.get("facility");
						double lon = (double) agentAtual.get("lon");
						double lat = (double) agentAtual.get("lat");

						combo3Historico.add(name);
						int size = combo3Historico.size();
						if (size >= 2) {
							if (!combo3Historico.get(size - 1).equalsIgnoreCase(combo3Historico.get(size - 2))) {
								resetTable(model);
							}
						}
						
						model.addRow(new Object[] { chargeMax, charge, role, routeLength, lon, team, loadMax, speed,
								vision, route, load, lastAction, skill, name, items, facility, lat });
					}
				}
			}
		});

		DefaultTableModel model = (DefaultTableModel) tableAgents1.getModel();
		DefaultTableModel model2 = (DefaultTableModel) tableAgents2.getModel();
		DefaultTableModel model3 = (DefaultTableModel) tableAgents3.getModel();

		Object agenteSelecionadoCombo1 = comboBoxTblAgents1.getSelectedItem();
		Object agenteSelecionadoCombo2 = comboBoxTblAgents2.getSelectedItem();
		Object agenteSelecionadoCombo3 = comboBoxTblAgents3.getSelectedItem();

		for (int i = 0; i < agents.size(); i++) {

			JSONObject agentAtual = (JSONObject) agents.get(i);
			long chargeMax = (long) agentAtual.get("chargeMax");
			long charge = (long) agentAtual.get("charge");
			String role = (String) agentAtual.get("role");
			long routeLength = (long) agentAtual.get("routeLength");
			String team = (String) agentAtual.get("team");
			long loadMax = (long) agentAtual.get("loadMax");
			long speed = (long) agentAtual.get("speed");
			long vision = (long) agentAtual.get("vision");
			JSONArray route = (JSONArray) agentAtual.get("route");
			long load = (long) agentAtual.get("load");
			JSONObject lastAction = (JSONObject) agentAtual.get("lastAction");
			long skill = (long) agentAtual.get("skill");
			String name = (String) agentAtual.get("name");
			JSONArray items = (JSONArray) agentAtual.get("items");
			String facility = (String) agentAtual.get("facility");
			double lon = (double) agentAtual.get("lon");
			double lat = (double) agentAtual.get("lat");
			

			if (name.equals(agenteSelecionadoCombo1)) {
				combo1Historico.add(name);
				model.addRow(new Object[] { chargeMax, charge, role, routeLength, lon, team, loadMax, speed, vision,
						route, load, lastAction, skill, name, items, facility, lat });
			}

			if (name.equals(agenteSelecionadoCombo2)) {
				combo2Historico.add(name);
				model2.addRow(new Object[] { chargeMax, charge, role, routeLength, lon, team, loadMax, speed, vision,
						route, load, lastAction, skill, name, items, facility, lat });
			}

			if (name.equals(agenteSelecionadoCombo3)) {
				combo3Historico.add(name);
				model3.addRow(new Object[] { chargeMax, charge, role, routeLength, lon, team, loadMax, speed, vision,
						route, load, lastAction, skill, name, items, facility, lat });
			}

		}
	}
}
