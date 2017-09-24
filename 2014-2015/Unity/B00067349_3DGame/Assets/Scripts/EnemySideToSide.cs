using UnityEngine;
using System.Collections;

public class EnemySideToSide : MonoBehaviour {
	
	public float xMovementPerSecond = 1f;

	public float maxX;
	public float minX;
	private bool movingSideToSide = false;

	void Update(){
		CheckLimits();
		MovingSideToSide(movingSideToSide);
	}
	
	void MovingSideToSide(bool no){
		// dx is small amount of change to X position
		float dx = xMovementPerSecond;

		// if no = true
		if(!no){
			dx = -xMovementPerSecond;
		}
		
		// reduce DX based on fraction of a second since last frame
		dx *= Time.deltaTime;

		// move enemy by DX
		transform.Translate(dx,0,0);
	}
	
	void CheckLimits(){
		float x = transform.position.x;
		// toggle motion if past top / bottom limit
		if(movingSideToSide == false && x > maxX){
			movingSideToSide = true;
			MovingSideToSide(movingSideToSide);
		} 
		else if(x < minX){
			movingSideToSide = false;
			MovingSideToSide(movingSideToSide);
		}
	}
	
}