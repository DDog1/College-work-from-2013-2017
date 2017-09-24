package factoryClasses;

import java.util.Random;

import gamePieces.Boat;
import gamePieces.DamageItem;
import gamePieces.SeaMine;
import gamePieces.Submarine;
import gamePieces.Vehicle;

public class SeaGameConcreteFactory extends BattleGameAbstractFactory {

	private Boat boat = new Boat();
	private Submarine sub = new Submarine();
	private SeaMine mine = new SeaMine();
	public Vehicle getBattleVehicle() {
		Random num = new Random();
		int rand = num.nextInt(2)+1;
		if(rand==1)
		{
			return boat;
		}
		else{
			return sub;
		}
	}

	@Override
	public DamageItem getDamageItem() {
		// TODO Auto-generated method stub
		return mine;
	}

}
