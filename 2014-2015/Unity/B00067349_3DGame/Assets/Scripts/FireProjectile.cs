using UnityEngine;
using System.Collections;

public class FireProjectile : MonoBehaviour 
{
	private User_Display user_Display;
	// shortest time between firing another projectile
	public float FIRE_DELAY = 1f;
	private float copyOfFire_Delay;
	// used if the player hits the weapon pick up
	public const float speed = 0.25f;
	private bool upgrade = false;
	// ref to prefab of object to be 'fired'
	public Rigidbody projectilePrefab;

	// change size of force (speed) given to projectile
	public float projectileSpeed = 500f;

	// value Time.time must reach before next projectile can be fired
	private float nextFireTime = 2f;
	private float changeBack = 10f;
	public void weaponSpeed()
	{
		copyOfFire_Delay = FIRE_DELAY;
		upgrade = true;
	}
	void Start()
	{
		GameObject user_DisplayS = GameObject.FindWithTag("MainCamera");
		if(user_DisplayS != null)
		{
			user_Display = user_DisplayS.GetComponent<User_Display>();
		}
	}
	//--------------------------------
	// every frame check if fire key pressed (if past time to fire next projectile)
	void Update() 
	{
		// upgrade is used when the player picks up a weapon boost. Only lasts 10 seconds
		if(upgrade==true){
			FIRE_DELAY = speed;
			changeBack -= Time.deltaTime;
			print (changeBack);
			user_Display.UpdateImage(upgrade);
			// after 10 seconds it goes back to normal fire rate
			if(changeBack <= 0.0f){
				upgrade = false;
				FIRE_DELAY = copyOfFire_Delay;
				// puts the time back to 10 seconds for the next pick up
				changeBack = 10f;
				user_Display.UpdateImage(upgrade);
			}
		}
		if( Time.time > nextFireTime ){
			CheckFireKey();
		}
	}	

	//-----------------------------------
	// if fire pressed create projectile and update time for next time allowed to fire
	private void CheckFireKey() 
	{
		if( Input.GetButton("Fire1")) 
		{
			CreateProjectile();
			audio.Play ();
			
			// ensure a delay before next projectile can be fired
			nextFireTime = Time.time + FIRE_DELAY;
		}
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
