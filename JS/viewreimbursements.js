
function onLoad(event) {
    fetch('http://localhost:7000/currentuser', {
        'credentials': 'include',
        'method': 'GET'
    }).then((response) => {
        if (response.status === 401) {
            window.location.href = '/login.html'
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
        populateShips(reimbursements);
    })
}

function populateShips(reimbursementArray) {
    let tbody = document.querySelector('#reimbursement tbody');

    for (const reimbursement of reimbursementArray) {
        /*
        <th>Ship ID</th>
                    <th>Ship Name</th>
                    <th>Ship Age</th>
                    <th>Ship Owner First Name</th>
                    <th>Ship Owner Last Name</th>
                    <th>Ship Status</th>
        */

        let tr = document.createElement('tr');

        let reimbursementIdTd = document.createElement('td');
        reimbursementIdTd.innerHTML = reimbursement.id;

        let reimbursementNameTd = document.createElement('td');
        reimbursementNameTd.innerHTML = reimbursement.name;

        let reimbursementAgeTd = document.createElement('td');
        reimbursementAgeTd.innerHTML = reimbursement.age;

        let reimbursementAuthorFirstNameTd = document.createElement('td');
        reimbursementAuthorFirstNameTd.innerHTML = reimbursement.author.firstName;

        let reimbursementOwnerLastNameTd = document.createElement('td');
        reimbursementOwnerLastNameTd.innerHTML = reimbursement.author.lastName;

        let reimbursementStatusTd = document.createElement('td');
        reimbursementStatusTd.innerHTML = reimbursement.status.status;

        tr.appendChild( reimbursementIdTd);
        tr.appendChild( reimbursementNameTd);
        tr.appendChild( reimbursementAgeTd);
        tr.appendChild( reimbursementAuthorFirstName);
        tr.appendChild( reimbursementAuthorLastName);
        tr.appendChild( reimbursementStatus);

        tbody.appendChild(tr);
    }
}

window.addEventListener('load', onLoad);
