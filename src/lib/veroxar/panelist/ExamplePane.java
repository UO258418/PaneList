package lib.veroxar.panelist;

import javax.swing.JTable;

import lib.veroxar.panelist.pane.GenericPane;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;

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
	}

	@Override
	protected void updateData(JTable table, boolean isSelected) {
		// TODO Auto-generated method stub
		
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
			table = new JTable();
			table.setFillsViewportHeight(true);
		}
		return table;
	}
}
