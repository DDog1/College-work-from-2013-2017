using UnityEngine;
using System.Collections;
using UnityEngine.UI;

public class User_Display : MonoBehaviour {

	public Text scoreText;
	public Text livesText;
	public Text hitText;
	public Image weaponImage;

	public Sprite weapon;
	public Sprite disabled;
	// default set
	public int life = 3;
	public int score = 0;
	public int hit = 30;

	// if death = true take 100 points off the players score
	private bool death = false;

	// used to get the right level to load
	public bool level1 = false;
	public bool level2 = false;
	public bool level3 = false;

	// killBoss will be passed to Boss_Death, if true kill boss
	public bool killBoss = false;
	public AudioClip boss;

	public void UpdateScoreText(int newScore){
		// will add 10 20 30 to score depending on if the player kills 
		// enemy type 1(10) or 2(20) or boss(30 per hit)
		score += newScore;
		// update new score
		string scoreMessage = "Score : " + score;
		scoreText.text = scoreMessage;

		// level 1 win if score = 500
		if(!level1 && score ==500){
			Application.LoadLevel("Level_1_Cleared");
		}

		// level 2 win if score = 500
		if(!level2 && score ==500){
			Application.LoadLevel("Level_2_Cleared");
		}

		// level 3 win if boss is dead
		if(!level3 && hit <= 0){
			Application.LoadLevel("Level_3_GameWon");
		}
	}

	public void UpdateLivesText(int newLives){
		// will take life if player get's shot at or if the player hit the enemy unit / boss
		life = life - newLives;
		// update new life 
		string livesMessage = "Life : " + life;
		livesText.text = livesMessage;
		death = true;

		// if death = true take 100 away from player's current score
		if(death == true){
			score-=100;
			string scoreMessage = "Score : " + score;
			scoreText.text = scoreMessage;
			death=false;
		}

		// if player's health = 0 load game over
		if(life == 0){
			Application.LoadLevel("Level_4_GameOver");
		}
	}

	public void UpdateBossText(int newHit)
	{
		// will take 1 hit away if player hits boss
		hit = hit - newHit;
		// update new hit
		string hitMessage = "Boss Life : " + hit;
		hitText.text = hitMessage;
		// if hit = 0 will send a kill command to Boss_Death
		if(hit <= 0){
			killBoss = true;
			audio.PlayOneShot(boss);
		}
	}

	public void UpdateLifeText()
	{
		// will add life if player hits health pick up
		life = life + 1;
		// update new life 
		string livesMessage = "Life : " + life;
		livesText.text = livesMessage;
	}
	public void UpdateImage(bool pickUp)
	{
		switch(pickUp)
		{
		case true:
			weaponImage.sprite = weapon;
			break;
		case false:
			weaponImage.sprite = disabled;
			break;
		}
	}
}