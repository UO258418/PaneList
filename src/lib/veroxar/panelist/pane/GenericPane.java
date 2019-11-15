package lib.veroxar.panelist.pane;

import javax.swing.JPanel;
import javax.swing.JTable;

public abstract class GenericPane<Model> extends JPanel implements Updatable<Model> {
	
	private static final long serialVersionUID = 7166647464075984314L;
	protected Model model;

	@Override
	public void update(Model model, JTable table, boolean isSelected) {
		this.model = model;
		updateData(table, isSelected);
		
	}
	
	protected abstract void updateData(JTable table, boolean isSelected);

}
