package replayReader;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JFileChooser;

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
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.table.DefaultTableModel;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import java.awt.Color;

public class reader {

	private JFrame frame;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;
	private JTable table_4;
	private JTable table_5;
	private JTable table_6;
	private JTable table_7;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the application.
	 */
	public reader() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 945, 734);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.getContentPane().setLayout(null);
		
				JLabel lblTitle = new JLabel("Replay Reader");
				lblTitle.setBounds(0, 0, 922, 54);
				lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
				lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 24));
				frame.getContentPane().add(lblTitle);
		
				JButton btnImportarJson = new JButton("Importar JSON");
				btnImportarJson.setBounds(0, 653, 922, 31);
				btnImportarJson.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						JFileChooser fileChooser = new JFileChooser();
						int returnValue = fileChooser.showOpenDialog(null);
						if (returnValue == JFileChooser.APPROVE_OPTION) {
							File selectedFile = fileChooser.getSelectedFile();
							readJSON(selectedFile);
						}
					}
				});
				
				JSlider slider = new JSlider();
				slider.setValue(0);
				slider.setBounds(0, 49, 922, 39);
				slider.setMinorTickSpacing(20);
				slider.setPaintTicks(true);
				frame.getContentPane().add(slider);

				frame.getContentPane().add(btnImportarJson);
				
				JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
				tabbedPane.setBounds(0, 92, 922, 550);
				frame.getContentPane().add(tabbedPane);
				
				JPanel panel = new JPanel();
				tabbedPane.addTab("Storages", null, panel, null);
				tabbedPane.setEnabledAt(0, true);
				panel.setLayout(null);
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(10, 11, 897, 500);
				panel.add(scrollPane);
				
				table = new JTable();
				table.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"Used Capacity", "Total Capacity", "Stored Items", "Name", "All Stored Items", "Lon", "Lat"
					}
				));
				scrollPane.setViewportView(table);
				
				JPanel panel_1 = new JPanel();
				tabbedPane.addTab("Resource Nodes", null, panel_1, null);
				panel_1.setLayout(null);
				
				JScrollPane scrollPane_1 = new JScrollPane();
				scrollPane_1.setBounds(10, 11, 897, 500);
				panel_1.add(scrollPane_1);
				
				table_1 = new JTable();
				table_1.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"Resource", "Name", "Lon", "Lat"
					}
				));
				scrollPane_1.setViewportView(table_1);
				
				JPanel panel_2 = new JPanel();
				tabbedPane.addTab("Teams", null, panel_2, null);
				panel_2.setLayout(null);
				
				JScrollPane scrollPane_2 = new JScrollPane();
				scrollPane_2.setBounds(10, 5, 897, 506);
				panel_2.add(scrollPane_2);
				
				table_2 = new JTable();
				table_2.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"Score", "Name", "Massium"
					}
				));
				scrollPane_2.setViewportView(table_2);
				
				JPanel panel_3 = new JPanel();
				tabbedPane.addTab("Jobs", null, panel_3, null);
				panel_3.setLayout(null);
				
				JScrollPane scrollPane_3 = new JScrollPane();
				scrollPane_3.setBounds(10, 5, 897, 506);
				panel_3.add(scrollPane_3);
				
				table_3 = new JTable();
				table_3.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"Reward", "Delivered Items", "Start", "End", "Id", "Storage", "Poster", "Required Items"
					}
				));
				scrollPane_3.setViewportView(table_3);
				
				JPanel panel_6 = new JPanel();
				tabbedPane.addTab("Dumps", null, panel_6, null);
				panel_6.setLayout(null);
				
				JScrollPane scrollPane_4 = new JScrollPane();
				scrollPane_4.setBounds(10, 5, 897, 506);
				panel_6.add(scrollPane_4);
				
				table_4 = new JTable();
				table_4.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"Name", "Lon", "Lat"
					}
				));
				scrollPane_4.setViewportView(table_4);
				
				JPanel panel_7 = new JPanel();
				tabbedPane.addTab("Workshops", null, panel_7, null);
				panel_7.setLayout(null);
				
				JScrollPane scrollPane_5 = new JScrollPane();
				scrollPane_5.setBounds(10, 5, 897, 506);
				panel_7.add(scrollPane_5);
				
				table_5 = new JTable();
				table_5.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"Name", "Lon", "Lat"
					}
				));
				scrollPane_5.setViewportView(table_5);
				
				JPanel panel_4 = new JPanel();
				panel_4.setLayout(null);
				tabbedPane.addTab("Shops", null, panel_4, null);
				
				JScrollPane scrollPane_6 = new JScrollPane();
				scrollPane_6.setBounds(10, 5, 897, 506);
				panel_4.add(scrollPane_6);
				
				table_6 = new JTable();
				table_6.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"Name", "Lon", "Lat"
					}
				));
				scrollPane_6.setViewportView(table_6);
				
				JPanel panel_8 = new JPanel();
				tabbedPane.addTab("Wells", null, panel_8, null);
				panel_8.setLayout(null);
				
				JPanel panel_5 = new JPanel();
				panel_5.setLayout(null);
				tabbedPane.addTab("Charging Stations", null, panel_5, null);
				
				JScrollPane scrollPane_7 = new JScrollPane();
				scrollPane_7.setBounds(10, 5, 897, 506);
				panel_5.add(scrollPane_7);
				
				table_7 = new JTable();
				table_7.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"Rate", "Name", "Lon", "Late"
					}
				));
				scrollPane_7.setViewportView(table_7);
				frame.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblTitle, slider, tabbedPane, panel, panel_1, panel_2, panel_3, panel_6, panel_7, panel_8, btnImportarJson}));
	}

	public void readJSON(File file) {
		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(new FileReader(file));
			JSONObject jsonObject = (JSONObject) obj;
			JSONObject step = (JSONObject) jsonObject.get("0");
			JSONArray storages = (JSONArray) step.get("storages");

			for (int i = 0; i < storages.size(); i++) {
				JSONObject storageAtual = (JSONObject) storages.get(i);
				long usedCapacity = (long) storageAtual.get("usedCapacity");
				long totalCapacity = (long) storageAtual.get("totalCapacity");
				JSONArray storedItems = (JSONArray) storageAtual.get("storedItems");
				String name = (String) storageAtual.get("name");
				JSONArray allStoredItems = (JSONArray) storageAtual.get("allStoredItems");
				double lon = (double) storageAtual.get("lon");
				double lat = (double) storageAtual.get("lat");
				System.out.println("Used Capacity:" + usedCapacity);
				System.out.println("Total Capacity:" + totalCapacity);
				System.out.println("storedItens:" + storedItems);
				System.out.println("name:" + name);
				System.out.println("allStoredItems:" + allStoredItems);
				System.out.println("lon:" + lon);
				System.out.println("lat:" + lat);
				System.out.println("-------------------------------------------");
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
}
