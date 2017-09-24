$(document).ready(function() {
  $('#body a').click(function() {
    $.getJSON('json/bodyTreatments.json', function(data) {
      $('#updateArea').empty();
      $.each(data, function(entryIndex, entry) {
        var html = '<div id="div_center" class="entry">';

        if(entry['heading']){
        	html += '<h1 class="heading">' + entry['heading'] + '</h3>';
        }

        if(entry['title']){
        	html += '<h2 class="title">'+entry['title']+'</h2>';
        }

        if(entry['part']){
        	html += '<p class="part">'+entry['part']+'</p>';
        }

        html += '</div>';
        $('#updateArea').append(html);
      });
    });
    return false;
  });
});

$(document).ready(function() {
  $('#facials a').click(function() {
    $.getJSON('json/facials.json', function(data) {
      $('#updateArea').empty();
      $.each(data, function(entryIndex, entry) {
        var html = '<div id="div_center" class="entry">';

        if(entry['heading']){
        	html += '<h1 class="heading">' + entry['heading'] + '</h3>';
        }

        if(entry['title']){
        	html += '<h2 class="title">'+entry['title']+'</h2>';
        }

        if(entry['part']){
        	html += '<p class="part">'+entry['part']+'</p>';
        }

        if(entry['list']){
        	html +='<ul>';

			$.each(entry['list'], function(lineIndex, line) {
				html += '<li>' + line + '</li>';
			});
			html +='</ul>';
        }

        html += '</div>';
        $('#updateArea').append(html);
      });
    });
    return false;
  });
});

$(document).ready(function() {
  $('#massage a').click(function() {
    $.getJSON('json/massage.json', function(data) {
      $('#updateArea').empty();
      $.each(data, function(entryIndex, entry) {
        var html = '<div id="div_center" class="entry">';

        if(entry['heading']){
        	html += '<h1 class="heading">' + entry['heading'] + '</h3>';
        }

        if(entry['title']){
        	html += '<h2 class="title">'+entry['title']+'</h2>';
        }

        if(entry['part']){
        	html += '<p class="part">'+entry['part']+'</p>';
        }

        html += '</div>';
        $('#updateArea').append(html);
      });
    });
    return false;
  });
});

$(document).ready(function() {
  $('#medi-pedi a').click(function() {
    $.getJSON('json/mediPedi.json', function(data) {
      $('#updateArea').empty();
      $.each(data, function(entryIndex, entry) {
        var html = '<div id="div_center" class="entry">';

        if(entry['heading']){
        	html += '<h1 class="heading">' + entry['heading'] + '</h3>';
        }

        if(entry['title']){
        	html += '<h2 class="title">'+entry['title']+'</h2>';
        }

        if(entry['part']){
        	html += '<p class="part">'+entry['part']+'</p>';
        }

        if(entry['list']){
        	html +='<ul>';

			$.each(entry['list'], function(lineIndex, line) {
				html += '<li>' + line + '</li>';
			});
			html +='</ul>';
        }

        html += '</div>';
        $('#updateArea').append(html);
      });
    });
    return false;
  });
});

$(document).ready(function() {
  $('#all a').click(function() {
    $.getJSON('json/nailWaxTanningBeautyTreatments.json', function(data) {
      $('#updateArea').empty();
      $.each(data, function(entryIndex, entry) {
        var html = '<div id="div_center" class="entry">';

        if(entry['heading']){
        	html += '<h1 class="heading">' + entry['heading'] + '</h3>';
        }

        if(entry['title']){
        	html += '<h2 class="title">'+entry['title']+'</h2>';
        }

        if(entry['part']){
        	html += '<p class="part">'+entry['part']+'</p>';
        }

        html += '</div>';
        $('#updateArea').append(html);
      });
    });
    return false;
  });
});

$(document).ready(function() {
  $('#bridal a').click(function() {
    $.getJSON('json/bride.json', function(data) {
      $('#updateArea').empty();
      $.each(data, function(entryIndex, entry) {
        var html = '<div id="div_center" class="entry">';

        if(entry['heading']){
        	html += '<h1 class="heading">' + entry['heading'] + '</h3>';
        }

        if(entry['title']){
        	html += '<h2 class="title">'+entry['title']+'</h2>';
        }

        if(entry['part']){
        	html += '<p class="part">'+entry['part']+'</p>';
        }

        if(entry['list']){
        	html +='<ul>';

			$.each(entry['list'], function(lineIndex, line) {
				html += '<li>' + line + '</li>';
			});
			html +='</ul>';
        }

        html += '</div>';
        $('#updateArea').append(html);
      });
    });
    return false;
  });
});
