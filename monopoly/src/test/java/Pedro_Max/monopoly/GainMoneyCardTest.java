package Pedro_Max.monopoly;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.monopoly.Card;
import edu.ncsu.monopoly.GameBoardCCGainMoney;
import edu.ncsu.monopoly.GameMaster;
import edu.ncsu.monopoly.MockGUI;
import edu.ncsu.monopoly.MoneyCard;

public class GainMoneyCardTest {
    Card gainMoneyCard;
    GameMaster gameMaster;
    @Before
    public void setUp() {
		gameMaster = GameMaster.instance();
		gameMaster.setGameBoard(new GameBoardCCGainMoney());
		gameMaster.setNumberOfPlayers(1);
		gameMaster.reset();
		gameMaster.setGUI(new MockGUI());
		gainMoneyCard = new MoneyCard("Get 50 dollars", 50, Card.TYPE_CC);
		gameMaster.getGameBoard().addCard(gainMoneyCard);
    }
    @Test
    public void testGainMoneyCardAction() {
        int origMoney = gameMaster.getCurrentPlayer().getMoney();
		Card card = gameMaster.drawCCCard();
		assertEquals(gainMoneyCard, card);
		card.applyAction();
		assertEquals(origMoney + 50, gameMaster.getCurrentPlayer().getMoney());
    }
    @Test
    public void testGainMoneyCardUI() {
        gameMaster.movePlayer(0, 1);
        assertTrue(gameMaster.getGUI().isDrawCardButtonEnabled());
        assertFalse(gameMaster.getGUI().isEndTurnButtonEnabled());
        gameMaster.btnDrawCardClicked();
        assertFalse(gameMaster.getGUI().isDrawCardButtonEnabled());
		assertTrue(gameMaster.getGUI().isEndTurnButtonEnabled());
    }
}
