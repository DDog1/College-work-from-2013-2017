using UnityEngine;
using System.Collections;

public class PickUp_Spawn_Health : MonoBehaviour {
	
	public Rigidbody health;
	public float numberOfHealth;
	public float nextHealthTime;
	public float startWait;
	public float waveWait;
	
	void Start()
	{
		StartCoroutine(Spawn ());
	}
	
	IEnumerator Spawn()
	{
		// waits to start the waves
		yield return new WaitForSeconds (startWait);
		
		while(true)
		{
			for(int i=0;i<numberOfHealth;i++)
			{
				// picks a random spot to spawn an enemy at 1 to 5
				int spawnLocation = UnityEngine.Random.Range(1,6);
				
				// health spawns at 1 of the 5 locations and changes the 
				// rotation to -180 so it faces the player
				// and gives some time till next spawn
				if(spawnLocation == 1)
				{
					Vector3 spawnPosition = new Vector3 (10, 0, 50);
					Quaternion spawnRotation = new Quaternion (0, -180, 0, 0);
					Instantiate(health, spawnPosition, spawnRotation);
					//nextSpawnTime *= Time.deltaTime + nextSpawnTime;
					yield return new WaitForSeconds (nextHealthTime);
				}
				
				else if(spawnLocation == 2)
				{
					Vector3 spawnPosition = new Vector3 (5, 0, 50);
					Quaternion spawnRotation = new Quaternion (0, -180, 0, 0);
					Instantiate(health, spawnPosition, spawnRotation);
					yield return new WaitForSeconds (nextHealthTime);
				}
				
				else if(spawnLocation == 3)
				{
					Vector3 spawnPosition = new Vector3 (0, 0, 50);
					Quaternion spawnRotation = new Quaternion (0, -180, 0, 0);
					Instantiate(health, spawnPosition, spawnRotation);
					yield return new WaitForSeconds (nextHealthTime);
				}
				
				else if(spawnLocation == 4)
				{
					Vector3 spawnPosition = new Vector3 (-5, 0, 50);
					Quaternion spawnRotation = new Quaternion (0, -180, 0, 0);
					Instantiate(health, spawnPosition, spawnRotation);
					yield return new WaitForSeconds (nextHealthTime);
				}
				
				else if(spawnLocation == 5)
				{
					Vector3 spawnPosition = new Vector3 (-10, 0, 50);
					Quaternion spawnRotation = new Quaternion (0, -180, 0, 0);
					Instantiate(health, spawnPosition, spawnRotation);
					yield return new WaitForSeconds (nextHealthTime);
				}
			}	
			// after it spawns the health, it waits to start the next wave
			yield return new WaitForSeconds (waveWait);
		}
	}
}