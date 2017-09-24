public class AddressFactory
{
	public Address getAddress(String addressType)
	{
		if(addressType.equals("Ireland"))
		{
			return new IrelandAddress();
		}
		else if(addressType.equals("America"))
		{
			return new USAAddress();
		}
		else
		{
			return null;
		}
	}

	public IrelandAddress getIrelandAddress()
	{
		return new IrelandAddress();
	}

	public USAAddress getUSAAddress()
	{
		return new USAAddress();
	}
}