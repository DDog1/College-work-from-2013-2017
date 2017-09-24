using UnityEngine;
using System.Collections;

public class Player_Destroy_target : MonoBehaviour {

	private User_Display user_Display;
	private int score = 10;
	private int point = 20;
	private int boss = 30;

	void Start()
	{
		GameObject user_DisplayS = GameObject.FindWithTag("MainCamera");
		if(user_DisplayS != null)
		{
			user_Display = user_DisplayS.GetComponent<User_Display>();
		}
	}

	IEnumerator OnTriggerEnter(Collider hit)
	{
		if (hit.gameObject.tag ==("Enemy")) 
		{
			user_Display.UpdateScoreText(score);
			Destroy (hit.gameObject);
			audio.Play ();
			yield return new WaitForSeconds (1);
			Destroy (gameObject);
		}

		if (hit.gameObject.tag ==("Elite")) 
		{
			user_Display.UpdateScoreText(point);
			Destroy (hit.gameObject);
			audio.Play ();
			yield return new WaitForSeconds (1);
			Destroy (gameObject);
		}

		if (hit.gameObject.tag ==("Boss")) 
		{
			user_Display.UpdateScoreText(boss);
			user_Display.UpdateBossText(1);

			audio.Play ();
			yield return new WaitForSeconds (1);
			Destroy (gameObject);
		}
	}
}