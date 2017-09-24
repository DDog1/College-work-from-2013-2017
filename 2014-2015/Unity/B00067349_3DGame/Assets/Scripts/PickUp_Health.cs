using UnityEngine;
using System.Collections;

public class PickUp_Health : MonoBehaviour {

	private User_Display user_Display;

	void Start()
	{
		GameObject user_DisplayS = GameObject.FindWithTag("MainCamera");
		if(user_DisplayS != null)
		{
			user_Display = user_DisplayS.GetComponent<User_Display>();
		}
	}

	void OnTriggerEnter(Collider hit)
	{
		if (hit.gameObject.tag ==("Player")) 
		{
			user_Display.UpdateLifeText();
			Destroy (gameObject);
		}
	}
}
