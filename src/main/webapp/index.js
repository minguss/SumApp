
xhrGet("pod", function(responseText){
	var mytitle = document.getElementById('pod');
	mytitle.innerHTML = responseText;

}, function(err){
	console.log(err);
});

function sum(){
	var elm = document.getElementById('op1');
	var op1 = elm.value;
	elm = document.getElementById('op2');
	var op2 = elm.value;
	xhrPost( 'add', op1, op2, function(value){
			var result = document.getElementById('result');
			result.innerHTML = value;
		},
		function(err) {
			var result = document.getElementById('result');
			result.innerHTML = err;
	});
}


function createXHR(){
	if(typeof XMLHttpRequest != 'undefined'){
		return new XMLHttpRequest();
	}else{
		try{
			return new ActiveXObject('Msxml2.XMLHTTP');
		}catch(e){
			try{
				return new ActiveXObject('Microsoft.XMLHTTP');
			}catch(e){}
		}
	}
	return null;
}
function xhrGet(url, callback, errback){
	var xhr = new createXHR();
	xhr.open("GET", url, true);
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){
			if(xhr.status == 200 ){
				callback(xhr.responseText);
			} else {
				errback('service not available');
			}
		}
	};
	xhr.timeout = 3000; 
	xhr.ontimeout = errback;
	xhr.send();
}
function xhrPost(url, op1, op2, callback, errback){
	var xhr = new createXHR();
	var params = "op1=" + op1 + "&op2=" + op2;
	xhr.open("POST", url, true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){
			if(xhr.status == 200 ){
				callback(xhr.responseText);
			} else {
				errback('service not available');
			} 
		}
	};
	xhr.timeout = 20000; // 20 seconds for demo in debugger
	xhr.ontimeout = errback;
	xhr.send(params);
}
function parseJson(str){
	return window.JSON ? JSON.parse(str) : eval('(' + str + ')');
}
function prettyJson(str){
	// If browser does not have JSON utilities, just print the raw string value.
	return window.JSON ? JSON.stringify(JSON.parse(str), null, '  ') : str;
}


