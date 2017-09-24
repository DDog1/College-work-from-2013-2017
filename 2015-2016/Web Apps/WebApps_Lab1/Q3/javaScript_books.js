//*************************************************************//
// Web Apps Lab 1 Q3 JavaScript                               //
// Author	   : Darren Cossgrave B00067349		             //
//                                                          //
// Date        : 18/9/2015                                 //
//                                                        //
// Linked file : Lab1Q3webApps.html             	     //
//													    //
// Description : JavaScript used for Q3, opens window  //
//				 when the user clicks the image once  //
//				 on the html file listed above.      //
//**************************************************//


function picA()//Function for Image one, only gets called onclick.
{	var objwin;//Object value used for the window.
	objwin = window.open("", "", "height=580, width=400, top=50, left=50");//Sets the width height and the position on the screen.
	objwin.document.write("<title>The Hunger Games</title>");//Sets the title of the window that pops up.
	objwin.document.write("<center>");//Puts all the contents in the center of the window.
	objwin.document.write("<h1>The Hunger Games</h1>");//Line 18-20 sets the heading image and gives a discription of the book.
	objwin.document.write("<img src='images/image_1.jpe' alt='Hunger Games' style='width:195px;height:228px;'>" );
	objwin.document.write("<p>Set in a dark vision of the near future, a terrifying reality TV show is taking place. Twelve boys and twelve girls are forced to appear in a live event called The Hunger Games. There is only one rule: kill or be killed. When sixteen-year-old Katniss Everdeen steps forward to take her younger sister's place in the games, she sees it as a death sentence. But Katniss has been close to death before. For her, survival is second nature.</p>");
	objwin.document.write("</center>");
}
function picB()
{	var objwin;
	objwin = window.open("", "", "height=580, width=400, top=50, left=50");
	objwin.document.write("<title>Harry Potter and the philosopher's stone</title>");
	objwin.document.write("<center>");
	objwin.document.write("<h1>Harry Potter and the philosopher's stone</h1>");
	objwin.document.write("<img src='images/image_2.jpg' alt='Harry Potter' style='width:206px;height:228px;'>" );
	objwin.document.write("<p>Harry Potter is an ordinary boy who lives in a cupboard under the stairs at his Aunt Petunia and Uncle Vernon's house, which he thinks is normal for someone like him who's parents have been killed in a 'car crash'. He is bullied by them and his fat, spoilt cousin Dudley, and lives a very unremarkable life with only the odd hiccup to cause him much to think about. That is until an owl turns up with a letter addressed to Harry and all hell breaks loose! He is literally rescued by a world where nothing is as it seems and magic lessons are the order of the day. Read and find out how Harry discovers his true heritage at Hogwarts School of Wizardry and Witchcraft.</p>");
	objwin.document.write("</center>");
}
function picC()
{	var objwin;
	objwin = window.open("", "", "height=580, width=400, top=50, left=50");
	objwin.document.write("<title>The Lord of The Rings</title>");
	objwin.document.write("<center>");
	objwin.document.write("<h1>The Lord of The Rings</h1>");
	objwin.document.write("<img src='images/image_3.jpe' alt='Hunger Games' style='width:198px;height:228px;'>" );
	objwin.document.write("<p>Continuing the story begun in The Hobbit,Sauron, the Dark Lord, has gathered to him all the Rings of Power - the means by which he intends to rule Middle-earth. All he lacks in his plans for dominion is the One Ring - the ring that rules them all - which has fallen into the hands of the hobbit, Bilbo Baggins. In a sleepy village in the Shire, young Frodo Baggins finds himself faced with an immense task, as the Ring is entrusted to his care. He must leave his home and make a perilous journey across the realms of Middle-earth to the Crack of Doom, deep inside the territories of the Dark Lord. There he must destroy the Ring forever and foil the Dark Lord in his evil purpose.</p>");
	objwin.document.write("</center>");
}