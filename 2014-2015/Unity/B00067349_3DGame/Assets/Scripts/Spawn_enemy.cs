using UnityEngine;
using System.Collections;

public class Spawn_enemy : MonoBehaviour {

	public Rigidbody enemyPrefab;
	public float numberOfEmemys;
	public float nextSpawnTime;
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
			for(int i=0;i<numberOfEmemys;i++)
			{
				// picks a random spot to spawn an enemy at 1 to 5
				int spawnLocation = UnityEngine.Random.Range(1,6);

				// enemy spawns at 1 of the 5 locations and changes the 
				// rotation to -180 so it faces the player
				// and gives some time till next spawn
				if(spawnLocation == 1)
				{
					Vector3 spawnPosition = new Vector3 (10, 0, 50);
					Quaternion spawnRotation = new Quaternion (0, -180, 0, 0);
					Instantiate(enemyPrefab, spawnPosition, spawnRotation);
					//nextSpawnTime *= Time.deltaTime + nextSpawnTime;
					yield return new WaitForSeconds (nextSpawnTime);
				}

				else if(spawnLocation == 2)
				{
					Vector3 spawnPosition = new Vector3 (5, 0, 50);
					Quaternion spawnRotation = new Quaternion (0, -180, 0, 0);
					Instantiate(enemyPrefab, spawnPosition, spawnRotation);
					yield return new WaitForSeconds (nextSpawnTime);
				}

				else if(spawnLocation == 3)
				{
					Vector3 spawnPosition = new Vector3 (0, 0, 50);
					Quaternion spawnRotation = new Quaternion (0, -180, 0, 0);
					Instantiate(enemyPrefab, spawnPosition, spawnRotation);
					yield return new WaitForSeconds (nextSpawnTime);
				}

				else if(spawnLocation == 4)
				{
					Vector3 spawnPosition = new Vector3 (-5, 0, 50);
					Quaternion spawnRotation = new Quaternion (0, -180, 0, 0);
					Instantiate(enemyPrefab, spawnPosition, spawnRotation);
					yield return new WaitForSeconds (nextSpawnTime);
				}

				else if(spawnLocation == 5)
				{
					Vector3 spawnPosition = new Vector3 (-10, 0, 50);
					Quaternion spawnRotation = new Quaternion (0, -180, 0, 0);
					Instantiate(enemyPrefab, spawnPosition, spawnRotation);
					yield return new WaitForSeconds (nextSpawnTime);
				}
			}	
			// after it spawns the enemies, it waits to start the next wave
			yield return new WaitForSeconds (waveWait);
		}
	}
}
