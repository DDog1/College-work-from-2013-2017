$(function() {

           $("#div img").hover(

            function(){

                var offset = $("#tooltip1").offset();
                $("#tooltip1").css("top", offset.top).css("left", offset.left).css("display", "block");
                $("#tooltip1").animate({ opacity: 1.0}, 300);
            },

            function(){
                $("#tooltip1").animate({ opacity: 0.0}, 300, function() {
                    $("#tooltip1").css("display", "none");
                });
            });

      });