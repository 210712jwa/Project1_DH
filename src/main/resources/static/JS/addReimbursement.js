let submitButton = document.getElementById('submitButton');
let amountinput = document.getElementById('amount');
let typeinput = document.getElementById('type');
let descriptioninput = document.getElementById('discription');

function submit(event) {
        event.preventDefault();
    
        const sessionInfo = {
            "amount" : amountinput.value,
            "discription" : descriptioninput.value,
            "type" : typeinput.value
        };

        // currently losing user in this process
        fetch('http://localhost:7000/currentuser', {  
        'credentails' : 'include',
        'method' : 'GET',
    }).then((response) => {
        if (response.status === 200) {
            alert("about to adding reimburesment record");
            return response.json();
        } else if (response.status === 401) {
            window.location.href = 'mainPage.html';
        }
    }).then((user) => {
        return fetch(`http://localhost:7000/user/${user.id}/reimbursement`, {
        'credentails' : 'include',   
        'method' : 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(sessionInfo)
        });
    }).then((response) => {
        if (response.status === 200) {
            
            window.location.href = 'managerPage.html';
        }else {
            alert("error adding reimburesment record");
        }

        // }).then((user) => {
//     if(user.userRole.id === 1) {
//         window.location.href = 'managerPage.html';
//     } else if ((user.userRole.id === 2 ){
//         window.location.href = 'employeePage.html';
//     }
    })      
};

function checkIfUserCurrentlyLoggedIn(event){
    fetch ('http://localhost:7000/currentuser',{
        'credentials' : 'include',
        'method' : 'GET'
    }).then((response) => {
        if(response.status === 401){
            window.location.href = 'index.html'
        } else if (response.status === 200){
           return response.json();
            }
        })
    }


window.addEventListener('load', checkIfUserCurrentlyLoggedIn)
submitButton.addEventListener('click', submit)