package lib.veroxar.panelist;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import lib.veroxar.panelist.pane.GenericPane;

public class ExamplePane extends GenericPane<Client> {

	private static final long serialVersionUID = 7199924470023282551L;
	private JScrollPane spPaneList;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public ExamplePane() {
		setLayout(new BorderLayout(0, 0));
		add(getSpPaneList(), BorderLayout.CENTER);

		JPanel pnButtons = new JPanel();
		add(pnButtons, BorderLayout.SOUTH);

		JButton btnAddPane = new JButton("Add Pane");
		btnAddPane.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JTable table = getTable();
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				Object[] row = { new ExamplePane() };
				model.addRow(row);
			}
		});
		pnButtons.add(btnAddPane);
	}

	@Override
	protected void updateData(JTable table, boolean isSelected) {
		
	}

	private JScrollPane getSpPaneList() {
		if (spPaneList == null) {
			spPaneList = new JScrollPane();
			spPaneList.setViewportView(getTable());
		}
		return spPaneList;
	}

	private JTable getTable() {
		if (table == null) {
			DefaultTableModel model = new DefaultTableModel() {

				private static final long serialVersionUID = -9022939128413482446L;

				@Override
				public Class<?> getColumnClass(int columnIndex) {
					return Client.class;
				}
			};
			model.addColumn("Panel List");
			GenericCellEditorRenderer<ExamplePane, Client> er = 
					new GenericCellEditorRenderer<ExamplePane, Client>(ExamplePane.class, Client.class);
			table = new JTable(model);
			table.setDefaultEditor(Client.class, editor);
			table.setFillsViewportHeight(true);
		}
		return table;
	}
}
