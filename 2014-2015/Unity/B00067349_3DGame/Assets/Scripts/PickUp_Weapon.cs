using UnityEngine;
using System.Collections;

public class PickUp_Weapon : MonoBehaviour {
	
	private FireProjectile fireProjectile;
	void Start()
	{
		GameObject fireProjectileS = GameObject.FindWithTag("Player");
		if(fireProjectileS != null)
		{
			fireProjectile = fireProjectileS.GetComponent<FireProjectile>();
		}
	}
	
	void OnTriggerEnter(Collider hit)
	{
		if (hit.gameObject.tag ==("Player")) 
		{
			fireProjectile.weaponSpeed();
			Destroy (gameObject);
		}
	}
}
