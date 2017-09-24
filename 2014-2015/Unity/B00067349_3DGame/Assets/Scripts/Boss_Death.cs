using UnityEngine;
using System.Collections;

public class Boss_Death : MonoBehaviour {

	private User_Display user_Display;

	void Start()
	{
		GameObject user_DisplayS = GameObject.FindWithTag("MainCamera");
		if(user_DisplayS != null)
		{
			user_Display = user_DisplayS.GetComponent<User_Display>();
		}
	}

	public void OnTriggerEnter(Collider hit)
	{
		// if killBoss = true kill boss 
		if(user_Display.killBoss==true)
		{
			Destroy(gameObject);
		}
	}
}