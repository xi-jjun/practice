const toDoForm = document.getElementById("todo-form");
const toDoInput = document.querySelector("#todo-form input");
const toDoList = document.getElementById("todo-list");

const TODOS_KEY = "todos";

let toDos = []; // todo list. const로 돼있으면 local storage에 덮어쓰기 되버리낟.

function saveToDos() {
    localStorage.setItem(TODOS_KEY, JSON.stringify(toDos));
}



function deleteToDo(event) {
    const li = event.target.parentElement; // 우리가 선택한 event의 li 찾음
    // const deleteId = li.id;
    li.remove();

    toDos = toDos.filter((toDo) => toDo.id !== parseInt(li.id)); // li.id: String
    saveToDos();
}

function paintToDo(newTodo) { // 이제 newTodo == object
    const li = document.createElement("li");
    li.id = newTodo.id;
    const span = document.createElement("span");
    span.innerText = newTodo.text;
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
    const newTodoObj ={
        text: newTodo,
        id: Date.now(),
    };

    toDos.push(newTodoObj); // 매번 DB에서 사용자가 적어준 data push한다.
    paintToDo(newTodoObj);

    saveToDos();
}

toDoForm.addEventListener("submit", handleToDoSumbit);

// function sayHello(item){
//     console.log(item);
// }

const savedToDos = localStorage.getItem(TODOS_KEY);

if (savedToDos !== null) {
    const parsedToDos = JSON.parse(savedToDos);
    toDos = parsedToDos; // local storage에 있는 toDo list 가져옴.
    // if(paintToDo !== null)
    parsedToDos.forEach(paintToDo); // painting list on web page
    // forEach가 parsedToDos list의 요소만큼 paintToDo에 넣어 실행시킴.
}