
function onLoad(event) {
    fetch(' http://localhost:7000/currentuser', {
        'credentials': 'include',
        'method': 'GET'
    }).then((response) => {
        if (response.status === 401) {
            window.location.href = 'mainPage.html'
        } else if (response.status === 200) {
            return response.json();
        }
    }).then((user) => {
        return fetch(`http://localhost:7000/reimbursement`, {
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
    let tbody = document.querySelector('#reimbursements tbody');

    for (const reimbursement of
        
        reimbursementArray) {

           // alert(reimbursement.id);
        let tr = document.createElement('tr');

        let reimbursementIdTd = document.createElement('td');
        reimbursementIdTd.innerHTML = reimbursement.id;

        let reimbursementAmountTd = document.createElement('td');
        reimbursementAmountTd.innerHTML = reimbursement.reimbAmount;

        let reimbursementTypeTd = document.createElement('td');
        reimbursementTypeTd.innerHTML = reimbursement.reimbType.reimbType;

        let reimbursementDiscriptionTd = document.createElement('td');
        reimbursementDiscriptionTd.innerHTML = reimbursement.reimbDiscription;


        let reimbursementStatusTd = document.createElement('td');
        reimbursementStatusTd.innerHTML = reimbursement.reimbStatus.reimbStatus;

        let reimbursementSubmittedTd = document.createElement('td');
        reimbursementSubmittedTd.innerHTML = new Date(reimbursement.reimbuSubmitted);

        let reimbursementResolverTd = document.createElement('td');
        reimbursementResolverTd.innerHTML = new Date(reimbursement.reimbResolved);

       tr.appendChild(reimbursementIdTd);
        tr.appendChild(reimbursementAmountTd);
        tr.appendChild(reimbursementTypeTd);
        tr.appendChild(reimbursementDiscriptionTd);
        tr.appendChild(reimbursementStatusTd);
        tr.appendChild(reimbursementSubmittedTd);
        tr.appendChild(reimbursementResolverTd);
        
        tbody.appendChild(tr);
    }
}

window.addEventListener('load', onLoad);
