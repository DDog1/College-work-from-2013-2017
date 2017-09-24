using UnityEngine;
using System.Collections;

public class ButtonActions : MonoBehaviour {

	//Loads when the player get to the win or the lose scene
	public void BUTTON_LOAD_0_Home(){
		Application.LoadLevel("Level_0_Welcome");
	}

	//Loads after the player hit the play button
	public void BUTTON_LOAD_0_INSTRUCTIONS(){
		Application.LoadLevel("Level_0_Instructions");
	}

	//Loads the clear if the player win the level
	public void BUTTON_LOAD_1_CLEARED(){
		Application.LoadLevel("Level_1_Cleared");
	}

	public void BUTTON_LOAD_2_CLEARED(){
		Application.LoadLevel("Level_2_Cleared");
	}

	//Loads the next level when the player hits the button
	public void BUTTON_LOAD_LEVEL1(){
		Application.LoadLevel("Level_1");
	}

	public void BUTTON_LOAD_LEVEL2(){
		Application.LoadLevel("Level_2");
	}

	public void BUTTON_LOAD_LEVEL3(){
		Application.LoadLevel("Level_3");
	}
}

