using UnityEngine;
using System.Collections;

public class Boss_Fire : MonoBehaviour {

	// shortest time between firing another projectile
	public const float FIRE_DELAY = 2f;
	
	// ref to prefab of object to be 'fired'
	public Rigidbody projectilePrefab;
	
	// change size of force (speed) given to projectile
	public float projectileSpeed = 200f;
	
	// value Time.time must reach before next projectile can be fired
	private float nextFireTime = 1f;
	
	//--------------------------------
	// every frame check if fire key pressed (if past time to fire next projectile)
	void Update() 
	{
		if (Time.time > nextFireTime){
			CheckFireKey ();
		}
	}	
	
	//-----------------------------------
	// if fire pressed create projectile and update time for next time allowed to fire
	private void CheckFireKey() 
	{
		float z = transform.position.z;
		// fire when gameObject is past 20 
		if(z<20)
		{
			CreateProjectile();
			//audio.Play();
		}	
		// ensure a delay before next projectile can be fired
		nextFireTime = Time.time + FIRE_DELAY;
	}
	
	private void CreateProjectile() 
	{
		Vector3 position = transform.position;
		Quaternion rotation = transform.rotation;
		Rigidbody projectileRigidBody = (Rigidbody)Instantiate(projectilePrefab, position, rotation);
		
		// create and apply velocity 
		// use TransformDirection() so direction is relative to current direction spawner is facing
		Vector3 projectileVelocity = transform.TransformDirection(Vector3.forward * projectileSpeed);
		projectileRigidBody.AddForce(projectileVelocity);
		
		// destroy object after 5 seconds ...
		GameObject projectileGO = projectileRigidBody.gameObject;
		Destroy(projectileGO, 5f);
	}   	
}