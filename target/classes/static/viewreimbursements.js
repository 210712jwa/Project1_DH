
function onLoad(event) {
    fetch('http://127.0.0.1:7000/currentuser', {
        'credentials': 'include',
        'method': 'GET'
    }).then((response) => {
        if (response.status === 401) {
            window.location.href = 'reimbPage.html'
        } else if (response.status === 200) {
            return response.json();
        }
    }).then((user) => {
        return fetch(`http://127.0.0.1:7000/user/${user.id}/reimbursement`, {
            'method': 'GET', 
            'credentials': 'include'
        });
    }).then((response) => {
        return response.json()
    }).then((reimbursements) => {
        populateReimbursementss(reimbursements);
    })
}

function populateReimbursements(reimbursementArray) {
    let tbody = document.querySelector('#reimbursement tbody');

    for (const reimbursement of reimbursementArray) {


        let tr = document.createElement('tr');

        let reimbursementIdTd = document.createElement('td');
        reimbursementIdTd.innerHTML = reimbursement.id;

        let reimbursementAmountTd = document.createElement('td');
        reimbursementAmountTd.innerHTML = reimbursement.name;

        let reimbursementTypeTd = document.createElement('td');
        reimbursementTypeTd.innerHTML = reimbursement.age;

        let reimbursementAuthorFirstNameTd = document.createElement('td');
        reimbursementAuthorFirstNameTd.innerHTML = reimbursement.author.firstName;

        let reimbursementAuthorLastNameTd = document.createElement('td');
        reimbursementAuthorLastNameTd.innerHTML = reimbursement.author.lastName;

        let reimbursementAuthorEmailTd = document.createElement('td');
        reimbursementAuthorEmailTd.innerHTML = reimbursement.age;

        let reimbursementStatusTd = document.createElement('td');
        reimbursementStatusTd.innerHTML = reimbursement.status.status;

        tr.appendChild( reimbursementIdTd);
        tr.appendChild( reimbursementAmountTd);
        tr.appendChild( reimbursementTypeTd);
        tr.appendChild( reimbursementAuthorFirstName);
        tr.appendChild( reimbursementAuthorLastName);
        tr.appendChild( reimbursementStatus);

        tbody.appendChild(tr);
    }
}

window.addEventListener('load', onLoad);
