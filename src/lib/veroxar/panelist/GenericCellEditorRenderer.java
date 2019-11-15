package lib.veroxar.panelist;

import java.awt.Component;

import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import lib.veroxar.panelist.pane.GenericPane;

public class GenericCellEditorRenderer<Pane extends GenericPane<Model>, Model> extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {

	private static final long serialVersionUID = 3271124504045108080L;

	// save model class
	Class<Model> modelClass;
	
	// custom panel
	Pane pane;
	
	public GenericCellEditorRenderer(Class<Pane> paneClass, Class<Model> modelClass) {
		try {
			pane = paneClass.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		this.modelClass = modelClass;
	}
	
	@Override
	public Object getCellEditorValue() {
		return null;
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		
		Model model = castInstanceOfObject(value);
		pane.update(model, table, isSelected);
		return pane;
		
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		
		Model model = castInstanceOfObject(value);
		pane.update(model, table, isSelected);
		return pane;
		
	}
	
	private Model castInstanceOfObject(Object obj) {
		return modelClass.cast(obj);
	}

}
