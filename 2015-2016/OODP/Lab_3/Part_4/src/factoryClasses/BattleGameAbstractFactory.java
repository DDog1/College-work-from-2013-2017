package factoryClasses;

import gamePieces.DamageItem;
import gamePieces.Vehicle;

public abstract class BattleGameAbstractFactory {

	public abstract Vehicle getBattleVehicle();

	public abstract DamageItem getDamageItem();

}
