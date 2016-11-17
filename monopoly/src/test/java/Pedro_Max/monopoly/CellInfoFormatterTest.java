package Pedro_Max.monopoly;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.monopoly.GoCell;
import edu.ncsu.monopoly.Player;
import edu.ncsu.monopoly.PropertyCell;
import edu.ncsu.monopoly.gui.GoCellInfoFormatter;
import edu.ncsu.monopoly.gui.InfoFormatter;
import junit.framework.TestCase;

public class CellInfoFormatterTest{
	@Test
    public void testGoCellTest() {
        GoCell cell = new GoCell();
        String goLabel = GoCellInfoFormatter.GO_CELL_LABEL;
        assertEquals(goLabel, InfoFormatter.cellInfo(cell));
    }
	@Test
    public void testPropertyCellText() {
        String propertyName = "Blue 1";
        String propertyColor = "blue";
        String ownerName = "Owner1";
        int numHouses = 2;
        int propertyValue = 120;
        String propertyLabel = "<html><b><font color='" +
				propertyColor +"'>" + propertyName + "</font></b><br>" +
				"$" + propertyValue +
				"<br>Owner: " + ownerName +
				"<br>* " + numHouses +
				"</html>";
        PropertyCell cell = new PropertyCell();
        cell.setName(propertyName);
        cell.setPrice(propertyValue);
        cell.setColorGroup(propertyColor);
        Player p = new Player();
        p.setName(ownerName);
        cell.setOwner(p);
        cell.setNumHouses(numHouses);
        assertEquals(propertyLabel, InfoFormatter.cellInfo(cell));
    }
}
