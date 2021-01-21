/**
 * 
 */
let filter;

window.onload = function () {
	filter_field.value = window.localStorage.getItem("filter");
	filter = filter_field.value;

	let table = document.querySelector("tbody");
	getData(table);
	getSession();
}

function displayAll(table, data) {
	for (let element of data) {
		let row = table.insertRow();
		row.setAttribute("data-href", "http://localhost:9012/html/Reimbursement.html");
		let cell = row.insertCell();
		let text = document.createTextNode(element["reimbId"]);
		cell.appendChild(text);
		row.className = element["reimbId"];
		for (key in element) {
			if (key == "reimbId") {
				continue;
			}
			let cell = row.insertCell();
			if (key == "statusId") {
				cell.className = element["statusId"];
			}
			if (key == "submitted" || key == "resolved") {
				if (element[key] == null) {
					notResolved = "Not Resolved";
					text = document.createTextNode(notResolved);
				} else {
					var date = new Date(element[key]).toLocaleString("en-US");
					text = document.createTextNode(date);

				}
			} else if (key == "amount") {
				text = document.createTextNode("$".concat(element[key]));
			} else {
				text = document.createTextNode(element[key]);
			}
			cell.appendChild(text);

		}
	}
}

function displayedFiltered(table, data, filter) {
	for (let element of data) {
		if (filter != element["statusId"]) {
			continue;
		}
		let row = table.insertRow();
		row.setAttribute("data-href", "http://localhost:9012/html/Reimbursement.html");
		let cell = row.insertCell();
		let text = document.createTextNode(element["reimbId"]);
		cell.appendChild(text);
		row.className = element["reimbId"];
		for (key in element) {
			if (key == "reimbId") {
				continue;
			}
			let cell = row.insertCell();
			if (key == "statusId") {
				cell.className = element["statusId"];
			}
			if (key == "submitted" || key == "resolved") {
				if (element[key] == null) {
					notResolved = "Not Resolved";
					text = document.createTextNode(notResolved);
				} else {
					var date = new Date(element[key]).toLocaleString("en-US");
					text = document.createTextNode(date);

				}
			} else if (key == "amount") {
				text = document.createTextNode("$".concat(element[key]));
			} else {
				text = document.createTextNode(element[key]);
			}
			cell.appendChild(text);

		}
	}
}

function generateTable(table, data, filter) {
	if (filter == "All") {
		displayAll(table, data);
	} else {
		displayedFiltered(table, data, filter);
	}

	const rows = document.querySelectorAll("tr[data-href]");
	rows.forEach(row => {
		row.addEventListener("click", () => {
			localStorage["reimbId"] = row.className;
			window.location.href = row.dataset.href;
		});

	});
}


function getData(table) {
	let xhttp = new XMLHttpRequest();

	xhttp.onreadystatechange = function () {
		if (xhttp.readyState == 4 && xhttp.status == 200) {
			let data = JSON.parse(xhttp.responseText);
			generateTable(table, data, filter);

		}
	}
	xhttp.open("GET", "http://localhost:9012/manger/data");
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

let filter_field = document.querySelector(".filter-reimb");
filter_field.addEventListener("change", (Event) => {
	window.localStorage.setItem("filter", Event.target.value);
	location.reload();
});