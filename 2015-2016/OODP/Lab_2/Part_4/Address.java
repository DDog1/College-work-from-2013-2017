import java.awt.*;
import javax.swing.*;

public abstract class Address
{
	protected JPanel IrelandAddress;
	protected JPanel USAAddress;

	Address() {

	}

	public JPanel getIrelandAddress()
	{
	return IrelandAddress;
	}
	public JPanel getUSAAddress()
	{
	return USAAddress;
	}
}