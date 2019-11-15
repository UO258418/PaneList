package lib.veroxar.panelist.pane;

import javax.swing.JTable;

public interface Updatable<Model> {

	void update(Model model, JTable table, boolean isSelected);
	
}
