function initialize()
{
	document.getElementById("googleMap").style.display= "inherit";
	var myCenter=new google.maps.LatLng(53.3398621,-6.339993199999981);

	var mapProp = {
	center:myCenter,
	zoom:5,
	mapTypeId:google.maps.MapTypeId.ROADMAP
	};

	var map=new google.maps.Map(document.getElementById("googleMap"),mapProp);

	var marker=new google.maps.Marker({
	position:myCenter,
	});

	marker.setMap(map);

	var infowindow = new google.maps.InfoWindow({
		content:"54 Cremona Road, Ballyfermot <img src='images/googleImage.png' id='image'>"
	});

	google.maps.event.addListener(marker, 'click', function() {
	infowindow.open(map,marker);
	});

    var x = document.getElementById("googleMap");
    x.style.width= "500px";
    x.style.height= "380px";
    x.style.paddingTop= "20px"
    x.style.marginBottom= "20px"
	google.maps.event.addDomListener(window, 'load', initialize);
}

function clearSpace()
{
	document.getElementById("googleMap").innerHTML="";
	document.getElementById("googleMap").style.backgroundColor = "#E6E6E6";
	document.getElementById("googleMap").style.display = "none";
	var x = document.getElementById("googleMap");
    x.style.width= "0px";
    x.style.height= "0px";
    x.style.paddingTop= "0px"
    x.style.marginBottom= "0px"
}

function showImage(){
	clearSpace();
	document.getElementById("googleMap").innerHTML="";
	document.getElementById("googleMap").style.backgroundColor = "#E6E6E6";
	document.getElementById("photoShow").style.display= "inherit";
}

