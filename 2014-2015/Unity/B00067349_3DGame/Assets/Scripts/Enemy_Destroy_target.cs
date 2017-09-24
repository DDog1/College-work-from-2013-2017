using UnityEngine;
using System.Collections;

public class Enemy_Destroy_target : MonoBehaviour {

	private User_Display user_Display;
	public int life = 1;
	public Rigidbody playerPrefab;

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
			user_Display.UpdateLivesText(life);
			Destroy (hit.gameObject);
			audio.Play ();

			Vector3 spawnPosition = new Vector3 (0, 0, -5);
			transform.position = spawnPosition;
		}
	}
}
