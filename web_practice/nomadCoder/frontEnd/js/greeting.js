const loginForm = document.querySelector("#login-form");
const loginInput = document.querySelector("#login-form input");
const h1Tag = document.querySelector("#greeting");
// #을 무조건 붙여야 한다.
const HIDDEN_CLASSNAME = "hidden";
const USERNAME_KEY = "username";


function onloginSumbit(event) {
    event.preventDefault(); // 새로고침 방지
    const userName = loginInput.value;
    if (userName === "") {
        loginForm.classList.remove(HIDDEN_CLASSNAME);
    } else {
        loginForm.classList.add(HIDDEN_CLASSNAME);
        h1Tag.classList.remove(HIDDEN_CLASSNAME);
        h1Tag.innerText = `Hello ${userName}!!`
        localStorage.setItem(USERNAME_KEY, userName);
    }
}

const savedUsername = localStorage.getItem(USERNAME_KEY);

if (savedUsername === null) {
    loginForm.classList.remove(HIDDEN_CLASSNAME);
    loginForm.addEventListener("click", onloginSumbit);
} else {
    h1Tag.classList.remove(HIDDEN_CLASSNAME);
    h1Tag.innerText = `Hello ${savedUsername}!!`
}