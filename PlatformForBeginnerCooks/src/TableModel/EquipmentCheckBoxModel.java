package TableModel;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import controller.Chosen.ChosenEquipment;
import model.Equipment;

public class EquipmentCheckBoxModel extends AbstractTableModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String[] columns = {"id", "Equipment", "Company", ""};
	
	private Object[][] allEquipment;
	
	

	public EquipmentCheckBoxModel(ArrayList<Equipment> eqs) {
		super();
		allEquipment = new Object[eqs.size()][4];
		int i = 0;
		for (Equipment e : eqs) {
			allEquipment[i][0] = e.getEquipmentID();
			allEquipment[i][1] = e.getName();
			allEquipment[i][2] = e.getCompany();
			if(ChosenEquipment.getChosenEqs() == null || ChosenEquipment.getChosenEqs().isEmpty()) {
				allEquipment[i][3] = false;
			}
			else {
				if(ChosenEquipment.getChosenEqs() .contains(e.getEquipmentID())) {
					allEquipment[i][3] = true;
				}else
					allEquipment[i][3] = false;
			}
			i++;
		}
	}

	
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columns.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return allEquipment.length;
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return allEquipment[arg0][arg1];
	}
	
	public Class<?> getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
	
	public boolean isCellEditable(int row, int col) {
		if (col != 3) {
			return false;
		} else {
			return true;
		}
	}

	public String[] getColumns() {
		return columns;
	}

	public void setColumns(String[] columns) {
		this.columns = columns;
	}

	public String getColumnName(int col) {
		return this.columns[col];
	}

	public void setValueAt(Object value, int row, int col) {
		allEquipment[row][col] = value;
		fireTableCellUpdated(row, col);
	}

}
