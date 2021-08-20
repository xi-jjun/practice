const images = ["./img/0.jpeg", "./img/1.jpeg", "./img/2.jpeg", "./img/3.jpg"];
const IMG_NUMBER = images.length;
const bg = document.getElementById("bg1");
const body = document.querySelector("body");
console.log(bg);
const chosenImage = images[Math.floor(Math.random() * images.length)]; // random number create
// background-repeat : no-repeat;
//     background-size : cover;
const sytle1 = "background-repeat : no-repeat; background-size : cover;";
const bgImage = "url('" + chosenImage + "')";

body.style.backgroundImage = bgImage;
// body.style.backgroundColor = "background-color: transparent;"



// const paintBgImage = (imgNumber) => {
//     const bgImage = "url('" + images[imgNumber] + "')";
//     body.style.backgroundImage = bgImage;
// }

// const bgImage = document.createElement("img");

// bgImage.src = `img/${chosenImage}`;

// document.body.appendChild(bgImage);