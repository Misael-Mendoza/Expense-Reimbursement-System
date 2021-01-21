/**
 * 
 */
window.onload = function(){
	getSession();
}


function getSession(){
	let xhttp = new XMLHttpRequest();
	
	xhttp.onreadystatechange = function(){
		if(xhttp.readyState == 4 && xhttp.status == 200){
			let user = JSON.parse(xhttp.responseText);
			if (user["userId"] == 0){
				alert("Log in to view content!");
				
				window.location.replace("http://localhost:9012/html/index.html");
			}
		}
	}
	
	xhttp.open("GET", "http://localhost:9012/user/session");
	xhttp.send();
}