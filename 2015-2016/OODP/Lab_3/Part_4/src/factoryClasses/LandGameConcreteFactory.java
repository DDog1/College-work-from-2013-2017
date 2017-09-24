package factoryClasses;

import java.util.Random;

import gamePieces.Car;
import gamePieces.DamageItem;
import gamePieces.RoadBlock;
import gamePieces.Tank;
import gamePieces.Vehicle;

public class LandGameConcreteFactory extends BattleGameAbstractFactory{

	private Car car = new Car();
	private Tank tank = new Tank();
	private RoadBlock block = new RoadBlock();
	public Vehicle getBattleVehicle() {
		Random num = new Random();
		int rand = num.nextInt(2)+1;
		if(rand==1)
		{
			return car;
		}
		else{
			return tank;
		}
	}

	@Override
	public DamageItem getDamageItem() {
		// TODO Auto-generated method stub
		return block;
	}

}
