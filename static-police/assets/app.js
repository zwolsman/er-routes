$(function () {
    var map = L.map('mapid').setView([47.516231, 14.550072], 8)
    L.tileLayer('https://api.tiles.mapbox.com/v4/{id}/{z}/{x}/{y}.png?access_token={accessToken}', {
        attribution: 'Map data &copy <a href="http://openstreetmap.org">OpenStreetMap</a> contributors, <a href="http://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, Imagery © <a href="http://mapbox.com">Mapbox</a>',
        maxZoom: 18,
        id: 'mapbox.streets',
        accessToken: 'pk.eyJ1IjoibXVyZnp3IiwiYSI6ImNqZHluaDUyMDFkcDQycXM0cHRuc2VsbWgifQ.j8GNzXpH9zA-eAMa36h9cg'
    }).addTo(map)
})