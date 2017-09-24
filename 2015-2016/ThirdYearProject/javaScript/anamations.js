/*$(document).ready(function(){
	$("input").animate({
		opacity: '0.1',
		height: '100px',
		width: '100px'
	});
	$("input").animate({
		opacity: '1.0',
		height: '150px',
		width: '150px'
	});
});*/

function transition(pageName)
{
	document.getElementById('container').className = 'animated fadeOutRight';//
	document.getElementById('nav').className = 'animated fadeOutUpBig';//
	setTimeout(function(){window.location.href=pageName;},800);//0.8 of a sec
}

function quizTransition()
{
	document.getElementById('anime').className = 'animated fadeOutRight';
	setTimeout(function(){document.getElementById('anime').className = 'animated fadeInLeft';},800);//0.8 of a sec
	document.getElementById('anime').className = 'animated fadeInLeft';//
}