"use strict";

$(document).ready(function(){
	$("#hideCataWL").hide();
	$("#btnCreate").click(function(){
		$("#hideCataWL").toggle();
	});
	
	$("#hideWL").hide();
	$("#newWL").click(function(){
		$("#hideWL").toggle();
	});
});

