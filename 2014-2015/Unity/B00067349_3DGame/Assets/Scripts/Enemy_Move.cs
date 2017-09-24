using UnityEngine;
using System.Collections;

public class Enemy_Move : MonoBehaviour {

	public float zMovementPerSecond = 1f;
	
	public float minZ;
	
	void Update(){
		MoveEnemy();
	}
	
	void MoveEnemy(){
		// dz is small amount to change Z position
		float dz = +zMovementPerSecond;
		// z current position
		float z = transform.position.z;
		
		// reduce DZ based on fraction of a second since last frame
		dz *= Time.deltaTime;
		
		// move platfor by DZ
		transform.Translate(0,0,dz);

		// if the enemy goes beyond this point destroy 
		if(z < minZ){
			Destroy (gameObject);
		}
	}
}
