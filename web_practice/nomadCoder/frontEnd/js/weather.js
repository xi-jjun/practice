const API_KEY = "지웠다"; // 나중에 지워야 함.

function onGeoOk(position) {
    const lat = position.coords.latitude;
    const lon = position.coords.longitude;
    const url = `https://api.openweathermap.org/data/2.5/weather?lat=${lat}&lon=${lon}&appid=${API_KEY}&units=metric`;

    fetch(url).then(response => response.json()).then(data => {
        const weather = document.querySelector("#weather span:first-child");
        const city = document.querySelector("#weather span:last-child");

        weather.innerText = data.weather[0].main;
        city.innerText = data.name;
    }); // call url.then(json get).
}
function onGeoError() {
    alert("We can't get your location!");
}

navigator.geolocation.getCurrentPosition(onGeoOk, onGeoError);