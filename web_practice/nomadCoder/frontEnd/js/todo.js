const toDoForm = document.querySelector("#todo-form");
const toDoInput = toDoForm.querySelector("input");
const toDoList = document.querySelector("#todo-list");
const TODOS_KEY = "todos";

const toDos = [];

function saveToDos() {
    localStorage.setItem(TODOS_KEY, JSON.stringify(toDos));
}

function deleteToDo(event) {
    const li = event.target.parentElement; // 우리가 선택한 event의 li 찾음
    li.remove();
}

function paintToDo(newTodo) {
    const li = document.createElement("li");
    const span = document.createElement("span");
    span.innerText = newTodo;
    const button = document.createElement("button");
    button.innerText = "✕";
    button.addEventListener("click", deleteToDo);
    li.appendChild(span);
    li.appendChild(button);

    toDoList.appendChild(li);
}

function handleToDoSumbit(event) {
    event.preventDefault();
    const newTodo = toDoInput.value;
    toDoInput.value = "";

    toDos.push(newTodo);
    paintToDo(newTodo);

    saveToDos();
}

toDoForm.addEventListener("submit", handleToDoSumbit);

function sayHello(item){
    console.log(item);
}

const savedToDos = localStorage.getItem(TODOS_KEY);

if (saveToDos) {
    const parsedToDos = JSON.parse(savedToDos);
    // toDos = parsedToDos;
    parsedToDos.forEach(sayHello);
}