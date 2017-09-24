$(function() {
$("a:has(img.gallery)").click(function() {
var largePath = $(this).attr("href");
var caption = $(this).attr("title");

$("#photoLarge").attr({src: largePath });
$("#caption").text(caption);
return false;
});
});