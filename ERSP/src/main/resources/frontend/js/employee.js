/**
 * 
 */
window.onload = function () {
	let table = document.querySelector("tbody");
	getData(table);
	getSession();
}



function generateTable(table, data) {
	for (let element of data) {
		let row = table.insertRow();
		let cell = row.insertCell();
		let text = document.createTextNode(element["reimbId"]);
		cell.appendChild(text);
		for (key in element) {
			if (key == "reimbId") {
				continue;
			}
			let cell = row.insertCell();
			if (key == "statusId") {
				cell.className = element["statusId"];
			} else {
				cell.className = `${element["reimbId"]}`;
			}

			if (key == "submitted" || key == "resolved") {
				if (element[key] == null) {
					notResolved = "Not Resolved";
					let text = document.createTextNode(notResolved);
					cell.appendChild(text);
				} else {
					var date = new Date(element[key]).toLocaleString("en-US");
					let text = document.createTextNode(date);
					cell.appendChild(text);
				}
			} else if (key == "amount") {
				let text = document.createTextNode("$".concat(element[key]));
				cell.appendChild(text);
			} else {
				let text = document.createTextNode(element[key]);

				cell.appendChild(text);
			}


		}
	}
}

function getData(table) {
	let xhttp = new XMLHttpRequest();

	xhttp.onreadystatechange = function () {
		if (xhttp.readyState == 4 && xhttp.status == 200) {
			let data = JSON.parse(xhttp.responseText);
			generateTable(table, data);

		}
	}
	xhttp.open("GET", "http://localhost:9012/reimbursement/data");
	xhttp.send();
}

function getSession() {
	let xhttp = new XMLHttpRequest();

	xhttp.onreadystatechange = function () {
		if (xhttp.readyState == 4 && xhttp.status == 200) {
			let user = JSON.parse(xhttp.responseText);
			if (user["userId"] == 0) {
				alert("Log in to view content!");
				window.location.replace("http://localhost:9012/html/index.html");
			}
		}
	}

	xhttp.open("GET", "http://localhost:9012/user/session");
	xhttp.send();
}

