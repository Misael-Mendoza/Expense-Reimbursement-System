window.onload = function () {
    getData();
    getSession();
}

function getData() {
    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function () {
        if (xhttp.readyState == 4 && xhttp.status == 200) {
            let reimb = JSON.parse(xhttp.responseText);
            console.log(reimb);
            let reimbursementId = document.getElementById("username");
            reimbursementId.setAttribute("value", `${reimb["reimbId"]}`);
            let amount = document.getElementById("password");
            amount.setAttribute("value", `${reimb["amount"]}`);
            let author = document.getElementById("firstName");
            author.setAttribute("value", `${reimb["author"]}`);
            let submitted = document.getElementById("lastName");
            var date = new Date(reimb["submitted"]).toLocaleString("en-US");
            submitted.setAttribute("value", date);
            let type = document.getElementById("email");
            type.setAttribute("value", `${reimb["typeId"]}`);
            let description = document.getElementById("roles");
            description.setAttribute("value", `${reimb["description"]}`);
        }
    }
    xhttp.open("POST", "http://localhost:9012/remb/data");
    xhttp.send(`value=${localStorage["reimbId"]}`);
}

let form = document.getElementById("form");
let element = document.getElementById("decision");



form.onsubmit = function () {
    let decision = element.value;
    let xhttp = new XMLHttpRequest();
    xhttp.open("POST", "http://localhost:9012/remb/update");
    xhttp.send(`id=${localStorage["reimbId"]}&decision=${decision}`);
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