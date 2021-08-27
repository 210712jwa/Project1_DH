let loginButton = document.getElementById('login');
let usernameInput = document.getElementById('username');
let passwordInput = document.getElementById('password');

function login(event) {
    event.preventDefault(); // this will prevent the default behavior of what happens when 
    // a button inside a form element is clicked

    const loginInfo = {
        'username': usernameInput.value,
        'password': passwordInput.value
    };

    fetch('http://localhost:7000/login', {  // can change to local host , but have to change in html as well.
        method: 'POST',
        credentials: 'include', // this specifies that when you receive cookies,
        // you should include them in future requests.
        headers: {
            'Content-Type': 'application/json' // application/json is a MIME type, use for recipe information
        },
        body: JSON.stringify(loginInfo)
    }).then((response) => {
        if (response.status === 200) {
            window.location.href = 'managerPage.html';
        } else if (response.status === 400) {
            displayInvalidLogin();
        }
        
    })
// }).then((user) => {
//     if(user.userRole.id === 1) {
//         window.location.href = 'managerPage.html';
//     } else if ((user.userRole.id === 2 ){
//         window.location.href = 'employeePage.html';
//     }
};

function displayInvalidLogin() {
    let loginForm = document.getElementById('loginform');

    let p = document.createElement('p');
    p.style.color = 'red';
    p.innerHTML = 'INVALID LOGIN!';

    loginForm.appendChild(p);
};

function checkIfUserCurrentlyLoggedIn(event) {
    fetch('http://localhost:7000/currentuser', {
        'credentials': 'include',
        'method': 'GET'
    }).then((response) => {
        if (response.status === 200) {
            window.location.href = 'managerPage.html';
        }
    });
}

loginButton.addEventListener('click', login);
window.addEventListener('load', checkIfUserCurrentlyLoggedIn)
