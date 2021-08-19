function onGeoOk(position) {
    console.log(position);
}
function onGeoError() {
    alert("We can't get your location!");
}

navigator.geolocation.getCurrentPosition(onGeoOk, onGeoError);