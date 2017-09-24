//***************************************************************//
// Web Apps Lab 1 Q1 JavaScript                                 //
// Author	   : Darren Cossgrave B00067349		               //
//                                                            //
// Date        : 18/9/2015                                   //
//                                                          //
// Linked file : Lab1Q1webApps.html             	       //
//													      //
// Description : JavaScript used for Q1, when the user   //
//				 clicks the link below it will randomise//
//				 the numbers                           //
//****************************************************//

window.onload = randomN;//Onload it will call randomN to populate the bingo card.

function randomN()//Will be used to randomise the bingo card each time the link is clicked
{
	for(var i = 0; i < 20; i++)
	{
		var currentNum = "lotto"+i;
		var newNum = Math.floor(Math.random() * 75) + 1;
		document.getElementById(currentNum).innerHTML = newNum;
	}
}