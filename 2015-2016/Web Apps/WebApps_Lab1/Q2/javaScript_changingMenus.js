//***************************************************************//
// Web Apps Lab 1 Q2 JavaScript                                 //
// Author	   : Darren Cossgrave B00067349		               //
//                                                            //
// Date        : 18/9/2015                                   //
//                                                          //
// Linked file : Lab1Q2webApps.html             	       //
//													      //
// Description : JavaScript used for Q2, when the user   //
//				 changes the option to something else   //
//				 other than the defalt, it will        //
//               populate the city option with cites  //
//               of that country.                    //
//**************************************************//

window.onload = country;
function country()//Loads the script when the html file is loaded.
{
	document.getElementById("country").selectedIndex = 0;//sets the option to country on load.
	document.getElementById("country").onchange = city;//When the user changes the country index it calls the function city().
}

function city()//Used to populate the city option of the selected country.
{
	var city = this.options[this.selectedIndex].value;

	if (city==0)//if option = ireland.
	{
		var ireland = new Array("Dublin City","Galway City","Limerick City","Waterford City");//Array set for Ireland.
		var text = "<select>";
		document.getElementById("city").options.length = 0;//sets the options index to 0 so that it can make room for the new options of the selected country.
		for (var i = 0; i < ireland.length; i++)
		{
			document.getElementById("city").options[i] = new Option(i+1);//adds a space in the city options for that it can put in eg Dublin City in that spot.
			text += "<option>" + ireland[i] + "</option>";
		}
		text += "</select>";
	    document.getElementById("city").innerHTML = text;//prints text to the screen.
	}

	if (city==1)//if option = england.
	{
		var england = new Array("London City","Manchester City","Liverpool City","Newcastle City");
		var text = "<select>";
		document.getElementById("city").options.length = 0;
		for (var i = 0; i < england.length; i++)
		{
			document.getElementById("city").options[i] = new Option(i+1);
			text += "<option>" + england[i] + "</option>";
		}
		text += "</select>";
	    document.getElementById("city").innerHTML = text;
	}

	if (city==2)//if option = france.
	{
		var france = new Array("Paris City","Lyon City","Toulouse City","Nantes City");
		var text = "<select>";
		document.getElementById("city").options.length = 0;
		for (var i = 0; i < france.length; i++)
		{
			document.getElementById("city").options[i] = new Option(i+1);
			text += "<option>" + france[i] + "</option>";
		}
		text += "</select>";
	    document.getElementById("city").innerHTML = text;
	}

	if (city==3)//if option = germany.
	{
		var germany = new Array("Berlin City","Hamburg City","Nuremberg City","Leipzig City");
		var text = "<select>";
		document.getElementById("city").options.length = 0;
		for (var i = 0; i < germany.length; i++)
		{
			document.getElementById("city").options[i] = new Option(i+1);
			text += "<option>" + germany[i] + "</option>";
		}
		text += "</select>";
	    document.getElementById("city").innerHTML = text;
	}

	if(city=="")//Sets it back to defalt.
	{
		var text = "<select>";
		document.getElementById("city").options.length = 0;
		for (var i = 0; i < 1; i++)
		{
			document.getElementById("city").options[i] = new Option(i+1);
			text += "<option>City</option>";
		}
		text += "</select>";
	    document.getElementById("city").innerHTML = text;
	}
}