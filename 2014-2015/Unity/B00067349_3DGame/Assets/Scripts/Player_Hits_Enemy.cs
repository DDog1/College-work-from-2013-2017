using UnityEngine;
using System.Collections;

public class Player_Hits_Enemy : MonoBehaviour {

	public AudioClip enemy;
	public AudioClip player;
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
		if (hit.gameObject.tag ==("Enemy")) 
		{
			user_Display.UpdateLivesText(life);
			audio.PlayOneShot(enemy);
			audio.PlayOneShot(player);
			Destroy (hit.gameObject);

			Vector3 spawnPosition = new Vector3 (0, 0, -5);
			transform.position = spawnPosition;
		}

		if (hit.gameObject.tag ==("Elite")) 
		{
			user_Display.UpdateLivesText(life);
			audio.PlayOneShot(enemy);
			audio.PlayOneShot(player);
			Destroy (hit.gameObject);

			Vector3 spawnPosition = new Vector3 (0, 0, -5);
			transform.position = spawnPosition;
		}

		if (hit.gameObject.tag ==("Boss")) 
		{
			user_Display.UpdateLivesText(life);
			audio.PlayOneShot(enemy);
			audio.PlayOneShot(player);
			
			Vector3 spawnPosition = new Vector3 (0, 0, -5);
			transform.position = spawnPosition;
		}

	}
}
