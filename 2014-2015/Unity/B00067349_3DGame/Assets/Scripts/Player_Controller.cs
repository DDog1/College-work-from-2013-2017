using UnityEngine;
using System.Collections;

public class Player_Controller : MonoBehaviour
{
	public float xMin, xMax, zMin, zMax;
	public float speed;
	public float tilt;
	
	void Update ()
	{
		float moveHorizontal = Input.GetAxis ("Horizontal");
		float moveVertical = Input.GetAxis ("Vertical");
		
		Vector3 movement = new Vector3 (moveHorizontal, 0.0f, moveVertical);
		rigidbody.velocity = movement * speed;
		
		rigidbody.position = new Vector3
		(
			Mathf.Clamp (rigidbody.position.x, xMin, xMax), 
			0.0f, 
			Mathf.Clamp (rigidbody.position.z, zMin, zMax)
		);
		
		rigidbody.rotation = Quaternion.Euler (0.0f, 0.0f, rigidbody.velocity.x * -tilt);
	}
}
