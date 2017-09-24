using UnityEngine;
using System.Collections;

public class Boss_Move : MonoBehaviour {
	
	public float zMovementPerSecond = 1f;

	void Update(){
		// z current position
		float z = transform.position.z;
		// stop boss when it hits the 10 mark on the z position
		if(z>10){
			MoveBoss();
		}
	}
	
	void MoveBoss(){
		// dz is small amount to change Z position
		float dz = +zMovementPerSecond;
		
		// reduce DZ based on fraction of a second since last frame
		dz *= Time.deltaTime;
		
		// move platfor by DZ
		transform.Translate(0,0,dz);
	}
}