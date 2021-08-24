
function onLoad(event) {
    fetch('http://localhost:7000/currentuser', {
        'credentials': 'include',
        'method': 'GET'
    }).then((response) => {
        if (response.status === 401) {
            window.location.href = 'reimbPage.html'
        } else if (response.status === 200) {
            return response.json();
        }
    }).then((user) => {
        return fetch(`http://localhost:7000/user/${user.id}/reimbursement`, {
            'method': 'GET', 
            'credentials': 'include'
        });
    }).then((response) => {
        return response.json()
    }).then((reimbursements) => {
        populateReimbursements(reimbursements);
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
        reimbursementAuthorFirstNameTd.innerHTML = reimbursement.author.lName;

        let reimbursementAuthorLastNameTd = document.createElement('td');
        reimbursementAuthorLastNameTd.innerHTML = reimbursement.author.lName;

        let reimbursementAuthorEmailTd = document.createElement('td');
        reimbursementAuthorEmailTd.innerHTML = reimbursement.email;

        let reimbursementStatusTd = document.createElement('td');
        reimbursementStatusTd.innerHTML = reimbursement.status.status;

        tr.appendChild( reimbursementIdTd);
        tr.appendChild( reimbursementAmountTd);
        tr.appendChild( reimbursementTypeTd);
        tr.appendChild( reimbursementAuthorFirstNameTd);
        tr.appendChild( reimbursementAuthorLastNameTd);
        tr.appendChild( reimbursementStatusTd);

        tbody.appendChild(tr);
    }
}

window.addEventListener('load', onLoad);
